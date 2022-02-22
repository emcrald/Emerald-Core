package me.emeraldcss.emeraldcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class DieCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("die")){

            System.out.println("I have been run by someone.");
            if (sender instanceof Player){

                Player p = (Player) sender;
                p.setHealth(0.0);
                p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                        + ChatColor.GREEN + " LOL ur ded");

            }else if (sender instanceof ConsoleCommandSender){

                System.out.println("The command was ran in the console.");

            }else if(sender instanceof BlockCommandSender){

                System.out.println("The command was ran by a command block.");

            }

        }

        return true;
    }
}