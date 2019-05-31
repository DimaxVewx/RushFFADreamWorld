package mc.dimax.rushffa.Managers;

import mc.dimax.rushffa.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.ChatColor.*;

public class BlockProtection implements Listener {

    @EventHandler
    public void onPlayerBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Material blockType = block.getType();
        if (blockType == Material.SANDSTONE || blockType == Material.TNT) {

            if (event.getBlock().getType() != Material.TNT) {
                event.setCancelled(true);
                event.getBlock().setType(Material.AIR);
            }

            if (Main.getInstance().getBlocks().contains(block))
            Main.getInstance().getBlocks().remove(block);
        } else {
            event.setCancelled(true);
            player.sendMessage(RED + "Tu ne peux pas casser ce genre de block");
        }



    }



    @EventHandler
    public void onPlayerPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (block.getType().equals(Material.SANDSTONE)) {

            Main.getInstance().getBlocks().add(block);

            for (int i = 0; i < player.getInventory().getSize(); i++) {
                ItemStack itemStack = player.getInventory().getItem(i);
                if (itemStack != null && itemStack.getType().equals(Material.SANDSTONE)) {
                    int amount = 64;
                    itemStack.setAmount(amount);
                    player.getInventory().setItem(i, amount > 0 ? itemStack : null);
                    player.updateInventory();
                   break;
                }
            }
        } else if(block.getType().equals(Material.TNT)) {

            Main.getInstance().getBlocks().add(block);



        } else {
            event.setCancelled(true);
            player.sendMessage("§cTu ne peux pas construire avec ce block !");
        }
    }
}