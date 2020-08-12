package aquarius0715.autotrash.main

import aquarius0715.autotrash.commands.DefaultCommands
import aquarius0715.autotrash.events.InventoryCloseEvent
import aquarius0715.autotrash.events.PlayerInventoryClickEvent
import aquarius0715.autotrash.events.PlayerItemPickEvent
import aquarius0715.autotrash.events.PlayerJoinEvent
import aquarius0715.autotrash.gui.CreateCheckInventory
import aquarius0715.autotrash.gui.CreateProfileInventory
import aquarius0715.autotrash.gui.CreateSetInventory
import aquarius0715.autotrash.item.ConvertItems
import aquarius0715.autotrash.mysql.insert.InsertDefaultTable
import aquarius0715.autotrash.mysql.select.SelectProfile
import aquarius0715.autotrash.mysql.update.UpDateProfile
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class AutoTrash : JavaPlugin() {

    var playerMap = mutableMapOf<UUID, MutableList<Material>>()

    var pluginStats = true

    val createSetInventory = CreateSetInventory()

    val createCheckInventory = CreateCheckInventory(this)

    val createProfileInventory = CreateProfileInventory(this)

    val insertDefaultTable = InsertDefaultTable(this)

    val upDateProfile = UpDateProfile(this)

    val convertItems = ConvertItems()

    val selectProfile = SelectProfile(this)

    val prefix = "${ChatColor.WHITE}${ChatColor.BOLD}[" +
            "${ChatColor.DARK_GRAY}${ChatColor.BOLD}Auto" +
            "${ChatColor.GRAY}${ChatColor.BOLD}Trash" +
            "${ChatColor.WHITE}${ChatColor.BOLD}]"

    override fun onEnable() {

        Objects.requireNonNull(getCommand("at"))!!.setExecutor(DefaultCommands(this))

        server.pluginManager.registerEvents(InventoryCloseEvent(this), this)

        server.pluginManager.registerEvents(PlayerItemPickEvent(this), this)

        server.pluginManager.registerEvents(PlayerInventoryClickEvent(this), this)

        server.pluginManager.registerEvents(PlayerJoinEvent(this), this)

    }

}