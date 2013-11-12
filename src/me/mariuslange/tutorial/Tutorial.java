package me.mariuslange.tutorial;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin 
{
	@Override
	public void onEnable()
	{
		System.out.println("Das Plugin wurde erfolgreich geladen!");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if(!(sender instanceof Player))
		{
			System.out.println("Befehle koennen nur Ingame ausgefuehrt werden!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("tutorial"))
		{
			p.sendMessage("Du hast den Befehl /tutorial eingegeben!");
			p.sendMessage(ChatColor.RED + "Dieser Text ist rot. " + ChatColor.GREEN + "Und dieser Text ist grün.");
			p.sendMessage("§6Dieser Text ist orange. §1Und dieser ist blau.");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("info"))
		{
			p.sendMessage("§6Infos über §c" + p.getName());
			p.sendMessage("§6Deine Herzen: §c" + p.getHealth()/2);
			p.sendMessage("§6Deine Hungerkeulchen: §c" + p.getFoodLevel()/2);
			p.sendMessage("§6Deine EXP: §c" + p.getExp());
			p.sendMessage("§Deine \"LastDamage\": §c" + p.getLastDamage());
		}
		return true;
	}
}