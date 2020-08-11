package aquarius0715.autotrash.gui

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

class CreateSetInventory {

    lateinit var setInv: Inventory

    lateinit var checkInv: Inventory

    fun createSetInventory(player: Player) {

        setInv = Bukkit.createInventory(null, 9, "${ChatColor.DARK_GRAY}${ChatColor.BOLD}Auto${ChatColor.GRAY}${ChatColor.BOLD}Trash")

        player.openInventory(setInv)

    }

}