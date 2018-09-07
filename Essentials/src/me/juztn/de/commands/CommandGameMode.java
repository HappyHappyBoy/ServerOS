package me.juztn.de.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.juztn.de.main.Essentials;

public class CommandGameMode implements CommandExecutor {
	public CommandGameMode(Essentials pl) {
		pl.getCommand("gm").setExecutor(this);
		
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender != null) {
			if(cmd.getName().equalsIgnoreCase("gm")) {
				if(sender.hasPermission("server.use.command.gamemode")) {
					switch(args.length) {
					case 0:
						if((sender instanceof Player)) {								
							Player p = (Player)sender;
							p.sendMessage("§a/gamemode <0/1/2/3> <Name>");
						}
						break;
					case 1:
						if((sender instanceof Player)) {								
							Player p = (Player)sender;
							if(args[0].equals("0")) {
								p.setGameMode(GameMode.SURVIVAL);
								p.sendMessage("§aDu bist nun im Survival");
							}else if(args[0].equals("1")) {
								p.setGameMode(GameMode.CREATIVE);
								p.sendMessage("§aDu bist nun im Creative");
							}else if(args[0].equals("2")) {
								p.setGameMode(GameMode.ADVENTURE);
								p.sendMessage("§aDu bist nun im Adventure");
							}else if(args[0].equals("3")) {
								p.setGameMode(GameMode.SPECTATOR);
								p.sendMessage("§aDu bist nun Spectator");
							}else p.sendMessage("§cGameMode nicht gefunden");
						}else System.out.println("Du bist kein Spieler");
						break;
					case 2:
						Player target = Bukkit.getPlayer(args[1]);
						if(target != null) {
							if(sender.hasPermission("server.use.command.gamemode.other") || sender.hasPermission("server.use.*")) {
								if(args[0].equals("0")) {
									target.setGameMode(GameMode.SURVIVAL);
									target.sendMessage("§aGamemode wurde auf SURVIVAL gesetzt!");
									sender.sendMessage("§c" + target.getName() + "§7 ist nun im Survival Modus!");
								}else if(args[0].equals("1")) {
									target.setGameMode(GameMode.CREATIVE);
									target.sendMessage("§aGamemode wurde auf CREATIVE gesetzt!");
									sender.sendMessage("§c" + target.getName() + "§7 ist nun im Creative Modus!");
								}else if(args[0].equals("2")) {
									target.setGameMode(GameMode.ADVENTURE);
									target.sendMessage("§c" + target.getName() + "§7 ist nun im Adventure Modus!");
								}else if(args[0].equals("3")) {
									target.setGameMode(GameMode.SPECTATOR);
									target.sendMessage("§aGamemode wurde auf SPECTATOR gesetzt!");
								}else sender.sendMessage("§c" + target.getName() + "§7 ist nun im Spectator Modus!");
									
								break;
							}
						}else sender.sendMessage("Der Spieler ist nicht online!");
					}
				}else sender.sendMessage("§cKeine Permission");
			}
			if((sender instanceof Player) || (sender instanceof  ConsoleCommandSender)) {
			}else {
				System.out.println("Du bist kein Spieler!");
				return false;
			}
		}
		return false;
	}

	
	
}
