package me.juztn.de;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import me.juztn.de.main.Essentials;

public class Broadcaster {

	 int count;
	
	 HashMap<String, BukkitRunnable> timers = new HashMap<String, BukkitRunnable>();
	private  Essentials pl;
	public Broadcaster(Essentials pl) {
		this.pl=pl;
	}
	public  void startCountdown() {
		timers.put("penis", new BukkitRunnable() {
			@Override
			public void run() {
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("§6Willkommen auf dem localhost");
				Bukkit.broadcastMessage("");
				
				
			}
		});
		timers.get("penis").runTaskTimer(pl,0,20*900);
		
		
		
//		count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Essentials.getinstance(), new Runnable() {
//			
//			@Override
//			public void run() {
//		
//				
//				Bukkit.broadcastMessage("§6Willkommen auf dem localhost");
//				
//				if(Start_CO == 6000) {
//					Bukkit.broadcastMessage("nix passiert");
//					Bukkit.getScheduler().cancelTask(count);
//					Start_CO=0;
//				}
//				Start_CO++;
//			}
//		}, 0, 3*20);
	}
	
}
