package mc.dimax.rushffa.Menus;

import mc.dimax.rushffa.Coins.Coins;
import mc.dimax.rushffa.SousMenus.InfosPersonnel;
import mc.dimax.rushffa.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class InfosMenu implements Listener {
    public int getPing(Player player) {
        return ((CraftPlayer) player).getHandle().ping;
    }
    public static void open(Player player){
        Coins coins = new Coins();
        PermissionUser user = PermissionsEx.getUser(player);

        Inventory inv = Bukkit.createInventory(null, 9, "§aInformations");


        ItemBuilder stats = new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setSkullOwner(player.getName()).setName("§aStatistiques")
                .setLore("§cGrade: "+user.getPrefix().replaceAll("&", "§"),
                "§7Morts §c"+player.getStatistic(Statistic.DEATHS),
                "§7Kills §b"+player.getStatistic(Statistic.PLAYER_KILLS),
                "§7Ratio §b"+Double.toString((double) Math.round(getRatio(player) * 100) / 100),
                "§7Coins §b"+ coins.getCoins(player)+"§b⛁");


        inv.setItem(4, stats.toItemStack());



        player.openInventory(inv);
    }

    public static double getRatio(Player player){
        int kills = player.getStatistic(Statistic.PLAYER_KILLS);
        double deaths = player.getStatistic(Statistic.DEATHS);
        double ratio = kills / deaths;
        return ratio;
    }

    @EventHandler
    public void click(InventoryClickEvent e){
        if(e.getInventory().getName().equalsIgnoreCase("§aInformations")){
            Player player = (Player) e.getWhoClicked();

            if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)return;
            switch (e.getCurrentItem().getItemMeta().getDisplayName()){

                case "§aStatistiques":
                    player.sendMessage("§7ton pseudo §b" +player.getName());
                    player.closeInventory();
                    break;


                default:
                    break;
            }
        }
    }
}


