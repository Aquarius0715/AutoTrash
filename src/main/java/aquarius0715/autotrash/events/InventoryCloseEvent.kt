package aquarius0715.autotrash.events

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.ItemStack

class InventoryCloseEvent(private val plugin: AutoTrash): Listener {

    @EventHandler

    fun onClockSetLocalInventory(event: InventoryCloseEvent) {

        if (!plugin.pluginStats) return

        val materialList: MutableList<Material> = mutableListOf()

        if (event.inventory != plugin.createSetInventory.setLocalInventory) return

        for (count in 0..8) {

            if (event.inventory.getItem(count) == null) {

                continue

            }

            materialList.add(event.inventory.getItem(count)!!.type)

        }

        materialList.distinct()

            plugin.playerMap[event.player.uniqueId] = materialList

        for (material in materialList) {

            event.player.sendMessage("${plugin.prefix}${material}がAutoTrashの対象になりました。")

        }

    }

    @EventHandler

    fun onCloseSetProfileInventory(event: InventoryCloseEvent) {

        if (!plugin.pluginStats) return

        val materialList: MutableList<Material> = mutableListOf()

        val base64List: MutableList<String> = mutableListOf()

        if (event.inventory != plugin.createSetInventory.setProfileInventory) return

        for (count in 0..8) {

            if (event.inventory.getItem(count) == null) {

                continue

            }

            materialList.add(event.inventory.getItem(count)!!.type)

        }

        materialList.distinct()

        for (material in materialList) {

            base64List.add(plugin.convertItems.itemToBase64(ItemStack(material, 1)))

        }

        plugin.upDateProfile.updateProfile(plugin.createProfileInventory.profileMap[event.player.uniqueId], base64List, event.player as Player)

        for (material in materialList) {

            event.player.sendMessage("${plugin.prefix}${material}をプロファイルに登録しました。")

        }

        event.player.sendMessage("${plugin.prefix}プロファイルを使用したい場合は、再度プロファイルを読み込みしてください。")

    }

}