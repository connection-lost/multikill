package me.crafter.mc.multikill;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class mklistener implements Listener {

	private HashMap<Player, Integer> killcount = new HashMap<Player, Integer>();
	
	@EventHandler
	public void BreakSpree(EntityDeathEvent death){
	    if (!(death.getEntity() instanceof Player)) {
	        return;
	      }
	    Player p = (Player)death.getEntity();
	    if (!(death.getEntity().getKiller() instanceof Player)) {
	        return;
	    }
	    Player pp = death.getEntity().getKiller();

	    if (this.killcount.containsKey(p)) {
	    	
	    	Integer handle = killcount.get(p).intValue();
		    
			if (handle<3) return;
			
			if (handle==3){
				Bukkit.broadcastMessage(ChatColor.GREEN+pp.getDisplayName()+ChatColor.DARK_AQUA+" 终结了 "+ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 的大杀特杀！");
			}
			if (handle==4){
				Bukkit.broadcastMessage(ChatColor.GREEN+pp.getDisplayName()+ChatColor.DARK_AQUA+" 终结了 "+ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 的主宰服务器！");
			}
			if (handle==5){
				Bukkit.broadcastMessage(ChatColor.GREEN+pp.getDisplayName()+ChatColor.DARK_AQUA+" 终结了 "+ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 的杀人如麻！");
			}
			if (handle==6){
				Bukkit.broadcastMessage(ChatColor.GREEN+pp.getDisplayName()+ChatColor.DARK_AQUA+" 终结了 "+ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 的无人能挡！");
			}
			if (handle==7){
				Bukkit.broadcastMessage(ChatColor.GREEN+pp.getDisplayName()+ChatColor.DARK_AQUA+" 终结了 "+ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 的杀得变态了！");
			}
			if (handle==8){
				Bukkit.broadcastMessage(ChatColor.GREEN+pp.getDisplayName()+ChatColor.DARK_AQUA+" 终结了 "+ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 的妖怪般杀戮！");
			}
			if (handle==9){
				Bukkit.broadcastMessage(ChatColor.GREEN+pp.getDisplayName()+ChatColor.DARK_AQUA+" 终结了 "+ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 的如同神一般！");
			}
			if (handle>9){
				Bukkit.broadcastMessage(ChatColor.GREEN+pp.getDisplayName()+ChatColor.DARK_AQUA+" 终结了 "+ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" 的超越神！");
			}
	    	
	    	
			this.killcount.remove(p);
		}
	}
	
	@EventHandler
	public void KillSpree(EntityDeathEvent death){
	    if (!(death.getEntity() instanceof Player)) {
	        return;
	      }
	    Player p = death.getEntity().getKiller();
	    if (!(p instanceof Player)) {
	        return;
	      }
	    
	    if (this.killcount.containsKey(p)) {
			Integer number = killcount.get(p);
			this.killcount.remove(p);
			this.killcount.put(p, new Integer (number.intValue()+1));
		}
		else {
			this.killcount.put(p, new Integer (1));
		}
		
		Integer handle = killcount.get(p).intValue();
	    
		if (handle<3) return;
		
		if (handle==3){
			Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 正在大杀特杀！");
		}
		if (handle==4){
			Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 主宰服务器！");
		}
		if (handle==5){
			Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 杀人如麻！");
		}
		if (handle==6){
			Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 无人能挡！");
		}
		if (handle==7){
			Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 杀得变态了！");
		}
		if (handle==8){
			Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 正在像妖怪般杀戮！");
		}
		if (handle==9){
			Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 如同神一般！");
		}
		if (handle>9){
			Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" 已经超越神了！拜托谁去杀了他吧！");
		}
	}
}
