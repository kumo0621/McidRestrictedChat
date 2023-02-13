package com.github.kumo0621.mcidrestrictedchat;

import net.kunmc.lab.commandlib.CommandLib;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class McidRestrictedChat extends JavaPlugin implements org.bukkit.event.Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        CommandLib.register(this, new mozicommand());
    }

    public static boolean start = false;

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerchat(PlayerChatEvent e) {
        if (start) {
            String args = e.getMessage();
            String name = e.getPlayer().getName();
            int length = args.length();
            int namelength = name.length();
            if (namelength != length) {
                e.setCancelled(true);
                length -= namelength;
                int set = Math.abs(length);
                int henkan = 0;
                Player player = e.getPlayer();
                if(henkan >= length) {
                    player.sendMessage(set + "文字足りません");
                }else{
                    player.sendMessage(length + "文字多いです");
                }
            }
        }
    }
}
