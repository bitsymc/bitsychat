package uk.co.renbinden.bitsymc.chat.dispatcher;

import uk.co.renbinden.bitsymc.chat.message.ChatMessage;

public interface ChatDispatcher {

    void send(ChatMessage message);

}
