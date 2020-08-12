package aquarius0715.autotrash.mysql.insert

import aquarius0715.autotrash.main.AutoTrash
import aquarius0715.autotrash.mysql.settings.MySQLManager
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class InsertDefaultTable(private val plugin: AutoTrash) : Thread() {

    private val sqlManager = MySQLManager(plugin, "AutoTrash", plugin)

    fun insertDefaultTable(player: Player) {

        Bukkit.getScheduler().runTask(plugin, this)

        run {

            if (!sqlManager.sqlConnectSafely()) return

            val sql1 = "SELECT * FROM AutoTrashTable WHERE UUID = '${player.uniqueId}';"

            val resultSet = sqlManager.query(sql1)

            if (!resultSet!!.next()) {

                var sql = "INSERT INTO AutoTrashTable (PlayerName, UUID"

                var count = 1

                var profileCount = 1

                for (i in 1..45) {

                    if (count > 9) {

                        count = 1

                        profileCount++

                    }

                    val profileSt: String = when(profileCount) {

                        1 -> "first"
                        2 -> "second"
                        3 -> "third"
                        4 -> "fourth"
                        5 -> "fifth"
                        else -> return

                    }

                    sql += ", ${profileSt}Profile${count}"

                    count++

                }

                sql += ") VALUE ('${player.name}', '${player.uniqueId}'"

                for (i in 1..45) {

                    sql += ", '${plugin.convertItems.itemToBase64(ItemStack(Material.AIR))}'"

                }

                sql += ");"

                sqlManager.execute(sql)

            }

            resultSet.close()

            sqlManager.close()

        }

    }

}
