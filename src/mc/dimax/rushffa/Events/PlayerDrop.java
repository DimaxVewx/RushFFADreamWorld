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
        ItemBuilder infos = new ItemBuilder(Material.REDSTONE).setName("§aVos informations");
        ItemBuilder spec = new ItemBuilder(Material.NETHER_STAR).setName("§bMode spectateur");
        ItemBuilder hub = new ItemBuilder(Material.BED).setName("§cRevenir au lobby");
        player.getInventory().clear();
        player.getInventory().setItem(4, infos.toItemStack());
        player.getInventory().setItem(0, jouer.toItemStack());
        player.getInventory().setItem(8, hub.toItemStack());
        player.getInventory().setItem(1, spec.toItemStack());

        if(player.getKiller() != null){
            Player killer = player.getKiller();

        }





        player.updateInventory();
    }



}
