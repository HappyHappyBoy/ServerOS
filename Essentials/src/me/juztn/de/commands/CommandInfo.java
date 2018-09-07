package me.juztn.de.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.juztn.de.main.Essentials;
import me.juztn.de.main.ServerMessages;

public class CommandInfo implements CommandExecutor {
	public CommandInfo(Essentials pl) {
		pl.getCommand("info").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		if (sender != null) {
			Player p = (Player) sender;

			if (p.hasPermission("server.commands.use.info")) {
				switch (args.length) {
				case 0:
					p.sendMessage("§a/info <Spieler>");
					break;
				case 1:
					Player target = Bukkit.getPlayer(args[0]);
					if (target != null) {
						Location loc = target.getLocation();
						int x = (int)loc.getX();
						int y = (int)loc.getY();
						int z = (int)loc.getZ();
						//Farben: Relevantes §7 und irrelevantes §8
						p.sendMessage("§7X§8 / §7Y§8 / §7Z§8: §7" + x + " §8/ §7" + y + " §8 /§7" + z);
					} else
						p.sendMessage(ServerMessages.PLAYER_NOT_ONLINE.getMessage());
					break;

				}

				
			} else
				p.sendMessage(ServerMessages.NO_PERMISSION.getMessage());

			
		}

		return false;
	}

}
