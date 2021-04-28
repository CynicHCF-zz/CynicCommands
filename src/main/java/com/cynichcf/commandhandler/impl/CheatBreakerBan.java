package com.cynichcf.commandhandler.impl;

import com.cynichcf.commandhandler.util.DiscordWebhook;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.awt.*;
import java.io.IOException;

public class CheatBreakerBan implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /cheatbreakerban <target>");
        }

        if (sender.getName().equalsIgnoreCase("ArcaneCC") || sender.getName().equalsIgnoreCase("bisecting")) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + target.getName() + " has been CheatBreaker banned.");

            DiscordWebhook webhook = new DiscordWebhook("https://discord.com/api/webhooks/837028494634254347/GEYTXHkunqn6nPQ5tjAO8EOXl-E1AEKfwhX0Gi5RnouMgbjjI9o1xaDVKEpM16EI1g0u");
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setAuthor("CheatBreaker Staff", null, "https://pbs.twimg.com/profile_images/1377815493717991426/EqVGOlUS_400x400.jpg")
                    .setTitle(target.getName() + " has been CheatBreaker banned.")
                    .setColor(Color.RED)
            );
            try {
                webhook.execute();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return true;

            /*
            CheatBreakerAPI.getInstance().sendBanMessage(args[0] = " has been CheatBreaker banned. (Cheating)");
            */

        } else {
            sender.sendMessage(ChatColor.RED + "No permission.");
        }

        return false;
    }
}
