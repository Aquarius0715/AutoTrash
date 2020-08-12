package aquarius0715.autotrash.events

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerPickupItemEvent

class PlayerItemPickEvent(private val plugin: AutoTrash): Listener {
    @EventHandler
    fun onPickUp(event: PlayerPickupItemEvent) {

        if (!plugin.pluginStats) return

            if (plugin.playerMap[event.player.uniqueId]?.contains(event.item.itemStack.type)!!) {

                event.item.remove()

                event.isCancelled = true

                event.item.remove()

        }

    }

}