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
            case 0:
                for (Block block : Main.getInstance().getBlocks()) {
                    block.setType(Material.AIR);
                }
                timer = 300;

                break;
            default:
                break;

        }


        timer--;
    }

    public int getTimer() {
        return timer;
    }
}
