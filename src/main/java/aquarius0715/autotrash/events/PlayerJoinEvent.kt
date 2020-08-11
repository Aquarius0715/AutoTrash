package aquarius0715.autotrash.events

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinEvent(private val plugin: AutoTrash): Listener {

    @EventHandler

    fun onJoin(event: PlayerJoinEvent) {

        plugin.playerMap.putIfAbsent(event.player.uniqueId, plugin.materialList)

    }

}