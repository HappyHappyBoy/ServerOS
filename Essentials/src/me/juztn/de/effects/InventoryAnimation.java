package me.juztn.de.effects;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.juztn.de.main.Essentials;

public class InventoryAnimation {

	protected static final Enchantment EnchantmentLure = Enchantment.LURE;
	private static HashMap<Player, BukkitRunnable> timers = new HashMap<Player, BukkitRunnable>();
	private static HashMap<Player, Integer> steps = new HashMap<Player, Integer>();

	public static void animateInv1(final Inventory inv, final Player p) {
		if (timers.containsKey(p)) {
			return;
		} else {
			steps.put(p, 0);
			timers.put(p, new BukkitRunnable() {
				@Override
				public void run() {
					ItemStack item = null;
					ItemMeta meta = null;
					if (steps.containsKey(p)) {
						int step = steps.get(p);
						switch (step) {
						case 1:
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
							meta = item.getItemMeta();
							inv.setItem(4, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
							meta = item.getItemMeta();
							inv.setItem(22, item);
							break;
						case 2:
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
							meta = item.getItemMeta();
							inv.setItem(9, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
							meta = item.getItemMeta();
							inv.setItem(17, item);
							break;
						case 3:
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
							meta = item.getItemMeta();
							inv.setItem(10, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
							meta = item.getItemMeta();
							inv.setItem(16, item);
							break;
						case 4:
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
							meta = item.getItemMeta();
							inv.setItem(11, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
							meta = item.getItemMeta();
							inv.setItem(15, item);
							break;
						case 5:
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
							meta = item.getItemMeta();
							inv.setItem(12, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
							meta = item.getItemMeta();
							inv.setItem(14, item);
							break;
						case 6:
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(0, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(8, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(18, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(26, item);
							break;
						case 7:
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(1, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(19, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(7, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(25, item);
							break;
						case 8:
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(2, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(20, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(6, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(24, item);
							break;
						case 9:
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(3, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(21, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(5, item);
							item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
							meta = item.getItemMeta();
							inv.setItem(23, item);
							break;
						case 10:
							item = new ItemStack(Material.COMPASS, 1);
							meta = item.getItemMeta();
							meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
							meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							item.setItemMeta(meta);
							inv.setItem(13, item);

							step = 0;
							timers.get(p).cancel();
							timers.remove(p);
							return;

						}
						if (item != null && item.hasItemMeta()) {
							meta.setDisplayName("");
							item.setItemMeta(meta);
						}
						p.playSound(p.getEyeLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
						p.openInventory(inv);

						step++;
						steps.remove(p);
						steps.put(p, step);
					}

				}
			});
			timers.get(p).runTaskTimer(Essentials.getinstance(), 0, 3);
		}
	}

}
