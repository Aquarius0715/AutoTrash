package aquarius0715.autotrash.events

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinEvent(val plugin: AutoTrash): Listener {

    @EventHandler

    fun onJoin(event: PlayerJoinEvent) {

        plugin.insertDefaultTable.insertDefaultTable(event.player)

        val materialList: MutableList<Material> = mutableListOf()

        for (count in 0..8) {

            materialList.add(Material.AIR)

        }

        plugin.playerMap[event.player.uniqueId] = materialList

    }

}