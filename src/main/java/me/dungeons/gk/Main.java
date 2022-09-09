package me.dungeons.gk;

import me.dungeons.gk.Commands.InitCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main plugin;

    public static Plugin getInstance() {
        return Main.plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        System.out.println("loaded");

        this.getCommand("blood").setExecutor(new InitCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("unloaded");
    }

}
