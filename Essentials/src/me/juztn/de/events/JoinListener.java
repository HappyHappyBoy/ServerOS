package me.juztn.de.events;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import me.juztn.de.main.Essentials;

public class JoinListener implements Listener {


	public JoinListener(Essentials pl) {
		pl.getServer().getPluginManager().registerEvents(this, pl);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.sendTitle("", "§b-=Willkommen=-", 20,20, 80);
		p.sendMessage("§aEs gibt neue Befehle! nutze den Befehl: /teleport" + p.getName() + "230 96 376");
		
		FireworkEffect effect = FireworkEffect.builder()
				.withColor(Color.RED)
				.with(FireworkEffect.Type.BURST)
				.withFade(Color.PURPLE)
				.flicker(true)
				.trail(true)
				.build();
	
		Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
		FireworkMeta meta = firework.getFireworkMeta();
		meta.setPower(3);
		meta.addEffect(effect);
		firework.setCustomName("§cALLAHU AKBAR");
		firework.setCustomNameVisible(true);
		firework.setFireworkMeta(meta);		
		e.setJoinMessage("§a >> §8" + p.getName());
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage("§c << §8" + p.getName());
	}
	

}
