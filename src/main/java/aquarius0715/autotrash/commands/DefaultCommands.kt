package aquarius0715.autotrash.commands

import aquarius0715.autotrash.main.AutoTrash
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class DefaultCommands(private val plugin: AutoTrash): CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) return false

        when(label) {

            "at" -> {

                when(args.size) {

                    0 -> {

                        if (!plugin.pluginStats) {

                            sender.sendMessage("${plugin.prefix}プラグインは${ChatColor.RED}${ChatColor.BOLD}オフ${ChatColor.WHITE}${ChatColor.BOLD}になっています。")

                        }

                        plugin.createSetInventory.createSetInventory(sender)

                        return true

                    }

                    1 -> {

                        when(args[0]) {

                            "profile" -> {

                                if (!plugin.pluginStats) {

                                    sender.sendMessage("${plugin.prefix}プラグインは${ChatColor.RED}${ChatColor.BOLD}オフ${ChatColor.WHITE}${ChatColor.BOLD}になっています。")

                                    return false

                                }

                                plugin.createProfileInventory.createProfileInventoryHub(sender)

                            }

                            "check" -> {

                                if (!plugin.pluginStats) {

                                    sender.sendMessage("${plugin.prefix}プラグインは${ChatColor.RED}${ChatColor.BOLD}オフ${ChatColor.WHITE}${ChatColor.BOLD}になっています。")

                                    return false

                                }

                                plugin.createCheckInventory.createCheckInventory(sender)

                                return true

                            }

                            "clear" -> {

                                if (!plugin.pluginStats) {

                                    sender.sendMessage("${plugin.prefix}プラグインは${ChatColor.RED}${ChatColor.BOLD}オフ${ChatColor.WHITE}${ChatColor.BOLD}になっています。")

                                    return false

                                }

                                val materialList: MutableList<Material> = mutableListOf()

                                for (count in 0..8) {

                                    materialList.add(Material.BEDROCK)

                                }

                                plugin.playerMap[sender.uniqueId] = materialList

                                sender.sendMessage("${plugin.prefix}AutoTrash対象をクリアーにしました。")

                            }

                            "help" -> {

                                sender.sendMessage("${plugin.prefix}</at>: 自動処分するアイテムを登録します。")
                                sender.sendMessage("${plugin.prefix}</at help>: このコマンド説明画面を開きます。")
                                sender.sendMessage("${plugin.prefix}</at stats>: このプラグインの稼働状況を見ます。")
                                sender.sendMessage("${plugin.prefix}</at profile>: AutoTrashのプロファイルの設定を行います。")
                                sender.sendMessage("${plugin.prefix}</at check>: 現在のAutoTrash対象アイテムを確認します。")
                                sender.sendMessage("${plugin.prefix}</at clear>: AutoTrash対象アイテムを一括削除します。")
                                sender.sendMessage("${plugin.prefix}</at on>: このプラグインをオンにします。")
                                sender.sendMessage("${plugin.prefix}</at off>: このプラグインをオフにします。")
                                sender.sendMessage("${plugin.prefix}created by Aquarius0715")

                            }

                            "on" -> {

                                if (!isAdmin(sender)) return true

                                return if (plugin.pluginStats) {

                                    sender.sendMessage("${plugin.prefix}プラグインはすでに${ChatColor.GREEN}${ChatColor.BOLD}オン${ChatColor.WHITE}${ChatColor.BOLD}になっています。")

                                    true

                                } else {

                                    plugin.pluginStats = true

                                    sender.sendMessage("${plugin.prefix}プラグインを${ChatColor.GREEN}${ChatColor.BOLD}オン${ChatColor.WHITE}${ChatColor.BOLD}にしました。")

                                    true

                                }

                            }

                            "off" -> {

                                if (!plugin.pluginStats) {

                                    if (!isAdmin(sender)) return true

                                    sender.sendMessage("${plugin.prefix}プラグインはすでに${ChatColor.RED}${ChatColor.BOLD}オフ${ChatColor.WHITE}${ChatColor.BOLD}になっています。")

                                    return true

                                } else {

                                    plugin.pluginStats = false

                                    sender.sendMessage("${plugin.prefix}プラグインを${ChatColor.RED}${ChatColor.BOLD}オフ${ChatColor.WHITE}${ChatColor.BOLD}にしました。")

                                    return true

                                }

                            }

                            "stats" -> {

                                return if (plugin.pluginStats) {

                                    sender.sendMessage("${plugin.prefix}プラグインは${ChatColor.GREEN}${ChatColor.BOLD}オン${ChatColor.WHITE}${ChatColor.BOLD}です。")

                                    true

                                } else {

                                    sender.sendMessage("${plugin.prefix}プラグインは${ChatColor.RED}${ChatColor.BOLD}オフ${ChatColor.WHITE}${ChatColor.BOLD}です。")

                                    true

                                }

                            }

                        }

                    }

                }

            }

        }

        return false

    }

    private fun isAdmin(sender: CommandSender): Boolean {

        if (sender.hasPermission("admin")) {

            return true

        }

        return false

    }

}