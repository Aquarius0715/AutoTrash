package aquarius0715.autotrash.gui

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class CreateCheckInventory(private val plugin: AutoTrash) {

    var checkInv: Inventory = Bukkit.createInventory(null, 9, "${ChatColor.GREEN}${ChatColor.BOLD}自動削除対象アイテムの確認")

    fun createCheckInventory(player: Player) {

        for ((count, material) in plugin.playerMap[player.uniqueId]!!.withIndex()) {

            checkInv.setItem(count, ItemStack(material, 1))

        }

        player.openInventory(checkInv)

    }

}