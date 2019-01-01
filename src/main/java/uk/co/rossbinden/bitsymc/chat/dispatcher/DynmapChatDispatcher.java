package uk.co.rossbinden.bitsymc.chat.dispatcher;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.dynmap.DynmapAPI;
import uk.co.rossbinden.bitsymc.chat.BitsyChat;
import uk.co.rossbinden.bitsymc.chat.message.ChatMessage;
import uk.co.rossbinden.bitsymc.chat.message.ChatSource;

public class DynmapChatDispatcher implements ChatDispatcher {

    private final BitsyChat plugin;
    private final DynmapAPI dynmap;

    public DynmapChatDispatcher(BitsyChat plugin) {
        this.plugin = plugin;

        Plugin dynmapPlugin = plugin.getServer().getPluginManager().getPlugin("dynmap");
        if (dynmapPlugin == null) {
            throw new IllegalStateException("Dynmap unavailable");
        } else {
            dynmap = (DynmapAPI) dynmapPlugin;
        }
    }

    @Override
    public void send(ChatMessage message) {
        if (message.getSource() == ChatSource.MINECRAFT) {
            Player player = plugin.getServer().getPlayer(message.getSender());
            if (player != null) {
                dynmap.postPlayerMessageToWeb(player, message.getMessage());
            } else {
                dynmap.sendBroadcastToWeb(message.getSender(), message.getMessage());
            }
        } else {
            dynmap.sendBroadcastToWeb(message.getSender(), message.getMessage());
        }
    }

}
