package aquarius0715.autotrash.events

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory

class PlayerInventoryClickEvent(private val plugin: AutoTrash): Listener {

    @EventHandler

    fun onClickCheckInv(event: InventoryClickEvent) {

        checkInv(plugin.createCheckInventory.checkInv, event)

    }

    @EventHandler

    fun onClickProfileInv(event: InventoryClickEvent) {

        checkInv(plugin.createProfileInventory.profileInv, event)

        val player: Player = event.whoClicked as Player

        when(event.slot) {

            11 -> {

                if (event.isLeftClick) {

                    plugin.createProfileInventory.createProfileInventoryLook(1, player)

                }

                if (event.isRightClick) {

                    plugin.createSetInventory.createSetProfileInventory(player)

                }

            }

            15 -> {

                if (event.isLeftClick) {

                    plugin.createProfileInventory.createProfileInventoryLook(2, player)

                }

                if (event.isRightClick) {

                    plugin.createSetInventory.createSetProfileInventory(player)

                }

            }

            37 -> {

                if (event.isLeftClick) {

                    plugin.createProfileInventory.createProfileInventoryLook(3, player)

                }

                if (event.isRightClick) {

                    plugin.createSetInventory.createSetProfileInventory(player)

                }

            }

            40 -> {

                if (event.isLeftClick) {

                    plugin.createProfileInventory.createProfileInventoryLook(4, player)

                }

                if (event.isRightClick) {

                    plugin.createSetInventory.createSetProfileInventory(player)

                }

            }

            43 -> {

                if (event.isLeftClick) {

                    plugin.createProfileInventory.createProfileInventoryLook(5, player)

                }

                if (event.isRightClick) {

                    plugin.createSetInventory.createSetProfileInventory(player)

                }

            }

        }

    }

    @EventHandler

    fun onClickProfileInvLook(event: InventoryClickEvent) {

        val materialList: MutableList<Material> = mutableListOf()

        checkInv(plugin.createProfileInventory.profileInvLook, event)

        val player: Player = event.whoClicked as Player

        when (event.slot) {

            12, 14 -> player.closeInventory()

            13 -> {

                for (itemStack in plugin.selectProfile.selectProfile(plugin.createProfileInventory.profileMap[player.uniqueId], player)!!) {

                    materialList.add(itemStack!!.type)

                }

                plugin.playerMap[player.uniqueId] = materialList

                player.sendMessage("${plugin.prefix}${ChatColor.AQUA}${ChatColor.BOLD}プロファイル${plugin.createProfileInventory.profileMap[player.uniqueId]}${ChatColor.WHITE}${ChatColor.BOLD}が選択されました。")

                player.closeInventory()

            }

        }

    }

    private fun checkInv(inv: Inventory, event: InventoryClickEvent) {

        if (event.inventory != inv) return

        if (event.currentItem == null) return

        if (event.currentItem!!.itemMeta == null) return

        event.isCancelled = true

    }

}
