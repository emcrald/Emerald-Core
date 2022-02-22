package me.emeraldcss.emeraldcore.commands;

import me.emeraldcss.emeraldcore.EmeraldCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {

    EmeraldCore plugin;

    public VanishCommand(EmeraldCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (plugin.invisible_list.contains(player)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.showPlayer(plugin, player);
                }
                plugin.invisible_list.remove(player);
                player.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                        + ChatColor.GREEN + " You are now visible");
            }else if(!plugin.invisible_list.contains(player)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.hidePlayer(plugin, player);
                }
                plugin.invisible_list.add(player);
                player.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                        + ChatColor.GREEN + " You are now invisible");
            }
        }

        return true;
    }
}
