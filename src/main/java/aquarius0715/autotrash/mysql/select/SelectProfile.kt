package aquarius0715.autotrash.mysql.select

import aquarius0715.autotrash.main.AutoTrash
import aquarius0715.autotrash.mysql.MySQLManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class SelectProfile(val plugin: AutoTrash): Thread() {

    private val mySQLManager = MySQLManager(plugin, "AutoTrash", plugin)

    fun selectProfile(profile: Int?, player: Player): MutableList<ItemStack?>? {

        val base64List: MutableList<String> = mutableListOf()

        val itemStackList: MutableList<ItemStack?>? = mutableListOf()

        val profileSt: String = when (profile) {

            1 -> "first"
            2 -> "second"
            3 -> "third"
            4 -> "fourth"
            5 -> "fifth"
            else -> return null

        }

        Bukkit.getScheduler().runTask(plugin, this)

        run {

            if (!mySQLManager.sqlConnectSafely()) return null

            val sql = "SELECT " +
                    "firstProfile1," +
                    " firstProfile2," +
                    " firstProfile3," +
                    " firstProfile4," +
                    " firstProfile5," +
                    " firstProfile6," +
                    " firstProfile7," +
                    " firstProfile8," +
                    " firstProfile9 " +
                    "FROM AutoTrashTable WHERE UUID = '${player.uniqueId}';"

            val resultSet = mySQLManager.query(sql)

            var count = 1

            while (resultSet!!.next()) {

                base64List.add(resultSet.getString("firstProfile$count"))

                count++

            }

            resultSet.close()

            mySQLManager.close()

            for (base64 in base64List) {

                itemStackList!!.add(plugin.convertItems.itemFromBase64(base64))

            }

            return itemStackList

        }

    }

}
