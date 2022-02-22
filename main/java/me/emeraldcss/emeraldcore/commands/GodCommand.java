package me.emeraldcss.emeraldcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.isInvulnerable()){
                p.setInvulnerable(false);
                p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                        + ChatColor.RED + " God Mode Disabled");
            }else{
                p.setInvulnerable(true);
                p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                        + ChatColor.GREEN + " God Mode Enabled");
            }

        }else{
            System.out.println("Only a player can run this command");
        }

        return true;
    }
}
