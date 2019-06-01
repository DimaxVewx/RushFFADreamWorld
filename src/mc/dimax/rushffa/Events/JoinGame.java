package mc.dimax.rushffa.Events;

import mc.dimax.rushffa.Main;
import mc.dimax.rushffa.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class JoinGame implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        PermissionUser user = PermissionsEx.getUser(player);
        player.teleport(new Location(Bukkit.getWorld("ffarush"), -1446.5, 105, -594.2));
        Main.getInstance().getScoreboardManager().onLogin(player);
        ItemBuilder jouer = new ItemBuilder(Material.IRON_AXE).setName("§bJouer au jeu").setUnbreakable(true);
        ItemBuilder infos = new ItemBuilder(Material.REDSTONE).setName("§aVos informations");
        ItemBuilder spec = new ItemBuilder(Material.NETHER_STAR).setName("§bMode spectateur");
        ItemBuilder hub = new ItemBuilder(Material.BED).setName("§cRevenir au lobby");
        player.getInventory().clear();
        player.getInventory().setItem(4, infos.toItemStack());
        player.getInventory().setItem(0, jouer.toItemStack());
        player.getInventory().setItem(8, hub.toItemStack());
        player.getInventory().setItem(1, spec.toItemStack());
        Main.getInstance().title.sendFullTitle(player, 20, 100, 20, "§cRushFFA", "§c§k! §4Ce mode de jeu est en BETA §c§k!");
        Main.getInstance().title.sendActionBar(player, "§bNous sommes §7: "+Bukkit.getOnlinePlayers().size()+" §bconnectés");
        e.setJoinMessage("§4" +user.getName()+" §crejoint le rushffa");




    }



}
