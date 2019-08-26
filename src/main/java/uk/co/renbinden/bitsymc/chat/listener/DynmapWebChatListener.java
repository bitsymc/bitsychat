package uk.co.renbinden.bitsymc.chat.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.dynmap.DynmapWebChatEvent;
import uk.co.renbinden.bitsymc.chat.message.ChatMessage;
import uk.co.renbinden.bitsymc.chat.message.ChatSource;
import uk.co.renbinden.bitsymc.chat.BitsyChat;

public final class DynmapWebChatListener implements Listener {

    private final BitsyChat plugin;

    public DynmapWebChatListener(BitsyChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDynmapWebChat(DynmapWebChatEvent event) {
        event.setCancelled(true);
        plugin.getDispatcher().send(new ChatMessage(
                ChatSource.DYNMAP,
                event.getName(),
                event.getMessage()
        ));
    }

}
