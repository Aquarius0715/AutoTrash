package aquarius0715.autotrash.mysql.update

import aquarius0715.autotrash.main.AutoTrash
import aquarius0715.autotrash.mysql.settings.MySQLManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class UpDateProfile(private val plugin: AutoTrash): Thread() {

    private val mySQLManager = MySQLManager(plugin, "AutoTrash", plugin)

    fun updateProfile(profile: Int?, base64List: MutableList<String>, player: Player) {

        var sql = ""

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

            val sql1 = "SELECT * FROM AutoTrashTable WHERE UUID = '${player.uniqueId}';"

            val resultSet = mySQLManager.query(sql1)

            if (resultSet == null) {

                plugin.insertDefaultTable.insertDefaultTable(player)

            }

            resultSet!!.close()

            for ((count, base64) in base64List.withIndex()) {

                sql += "UPDATE AutoTrashTable SET ${profileSt}Profile${count} = '$base64';"

            }

            mySQLManager.execute(sql)

            mySQLManager.close()

        }

    }

}