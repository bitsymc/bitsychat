package uk.co.rossbinden.bitsymc.chat.dispatcher;

import uk.co.rossbinden.bitsymc.chat.message.ChatMessage;

public interface ChatDispatcher {

    void send(ChatMessage message);

}
