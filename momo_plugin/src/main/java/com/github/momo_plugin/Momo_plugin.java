package com.github.momo_plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Momo_plugin extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("go").setExecutor(this);
        Bukkit.getLogger().info("momo_plugin start");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("momo_plugin stop");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = event.getPlayer().getName();
        player.sendMessage("Hello, "+name+"!");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(command.equals("go")) {
            if(args.length == 0) {
                player.sendMessage(ChatColor.RED + "type like this: /go <player>");
            } else if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                player.teleport(target.getLocation());
            }
        }
        return false;
    }
    
    @Override
    public void whenPlayerDie(PlayerDeathEvent event) {
        Player player = event.getPlayer();
    }
}
