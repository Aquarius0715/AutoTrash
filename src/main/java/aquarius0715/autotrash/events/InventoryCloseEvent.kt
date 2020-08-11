package aquarius0715.autotrash.events

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent

class InventoryCloseEvent(private val plugin: AutoTrash): Listener {

    @EventHandler

    fun onCloseInventory(event: InventoryCloseEvent) {

        if (!plugin.pluginStats) return

        val materialList: MutableList<Material> = mutableListOf()

        if (event.inventory != plugin.createSetInventory.setInv) return

        for (count in 0..8) {

            if (event.inventory.getItem(count) == null) {

                continue

            }

            materialList.add(event.inventory.getItem(count)!!.type)

        }

        plugin.materialList.distinct()

        plugin.playerMap[event.player.uniqueId] = materialList

        for (material in plugin.playerMap[event.player.uniqueId]!!) {

            event.player.sendMessage("${plugin.prefix}${material}がAutoTrashの対象になりました。")

        }

    }

}