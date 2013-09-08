package me.crafter.mc.multikill;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class multikill extends JavaPlugin {
	
	public final Logger logger = Logger.getLogger("Mincraft");
	public final mdlistener mdl = new mdlistener();
	public final mklistener mkl = new mklistener();
	
 
    public void onEnable(){
    	PluginDescriptionFile pdfFile = getDescription();
        this.logger.info("MultiKill " + pdfFile.getVersion() + " has been ENABLED!");
        this.logger.info("MultiKill is a Rev-Craft custom plugin.");
        getServer().getPluginManager().registerEvents(this.mkl, this);
        getServer().getPluginManager().registerEvents(this.mdl, this);
        }
 

    public void onDisable() {
    	PluginDescriptionFile pdfFile = getDescription();
        this.logger.info("Multikill " + pdfFile.getVersion() + " has been DISABLED!");
    }
}
