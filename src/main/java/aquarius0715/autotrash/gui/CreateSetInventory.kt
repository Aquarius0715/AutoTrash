package aquarius0715.autotrash.gui

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

class CreateSetInventory {

    var setLocalInventory: Inventory = Bukkit.createInventory(null, 9, "${ChatColor.DARK_GRAY}${ChatColor.BOLD}Auto${ChatColor.GRAY}${ChatColor.BOLD}Trash")

    var setProfileInventory: Inventory = Bukkit.createInventory(null, 9, "${ChatColor.DARK_GRAY}${ChatColor.BOLD}Auto${ChatColor.GRAY}${ChatColor.BOLD}Trash")


    fun createSetInventory(player: Player) {

        setLocalInventory = Bukkit.createInventory(null, 9, "${ChatColor.DARK_GRAY}${ChatColor.BOLD}Auto${ChatColor.GRAY}${ChatColor.BOLD}Trash")

        player.openInventory(setLocalInventory)

    }

    fun createSetProfileInventory(player: Player) {

        setProfileInventory = Bukkit.createInventory(null, 9, "${ChatColor.YELLOW}${ChatColor.BOLD}登録したいアイテムを入れてください。")

        player.openInventory(setProfileInventory)

    }

}