package com.cynichcf.commandhandler;

import com.cynichcf.commandhandler.impl.CheatBreakerBan;
import com.cynichcf.commandhandler.impl.Help;
import com.cynichcf.commandhandler.impl.StaffModsCommand;
import com.cynichcf.commandhandler.impl.punishments.Ban;
import com.cynichcf.commandhandler.impl.punishments.Mute;
import com.cynichcf.commandhandler.impl.punishments.TempBan;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHandler extends JavaPlugin {

    private static CommandHandler instance;
    private long startUpTime = System.currentTimeMillis();

    @Override
    public void onEnable() {
        instance = this;

        long finalTime = System.currentTimeMillis() - startUpTime;
        System.out.println("[Cynic Command Handler] Loaded in " + finalTime + "ms!");

        getCommand("tb").setExecutor(new TempBan());
        getCommand("b").setExecutor(new Ban());
        getCommand("mp").setExecutor(new Mute());
        getCommand("chelp").setExecutor(new Help());
        getCommand("staffmods").setExecutor(new StaffModsCommand());
        getCommand("cheatbreakerban").setExecutor(new CheatBreakerBan());
    }

    public static CommandHandler getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

}
