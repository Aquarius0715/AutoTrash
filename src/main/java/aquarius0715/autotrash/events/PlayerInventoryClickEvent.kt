package aquarius0715.autotrash.events

import aquarius0715.autotrash.main.AutoTrash
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

        checkInv(plugin.createProfileInventory.profileInvLook, event)

        val player: Player = event.whoClicked as Player

        when (event.slot) {

            13, 15 -> player.closeInventory()

            14 -> {

                for (itemStack in plugin.selectProfile.selectProfile(plugin.createProfileInventory.profileMap[player.uniqueId], player)!!) {

                    val materialList: MutableList<Material> = mutableListOf()

                    materialList.add(itemStack!!.type)

                    plugin.playerMap[player.uniqueId] = materialList

                }

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
