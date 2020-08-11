package aquarius0715.autotrash.gui

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class CreateCheckInventory(private val plugin: AutoTrash) {

    fun createCheckInventory(player: Player) {

        plugin.createSetInventory.checkInv = Bukkit.createInventory(null, 9, "${ChatColor.GREEN}${ChatColor.BOLD}自動削除対象アイテムの確認")

        for ((count, material) in plugin.playerMap[player.uniqueId]!!.withIndex()) {

            plugin.createSetInventory.checkInv.setItem(count, ItemStack(material, 1))

        }

        player.openInventory(plugin.createSetInventory.checkInv)

    }

}