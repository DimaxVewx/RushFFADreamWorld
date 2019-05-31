package mc.dimax.rushffa.Loaders;

import org.bukkit.plugin.java.JavaPlugin;

public class Loaders {
    public static void load(JavaPlugin plugin){
        EventsL.load(plugin);
        CommandsL.load(plugin);
    }
}
