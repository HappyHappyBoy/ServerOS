package me.juztn.de.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.juztn.de.main.Essentials;
import me.juztn.de.main.ServerMessages;

public class HealCMD implements CommandExecutor {
	public HealCMD(Essentials pl) {
		pl.getCommand("heal").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (args.length == 0) {
				if (p.hasPermission("server.command.use.heal.self") || p.hasPermission("server.command.use.heal*")) {
					p.setHealth(20D);
					p.setFoodLevel(20);
					p.sendMessage("§aDu wurdest geheilt!");
				} else
					p.sendMessage(ServerMessages.NO_PERMISSION.getMessage());
			} else if (args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if (target != null) {
					if (p.hasPermission("server.command.use.heal.other")
							|| p.hasPermission("server.command.use.heal*")) {
						target.setHealth(20D);
						target.setFoodLevel(20);
						target.sendMessage("§aDu wurdest geheilt!");
						p.sendMessage("§aDu hast " + target.getName() + " geheilt!");
					} else
						p.sendMessage(ServerMessages.NO_PERMISSION.getMessage());
				} else
					p.sendMessage(ServerMessages.PLAYER_NOT_ONLINE.getMessage());
			} else
				p.sendMessage("§cBitte benutze /heal <Spieler>!");
		}
		return false;
	}
}