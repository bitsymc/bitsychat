package uk.co.renbinden.bitsymc.chat.dispatcher;

import uk.co.renbinden.bitsymc.chat.BitsyChat;
import uk.co.renbinden.bitsymc.chat.message.ChatMessage;
import uk.co.renbinden.bitsymc.chat.message.ChatSource;

public class BitscordChatDispatcher implements ChatDispatcher {

    private final BitsyChat plugin;

    public BitscordChatDispatcher(BitsyChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public void send(ChatMessage message) {
        if (message.getSource() == ChatSource.BITSCORD) return;
        plugin.getBitscord().sendMessage(message);
    }

}
