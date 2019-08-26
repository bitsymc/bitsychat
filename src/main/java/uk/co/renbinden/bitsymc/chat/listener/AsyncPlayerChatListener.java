package uk.co.renbinden.bitsymc.chat.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import uk.co.renbinden.bitsymc.chat.BitsyChat;
import uk.co.renbinden.bitsymc.chat.message.ChatMessage;
import uk.co.renbinden.bitsymc.chat.message.ChatSource;

public final class AsyncPlayerChatListener implements Listener {

    private final BitsyChat plugin;

    public AsyncPlayerChatListener(BitsyChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true);
        plugin.getDispatcher().send(new ChatMessage(
                ChatSource.MINECRAFT,
                event.getPlayer().getDisplayName(),
                event.getMessage()
        ));
    }

}
