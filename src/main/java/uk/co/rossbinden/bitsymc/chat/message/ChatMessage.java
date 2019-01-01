package uk.co.rossbinden.bitsymc.chat.message;

import org.bukkit.ChatColor;

public class ChatMessage {

    private final ChatSource source;
    private final String sender;
    private final String message;

    public ChatMessage(ChatSource source, String sender, String message) {
        this.source = source;
        this.sender = sender;
        this.message = message;
    }

    public ChatSource getSource() {
        return source;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String format(String format) {
        return ChatColor.translateAlternateColorCodes('&', String.format(format, getSender(), getMessage()));
    }

}
