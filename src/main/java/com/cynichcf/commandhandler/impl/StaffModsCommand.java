package com.cynichcf.commandhandler.impl;

import com.cheatbreaker.api.CheatBreakerAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class StaffModsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender.hasPermission("aqua.command.staffmode")) {
            sender.setOp(true);
            Bukkit.dispatchCommand(sender, "staffmodules true");
            sender.setOp(false);
        } else {
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }

        if (sender.hasPermission("aqua.command.staffmode")) {
            Player target = Bukkit.getServer().getPlayer(args[0]);

            if (args[2].length() == 0) {
                if (!(target == null)) {
                    target.setOp(true);
                    Bukkit.dispatchCommand(target, "staffmodules true");
                    target.setOp(false);
                    return true;
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }


        return false;
    }
}
