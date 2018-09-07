package me.juztn.de.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.juztn.de.Broadcaster;
import me.juztn.de.commands.ChatClear;
import me.juztn.de.commands.CommandGameMode;
import me.juztn.de.commands.CommandInfo;
import me.juztn.de.commands.CommandItems;
import me.juztn.de.commands.HealCMD;
import me.juztn.de.events.ChatListener;
import me.juztn.de.events.JoinListener;

public class Essentials extends JavaPlugin {
	
	private static Essentials pl;
	Broadcaster b = new Broadcaster(this);
	
	@Override
	public void onEnable(){
		pl = this;
		new CommandGameMode(this);
		new CommandItems(this);
		new HealCMD(this);
		new CommandInfo(this);
		
		Bukkit.getConsoleSender().sendMessage("§aDas 'Erste Plugin' wurde Aktiviert!");
		new ChatClear(this);
		new ChatListener(this);
		new JoinListener(this);
		b.startCountdown();
	}

	public void rofl() {
	
	}
	
	@Override
	public void onDisable(){
		System.out.println("§cDas Plugin wurde Deaktiviert!");
	}
	
	public static Essentials getinstance(){
		return pl;

	}
	
}