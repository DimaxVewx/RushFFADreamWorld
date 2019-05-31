package mc.dimax.rushffa.Menus;

import mc.dimax.rushffa.Utils.ItemBuilder;
import mc.dimax.rushffa.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class HubMenu implements Listener {
    public static void open(Player player){
        Inventory inv = Bukkit.createInventory(null, 9, "§cRetour vers le lobby");

        ItemBuilder hub = new ItemBuilder(Material.BED).setName("§cTéléportation vers le lobby");

        inv.setItem(4, hub.toItemStack());

        player.openInventory(inv);
    }

    @EventHandler
    public void click(InventoryClickEvent e){
        if(e.getInventory().getName().equalsIgnoreCase("§cRetour vers le lobby")){
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)return;
            switch (e.getCurrentItem().getItemMeta().getDisplayName()){

                case "§cTéléportation vers le lobby":
                    PlayerUtils.connect(player, "lobby");
                    player.sendMessage("§cTéléportation faite.....");
                    player.closeInventory();
                    break;


                default:
                    break;
            }
        }
    }
}


