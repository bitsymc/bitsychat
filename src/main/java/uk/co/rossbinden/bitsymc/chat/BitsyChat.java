package uk.co.rossbinden.bitsymc.chat;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.rossbinden.bitsymc.chat.bitscord.Bitscord;
import uk.co.rossbinden.bitsymc.chat.dispatcher.*;
import uk.co.rossbinden.bitsymc.chat.listener.AsyncPlayerChatListener;
import uk.co.rossbinden.bitsymc.chat.listener.DynmapWebChatListener;

import javax.security.auth.login.LoginException;
import java.util.logging.Level;

public final class BitsyChat extends JavaPlugin {

    private Bitscord bitscord;
    private ChatDispatcher dispatcher;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new AsyncPlayerChatListener(this), this);
        pluginManager.registerEvents(new DynmapWebChatListener(this), this);

        try {
            this.bitscord = new Bitscord(this);
        } catch (LoginException exception) {
            getLogger().log(Level.SEVERE, "Failed to connect to Bitscord", exception);
        }

        this.dispatcher = new AggregateChatDispatcher(
                new BitscordChatDispatcher(this),
                new MinecraftChatDispatcher(this),
                new DynmapChatDispatcher(this)
        );
    }

    public Bitscord getBitscord() {
        return bitscord;
    }

    public ChatDispatcher getDispatcher() {
        return dispatcher;
    }

}
