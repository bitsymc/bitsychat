package uk.co.rossbinden.bitsymc.chat.bitscord;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.bukkit.ChatColor;
import uk.co.rossbinden.bitsymc.chat.BitsyChat;
import uk.co.rossbinden.bitsymc.chat.message.ChatMessage;
import uk.co.rossbinden.bitsymc.chat.message.ChatSource;

import javax.security.auth.login.LoginException;

public final class Bitscord extends ListenerAdapter {

    private final BitsyChat plugin;
    private final JDA jda;
    private boolean ready;

    public Bitscord(BitsyChat plugin) throws LoginException {
        this.plugin = plugin;
        this.jda = new JDABuilder(plugin.getConfig().getString("discord.token")).build();
        jda.addEventListener(this);
        ready = false;
    }

    @Override
    public void onReady(ReadyEvent event) {
        ready = true;
        plugin.getLogger().info("Connected to the Bitscord!");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        if (author == jda.getSelfUser()) return;
        if (!event.getChannel().getName().equalsIgnoreCase(plugin.getConfig().getString("discord.channel"))) return;
        ChatMessage message = new ChatMessage(ChatSource.BITSCORD, author.getName(), event.getMessage().getContentStripped());
        plugin.getDispatcher().send(message);
    }



    public void sendMessage(ChatMessage message) {
        if (!ready) return;
        jda.getGuildsByName(plugin.getConfig().getString("discord.guild"), true).forEach(guild ->
                guild.getTextChannelsByName(plugin.getConfig().getString("discord.channel"), true).forEach(channel -> {
                    channel.sendMessage(
                            ChatColor.stripColor(
                                    message.format(plugin.getConfig().getString("chat-sources." + message.getSource().toString().toLowerCase() + ".format"))
                            )
                    ).queue();
                }));
    }

}
