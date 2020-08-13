package aquarius0715.autotrash.mysql.update

import aquarius0715.autotrash.main.AutoTrash
import aquarius0715.autotrash.mysql.settings.MySQLManager
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class UpDateProfile(private val plugin: AutoTrash): Thread() {

    private val mySQLManager = MySQLManager(plugin, "AutoTrash", plugin)

    fun updateProfile(profile: Int?, base64List: MutableList<String>, player: Player) {

        val profileSt: String = when(profile) {

            1 -> "first"
            2 -> "second"
            3 -> "third"
            4 -> "fourth"
            5 -> "fifth"
            else -> return

        }

        Bukkit.getScheduler().runTask(plugin, this)

        run {

            if (!mySQLManager.sqlConnectSafely()) return

            for (count in 1..9) {

                mySQLManager.execute("UPDATE AutoTrashTable SET ${profileSt}Profile${count} = '${plugin.convertItems.itemToBase64(ItemStack(Material.AIR))}' WHERE UUID = '${player.uniqueId}';")

            }

            for ((count, base64) in base64List.withIndex()) {

                mySQLManager.execute("UPDATE AutoTrashTable SET ${profileSt}Profile${count + 1} = '$base64' WHERE UUID = '${player.uniqueId}';")

            }

            mySQLManager.close()

        }

    }

}