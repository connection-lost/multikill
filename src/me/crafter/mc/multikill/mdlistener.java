package me.crafter.mc.multikill;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class mdlistener implements Listener {

	private HashMap<Player, Integer> deathcount = new HashMap<Player, Integer>();
	
	@EventHandler
	
	public void BreakSpree(EntityDeathEvent death){
	    if (!(death.getEntity() instanceof Player)) {
	        return;
	      }
	    Player p = death.getEntity().getKiller();
	    if (!(p instanceof Player)) {
	        return;
	      }
	    Player pp = (Player)death.getEntity();
	    if (this.deathcount.containsKey(p)) {
	    	Integer handle = deathcount.get(p).intValue();
	    	if (handle<3) return;
	    	
	    	if (handle==3){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 杀死了 "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" 从而终结了他的大死特死！");
			}
			if (handle==4){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 杀死了 "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" 从而终结了他的被主宰了！");
			}
			if (handle==5){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 杀死了 "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" 从而终结了他的被杀得入魔了！");
			}
			if (handle==6){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 杀死了 "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" 从而终结了他的无可救药！");
			}
			if (handle==7){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 杀死了 "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" 从而终结了他被杀得变态了！");
			}
			if (handle==8){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 杀死了 "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" 从而终结了他像妖怪般被杀！");
			}
			if (handle==9){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 杀死了 "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" 从而终结了他被杀的像鬼一样了！");
			}
			if (handle>9){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 杀死了 "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" 从而终结了他超越鬼的被杀！终于有人送他了啊！");
			}
	    	
			this.deathcount.remove(p);
		}
	}
	
	@EventHandler
	
	public void DeathSpree(EntityDeathEvent death){
	    if (!(death.getEntity() instanceof Player)) {
	        return;
	      }
		Player p = (Player)death.getEntity();
		if (this.deathcount.containsKey(p)) {
			Integer number = deathcount.get(p);
			this.deathcount.remove(p);
			this.deathcount.put(p, new Integer (number.intValue()+1));
		}
		else {
			this.deathcount.put(p, new Integer (1));
		}
		
		Integer handle = deathcount.get(p).intValue();
		
		if (handle<3) return;
		
		if (handle==3){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 正在大死特死！");
		}
		if (handle==4){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 被主宰了！");
		}
		if (handle==5){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 被杀得入魔了！");
		}
		if (handle==6){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 无可救药了！");
		}
		if (handle==7){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 被杀得变态了！");
		}
		if (handle==8){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 正在像妖怪般被杀！");
		}
		if (handle==9){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 已经被杀的像鬼一样了！");
		}
		if (handle>9){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 已经超越鬼的被杀！拜托谁去送他吧！");
		}
			
			
	}
}
