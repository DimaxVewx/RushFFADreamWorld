package mc.dimax.rushffa.Loaders;

import mc.dimax.rushffa.Events.*;
import mc.dimax.rushffa.Listeners.InteractMenu;
import mc.dimax.rushffa.Listeners.Inventaire;
import mc.dimax.rushffa.Listeners.KillStreakListener;
import mc.dimax.rushffa.Listeners.PlayerChat;
import mc.dimax.rushffa.Managers.BlockProtection;
import mc.dimax.rushffa.Managers.EntityDamageAndSpawn;
import mc.dimax.rushffa.Managers.PlayersMoove;
import mc.dimax.rushffa.Managers.Protection;
import mc.dimax.rushffa.Menus.HubMenu;
import mc.dimax.rushffa.Menus.InfosMenu;
import mc.dimax.rushffa.Menus.JouerAuJeu;
import mc.dimax.rushffa.SousMenus.InfosPersonnel;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EventsL {

    public static void load(JavaPlugin plugin){
        PluginManager pm = Bukkit.getPluginManager();
        // Joueurs events

        pm.registerEvents(new InteractMenu(), plugin);
        pm.registerEvents(new KillStreakListener(), plugin);
        pm.registerEvents(new JoinGame(), plugin);
        pm.registerEvents(new PlayerQuit(), plugin);
        pm.registerEvents(new PlayerDrop(), plugin);
        pm.registerEvents(new Inventaire(), plugin);
        pm.registerEvents(new NoFeed(), plugin);
        pm.registerEvents(new PlayersMoove(), plugin);
        pm.registerEvents(new PlayerChat(), plugin);

        // World events
        pm.registerEvents(new WeatherChange(), plugin);
        pm.registerEvents(new EntityDamageAndSpawn(), plugin);


        // protection block & interact
        pm.registerEvents(new Protection(), plugin);
        pm.registerEvents(new BlockProtection(), plugin);


        // Menus events
        pm.registerEvents(new JouerAuJeu(), plugin);
        pm.registerEvents(new HubMenu(), plugin);
        pm.registerEvents(new InfosMenu(), plugin);

        // Sous menus events
        pm.registerEvents(new InfosPersonnel(), plugin);
    }
}
