package mc.dimax.rushffa.Events;

import mc.dimax.rushffa.Main;
import mc.dimax.rushffa.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerDrop implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        e.setCancelled(true);
    }



    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Player player = e.getPlayer();
        e.setRespawnLocation(new Location(Bukkit.getWorld("ffarush"), -1446.5, 105, -594.2));
        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 1, 1);
        Main.getInstance().title.sendTitle(player, 20, 100, 20, "§4Vous êtes mort.");
        ItemBuilder jouer = new ItemBuilder(Material.IRON_AXE).setName("§bJouer au jeu").setUnbreakable(true);
        ItemBuilder profil = new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setSkullOwner(player.getName()).setName("§aStatistiques");
        ItemBuilder jouer2 = new ItemBuilder(Material.GOLD_AXE).setName("§6Jouer au jeu (VIP)");
        ItemBuilder hub = new ItemBuilder(Material.BED).setName("§cRevenir au lobby");
        player.getInventory().clear();
        player.getInventory().setItem(4, profil.toItemStack());
        player.getInventory().setItem(0, jouer.toItemStack());
        player.getInventory().setItem(8, hub.toItemStack());
        player.getInventory().setItem(1, jouer2.toItemStack());

        if(player.getKiller() != null){
            Player killer = player.getKiller();

        }





        player.updateInventory();
    }



}
