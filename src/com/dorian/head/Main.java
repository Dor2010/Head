package com.dorian.head;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
		
	}
	
	@EventHandler
	public void onPig(EntityDeathEvent e){
		if(e.getEntity() instanceof Pig) {
			Pig pig = (Pig) e.getEntity();
			if(pig.getKiller() != null) {
				Player p = (Player) pig.getKiller();
				ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
				ItemMeta headMeta = (SkullMeta) head.getItemMeta();
				headMeta.setDisplayName(ChatColor.BLUE + "Tête de Joueur");
				headMeta.setLore(Arrays.asList(ChatColor.GRAY + "Tête de " + p.getName()));
				((SkullMeta) headMeta).setOwner(p.getName());
				head.setItemMeta(headMeta);
				p.getInventory().addItem(head);
				
			}
		}
	}
	
}
