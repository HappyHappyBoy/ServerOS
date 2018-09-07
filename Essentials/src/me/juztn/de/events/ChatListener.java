package me.juztn.de.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.juztn.de.main.Essentials;

public class ChatListener implements Listener {
	public ChatListener(Essentials pl) {
		pl.getServer().getPluginManager().registerEvents(this, pl);
	}

	public ChatListener() {
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();

		String message = e.getMessage();
		message = message.replace("&", "§");
		if (p.hasPermission("test.chat")) {

			e.setFormat("§4Admin §c" + p.getName() + "§f: " + message);

		} else {
			e.setFormat("§7" + p.getName() + ": " + message);

		}

	}
}
