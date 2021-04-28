package com.cynichcf.commandhandler.impl.punishments;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.DARK_RED + "Cynic" + ChatColor.DARK_GRAY + " » " + ChatColor.RED + "Usage: /ban <player> <reason>");
            return true;
        }

        if (!sender.hasPermission("cynic.hcf")) {
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }

        Player target = Bukkit.getServer().getPlayer(args[0]);
        Bukkit.dispatchCommand(sender, "aquacore:ban " + target.getName() + " " + (args[1]) + " -s");
        sender.sendMessage(ChatColor.DARK_RED + "Cynic" + ChatColor.DARK_GRAY + " » " + ChatColor.RED + "You have banned " + target.getName() + " for reason: " + (args[1]) + ".");
        return false;
    }
}
