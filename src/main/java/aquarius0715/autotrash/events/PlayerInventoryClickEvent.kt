package aquarius0715.autotrash.events

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class PlayerInventoryClickEvent(private val plugin: AutoTrash): Listener {

    @EventHandler

    fun onCheckInvClick(event: InventoryClickEvent) {

        if (event.inventory != plugin.createCheckInventory.checkInv) return
        if (event.currentItem == null) return
        if (event.currentItem!!.itemMeta == null) return

        event.isCancelled = true

    }

}