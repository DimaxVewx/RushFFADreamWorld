package mc.dimax.rushffa.SousMenus;

import mc.dimax.rushffa.Menus.InfosMenu;
import mc.dimax.rushffa.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InfosPersonnel implements Listener {
    public static void open(Player player){
        Inventory inv = Bukkit.createInventory(null, 54, "§4Informations Personnel");


        ItemBuilder infos = new ItemBuilder(Material.BED).setName("§4Ton ip")
                .setLore("§4" +player.getAddress());

        inv.setItem(21, infos.toItemStack());

        ItemBuilder retour = new ItemBuilder(Material.WOOD_DOOR).setName("§cPage précédente");

        inv.setItem(53, retour.toItemStack());

        player.openInventory(inv);
    }

    @EventHandler
    public void click(InventoryClickEvent e){
        if(e.getInventory().getName().equalsIgnoreCase("§4Informations Personnel")){
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)return;
            switch (e.getCurrentItem().getItemMeta().getDisplayName()){

                case "§4Ton ip":
                    player.sendMessage("§cTon ip §4"+player.getAddress());
                    break;

                case "§cPage précédente":
                    player.closeInventory();
                    InfosMenu.open(player);
                    break;

                default:
                    break;
            }
        }
    }
}


