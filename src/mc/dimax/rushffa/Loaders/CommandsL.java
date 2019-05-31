package mc.dimax.rushffa.Loaders;

import mc.dimax.rushffa.Commands.CommandeSetSpawn;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandsL {
    public static void load(JavaPlugin plugin){
        plugin.getCommand("setspawn").setExecutor(new CommandeSetSpawn());

    }
}