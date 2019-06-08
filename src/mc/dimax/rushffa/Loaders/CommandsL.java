package mc.dimax.rushffa.Loaders;

import mc.dimax.rushffa.Commands.BoosterCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandsL {

    public static void load(JavaPlugin plugin){

        plugin.getCommand("booster").setExecutor(new BoosterCommand());
    }
}