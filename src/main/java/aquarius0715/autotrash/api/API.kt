package aquarius0715.autotrash.api

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.ChatColor
import java.util.*

class API(val plugin: AutoTrash) {

    fun getProfile(uuid: UUID): String {

        return "${ChatColor.AQUA}${ChatColor.BOLD}Profile${plugin.createProfileInventory.profileMap[uuid]}"

    }

}