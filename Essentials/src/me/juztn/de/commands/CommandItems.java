package me.juztn.de.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.juztn.de.effects.InventoryAnimation;
import me.juztn.de.main.Essentials;
import me.juztn.de.main.ServerMessages;

public class CommandItems implements CommandExecutor, Listener {
	public CommandItems(Essentials pl) {
		pl.getCommand("items").setExecutor(this);
		pl.getServer().getPluginManager().registerEvents(this, pl);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("server.command.use.info")) {
				if (args.length == 0) {

					Inventory inv = Bukkit.createInventory(null, 9 * 3, "§a+Items");

					InventoryAnimation.animateInv1(inv, p);
//					ItemStack tmen = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)3);
//					ItemMeta imeta1 = tmen.getItemMeta();
//					imeta1.setDisplayName("");
//					tmen.setItemMeta(imeta1);
//					
//					inv.setItem(4, tmen);
//					inv.setItem(22, tmen); 
//					for (int i = 9 ; i < 18 ; i++)
//						inv.setItem(i, tmen);
//					
//					ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
//					ItemMeta imeta = item.getItemMeta();
//					imeta.setDisplayName("§6Apple der es in sich hat!");
//					imeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
//					item.setItemMeta(imeta);
//
//					inv.setItem(13, item);
//					p.openInventory(inv);

					// 9+10+11+12+4+14+15+16+17+22

					p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
				} else {
					p.sendMessage("§cBitte benutze /item!");

				}
			} else {
				p.sendMessage(ServerMessages.NO_PERMISSION.getMessage());
			}

		}
		return false;
	}

	@EventHandler
	public void click(InventoryClickEvent e) {

		if (e.getClickedInventory().getName().equals("§a+Items")) {
			e.setCancelled(true);
		}

	}

//	Inventory inv = e.getInventory();
//		if(inv.getName().equals("§a+Items")) {

}

//}
