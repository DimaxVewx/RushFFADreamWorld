package mc.dimax.rushffa.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Inventaire implements Listener {

        @EventHandler
        public void onClickinv(InventoryClickEvent e){

            if (!e.getCurrentItem().getType().equals(Material.SANDSTONE)){
                e.setCancelled(true);
            }
        }
    }

