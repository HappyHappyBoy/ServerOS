package me.juztn.de.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.juztn.de.main.Essentials;

public class ChatClear implements CommandExecutor {
	public ChatClear(Essentials pl) {
		pl.getCommand("Chatclear").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender != null) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (cmd.getName().equalsIgnoreCase("chatclear")) {
					if (p.hasPermission("server.command.use.chatclear")) {
						switch (args.length) {
						case 0:
							for (int i = 0; i != 100; i++) {
								Bukkit.broadcastMessage("");
							}
							Bukkit.broadcastMessage("§cDer Chat wurde von " + p.getName() + " gecleart");
							break;

						}
					} else
						p.sendMessage("§cKeine Permission");
				}
			} else {
				System.out.println("Du bist kein Spieler!");
				return false;
			}
		}

		return false;
	}

}