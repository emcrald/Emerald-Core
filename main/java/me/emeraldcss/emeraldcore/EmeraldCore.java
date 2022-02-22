package me.emeraldcss.emeraldcore;
import me.emeraldcss.emeraldcore.commands.*;
import me.emeraldcss.emeraldcore.commands.events.JoinEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public final class EmeraldCore extends JavaPlugin implements Listener {

    public ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("god").setExecutor(new GodCommand());
        getCommand("die").setExecutor(new DieCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("gmc").setExecutor(new gmcCommand());
        getCommand("gms").setExecutor(new gmsCommand());
        getCommand("gmsp").setExecutor(new gmspCommand());
        getCommand("gma").setExecutor(new gmaCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("vanish").setExecutor(new VanishCommand(this));

        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);

    }
    @Override
    public void onDisable(){

    }

        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent e){
            Player p = e.getPlayer();
            e.setJoinMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                    + ChatColor.GREEN + " " +  p.getName() + " has joined the server! \n Type /help EmeraldCore for a list of commands");
        }

        @EventHandler
        public void onPlayerQuit(PlayerQuitEvent e){
            Player p = e.getPlayer();
            e.setQuitMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                    + ChatColor.GREEN + " " + p.getName() + " has left the server!");
    }
}