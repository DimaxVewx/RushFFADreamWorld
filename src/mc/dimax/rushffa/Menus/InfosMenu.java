package mc.dimax.rushffa.Menus;

import mc.dimax.rushffa.Coins.Coins;
import mc.dimax.rushffa.SousMenus.InfosPersonnel;
import mc.dimax.rushffa.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InfosMenu implements Listener {
    public static void open(Player player){
        Coins coins = new Coins();
        Inventory inv = Bukkit.createInventory(null, 54, "§aInformations");

        ItemBuilder infos = new ItemBuilder(Material.BLAZE_POWDER).setName("§bCompte")
                .setLore("§bCompte: §b" +player.getName());
        inv.setItem(21, infos.toItemStack());

        ItemBuilder infos2 = new ItemBuilder(Material.PAPER).setName("§aInformations général")
                .setLore("§bAdresse: §c"+player.getAddress(),"§bCoins: §c"+coins.getCoins(player));
        inv.setItem(23, infos2.toItemStack());

        ItemBuilder end = new ItemBuilder(Material.WOOD_DOOR).setName("§cFermer le menu");
        inv.setItem(53, end.toItemStack());

        player.openInventory(inv);
    }

    @EventHandler
    public void click(InventoryClickEvent e){
        if(e.getInventory().getName().equalsIgnoreCase("§aInformations")){
            Player player = (Player) e.getWhoClicked();

            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)return;
            switch (e.getCurrentItem().getItemMeta().getDisplayName()){

                case "§bCompte":
                    player.sendMessage("§7ton pseudo §b" +player.getName());
                    player.closeInventory();
                    break;

                case "§aInformations général":
                    player.sendMessage("§bOuverture du sous-menu.....");
                    player.closeInventory();
                    InfosPersonnel.open(player);
                    break;

                case "§cFermer le menu":
                    player.closeInventory();

                    break;


                default:
                    break;
            }
        }
    }
}


