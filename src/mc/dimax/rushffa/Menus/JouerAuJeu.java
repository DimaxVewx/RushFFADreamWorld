package mc.dimax.rushffa.Menus;

import mc.dimax.rushffa.Kits.Joueur;
import mc.dimax.rushffa.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;


public class JouerAuJeu implements Listener {
    public static void open(Player player){
        Inventory inv = Bukkit.createInventory(null, 54, "§bRushFFA");

        ItemBuilder joueur = new ItemBuilder(Material.IRON_SWORD).setName("§7>> §bKit Joueur")
                .setLore("§e", "§btestun", "§btestdeux");

        inv.setItem(0, joueur.toItemStack());

        player.openInventory(inv);
    }

    @EventHandler
    public void click(InventoryClickEvent e){
        if(e.getInventory().getName().equalsIgnoreCase("§bRushFFA")){
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)return;
            switch (e.getCurrentItem().getItemMeta().getDisplayName()){

                case "§7>> §bKit Joueur":
                    player.closeInventory();
                    Joueur.kitSend(player);
                    player.sendMessage("§7[§bRushFFA§7] §aBon courage l'ami...");
                    break;


                default:
                    break;
            }
        }
    }
}

