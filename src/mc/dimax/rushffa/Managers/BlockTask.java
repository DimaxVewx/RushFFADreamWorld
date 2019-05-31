package mc.dimax.rushffa.Managers;

import mc.dimax.rushffa.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;
public class BlockTask extends BukkitRunnable {

    private int timer = 300;

    @Override
    public void run() {

        switch (timer) {
            case 30:
                Bukkit.broadcastMessage("§7[§bRush§7FFA§b]§cTout les blocks poser vont être supprimés dans : §a30secondes");
                break;
            case 15:
                Bukkit.broadcastMessage("§7[§bRush§7FFA§b]§cTout les blocks poser vont être supprimés dans : §a15secondes");
                break;
            case 5:
                Bukkit.broadcastMessage("§7[§bRush§7FFA§b]§cTout les blocks poser vont être supprimés dans : §a5secondes");
                //Bukkit.broadcastMessage("");
                break;
            case 0:
                for (Block block : Main.getInstance().getBlocks()) {
                    block.setType(Material.AIR);
                }
                Bukkit.broadcastMessage("§7[§bRush§7FFA§b]§cTout les blocks poser ont été §asupprimés");
                timer = 300;

                break;
            default:
                break;
        }

        timer--;
    }
}
