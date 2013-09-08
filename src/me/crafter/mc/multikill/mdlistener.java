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
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" ɱ���� "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" �Ӷ��ս������Ĵ���������");
			}
			if (handle==4){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" ɱ���� "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" �Ӷ��ս������ı������ˣ�");
			}
			if (handle==5){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" ɱ���� "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" �Ӷ��ս������ı�ɱ����ħ�ˣ�");
			}
			if (handle==6){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" ɱ���� "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" �Ӷ��ս��������޿ɾ�ҩ��");
			}
			if (handle==7){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" ɱ���� "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" �Ӷ��ս�������ɱ�ñ�̬�ˣ�");
			}
			if (handle==8){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" ɱ���� "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" �Ӷ��ս����������ְ㱻ɱ��");
			}
			if (handle==9){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" ɱ���� "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" �Ӷ��ս�������ɱ�����һ���ˣ�");
			}
			if (handle>9){
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getDisplayName()+ChatColor.DARK_AQUA+" ɱ���� "+ChatColor.RED+pp.getDisplayName()+ChatColor.DARK_AQUA+" �Ӷ��ս�������Խ��ı�ɱ���������������˰���");
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
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" ���ڴ���������");
		}
		if (handle==4){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" �������ˣ�");
		}
		if (handle==5){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" ��ɱ����ħ�ˣ�");
		}
		if (handle==6){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" �޿ɾ�ҩ�ˣ�");
		}
		if (handle==7){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" ��ɱ�ñ�̬�ˣ�");
		}
		if (handle==8){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" ���������ְ㱻ɱ��");
		}
		if (handle==9){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" �Ѿ���ɱ�����һ���ˣ�");
		}
		if (handle>9){
			Bukkit.broadcastMessage(ChatColor.RED+p.getDisplayName()+ChatColor.DARK_AQUA+" �Ѿ���Խ��ı�ɱ������˭ȥ�����ɣ�");
		}
			
			
	}
}
