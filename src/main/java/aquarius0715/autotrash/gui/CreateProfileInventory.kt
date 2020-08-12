package aquarius0715.autotrash.gui

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.*

class CreateProfileInventory(private val plugin: AutoTrash) {

    var profileInv = Bukkit.createInventory(null, 54, "${ChatColor.AQUA}${ChatColor.BOLD}プロファイル確認")

    val profileInvLook = Bukkit.createInventory(null, 18, "${ChatColor.AQUA}${ChatColor.BOLD}プロファイル確認")

    var profileMap: MutableMap<UUID, Int> = mutableMapOf()

    fun createProfileInventoryHub(player: Player) {

        putButton(1, 11)
        putButton(2, 15)
        putButton(3, 37)
        putButton(4, 40)
        putButton(5, 43)

        player.openInventory(profileInv)

    }

    fun createProfileInventoryLook(profile: Int, player: Player) {

        profileMap[player.uniqueId] = profile

        for ((count, itemStack) in plugin.selectProfile.selectProfile(profile, player)!!.withIndex()) {

            profileInvLook.setItem(count, itemStack)

        }

        val confirmButton = ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1)

        val confirmButtonMeta = confirmButton.itemMeta

        val denialButton = ItemStack(Material.RED_STAINED_GLASS_PANE, 1)

        val denialButtonMeta = denialButton.itemMeta

        confirmButtonMeta.setDisplayName("${ChatColor.GREEN}${ChatColor.BOLD}ここをクリックしてこのプロファイルにする。")

        confirmButton.itemMeta = confirmButtonMeta

        denialButtonMeta.setDisplayName("${ChatColor.RED}${ChatColor.BOLD}ここをクリックして閉じる")

        denialButton.itemMeta = denialButtonMeta

        profileInvLook.setItem(12, denialButton)

        profileInvLook.setItem(13, confirmButton)

        profileInvLook.setItem(14, denialButton)

        player.openInventory(profileInvLook)

    }


    private fun putButton(profile: Int, index: Int) {

        val button = ItemStack(Material.OAK_SIGN, 1)

        val buttonMeta = button.itemMeta

        buttonMeta.setDisplayName("${ChatColor.AQUA}${ChatColor.BOLD}Profile$profile")

        val lore = ArrayList<String>()

        lore.add("${ChatColor.GREEN}${ChatColor.BOLD}右クリック${ChatColor.WHITE}${ChatColor.BOLD}: プロファイルを${ChatColor.YELLOW}${ChatColor.BOLD}確認。")

        lore.add("${ChatColor.RED}${ChatColor.BOLD}左クリック${ChatColor.WHITE}${ChatColor.BOLD}: プロファイルを${ChatColor.YELLOW}${ChatColor.BOLD}変更。")

        buttonMeta.lore = lore

        button.itemMeta = buttonMeta

        profileInv.setItem(index, button)

    }

}