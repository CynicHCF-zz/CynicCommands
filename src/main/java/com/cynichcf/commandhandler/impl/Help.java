package com.cynichcf.commandhandler.impl;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!sender.hasPermission("cynic.staff")) {
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }

        sender.sendMessage(ChatColor.GRAY + "§m§l-------------------------------------");
        sender.sendMessage(ChatColor.DARK_RED + "§lBan » " + ChatColor.GRAY + "§l/b <player> <reason>");
        sender.sendMessage(ChatColor.DARK_RED + "§lTempBan » " + ChatColor.GRAY + "§l/tban <player> <time> <reason>");
        sender.sendMessage(ChatColor.DARK_RED + "§lMute » " + ChatColor.GRAY + "§l/m <player> <time> <reason>");
        if (sender.isOp()) {
            sender.sendMessage(ChatColor.DARK_RED + "§lBlacklist » " + ChatColor.GRAY + "§l/blacklist <player> <reason>");
        }

        sender.sendMessage(ChatColor.GRAY + "§m§l-------------------------------------");

        return false;
    }
}
