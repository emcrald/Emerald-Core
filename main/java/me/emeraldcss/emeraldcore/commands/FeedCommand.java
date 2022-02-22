package me.emeraldcss.emeraldcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,
                             Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You need to be a player to use this command!");
            return true;

        } else {
            if(label.equalsIgnoreCase("feed"))
                if (args.length < 1) {
                    if (!(p.hasPermission("emerald-core.feed"))) {
                        p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                                + ChatColor.RED + " You don't have permission to do this command!");
                        return true;
                    } else {
                        p.setFoodLevel(20);
                        p.setSaturation(10);
                        p.setExhaustion(0F);
                        p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                                + ChatColor.GRAY + " Your " + ChatColor.GREEN + "hunger" + ChatColor.GRAY + " has been restored!");
                        return true;
                    }
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "]"
                                + ChatColor.GRAY + " Player "
                                + ChatColor.GREEN + args[0]
                                + ChatColor.GRAY + " is not online!");
                        return true;
                    } else {
                        p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "EmeraldCore" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "] "
                                + ChatColor.GREEN + args[0]
                                + ChatColor.GRAY + " Hunger has been restored!");
                    }
                }
        }
        return false;
    }}
