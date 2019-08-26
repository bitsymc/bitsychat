package uk.co.renbinden.bitsymc.chat.dispatcher;

import uk.co.renbinden.bitsymc.chat.message.ChatMessage;

public class AggregateChatDispatcher implements ChatDispatcher {

    private final ChatDispatcher[] dispatchers;

    public AggregateChatDispatcher(ChatDispatcher... dispatchers) {
        this.dispatchers = dispatchers;
    }

    @Override
    public void send(ChatMessage message) {
        for (ChatDispatcher dispatcher : dispatchers) {
            dispatcher.send(message);
        }
    }
}
