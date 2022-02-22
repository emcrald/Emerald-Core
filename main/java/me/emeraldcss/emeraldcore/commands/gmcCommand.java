package me.emeraldcss.emeraldcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;

public class gmcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("gmc")){
            if (sender instanceof Player){
                Player p = (Player) sender;
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                        + ChatColor.GREEN + " Set Gamemode to Creative");

            }else if (sender instanceof ConsoleCommandSender){

                System.out.println("The command was ran in the console.");

            }else if(sender instanceof BlockCommandSender){

                System.out.println("The command was ran by a command block.");

            }

        }

        return true;
    }
}