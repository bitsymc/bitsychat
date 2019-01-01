package uk.co.rossbinden.bitsymc.chat.dispatcher;

import uk.co.rossbinden.bitsymc.chat.BitsyChat;
import uk.co.rossbinden.bitsymc.chat.message.ChatMessage;

public class MinecraftChatDispatcher implements ChatDispatcher {

    private final BitsyChat plugin;

    public MinecraftChatDispatcher(BitsyChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public void send(ChatMessage message) {
        plugin.getServer().broadcastMessage(message.format(plugin.getConfig().getString("chat-sources." + message.getSource().toString().toLowerCase() + ".format")));
    }

}
