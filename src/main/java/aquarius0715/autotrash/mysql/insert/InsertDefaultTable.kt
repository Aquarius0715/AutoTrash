package aquarius0715.autotrash.mysql.insert

import aquarius0715.autotrash.main.AutoTrash
import aquarius0715.autotrash.mysql.MySQLManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class InsertDefaultTable(private val plugin: AutoTrash) : Thread() {

    private val sqlManager = MySQLManager(plugin, "AutoTrash", plugin)

    fun insertDefaultTable(player: Player) {

        Bukkit.getScheduler().runTask(plugin, this)

            run {

                if (!sqlManager.sqlConnectSafely()) return

                val sql = ("""
                            INSERT INTO AutoTrashTable 
                            (PlayerName, UUID) 
                            VALUE ('${player.name}' , '${player.uniqueId}');
                            """)

                sqlManager.execute(sql)

            }

        }

    }
