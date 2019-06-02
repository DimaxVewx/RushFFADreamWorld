package mc.dimax.rushffa.Listeners;

import mc.dimax.rushffa.Coins.Coins;
import mc.dimax.rushffa.Main;
import mc.dimax.rushffa.Utils.Booster;
import mc.dimax.rushffa.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillStreakListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        e.getDrops().clear();
        e.setDeathMessage(null);
        Coins coins = new Coins();
        if(player.getKiller() != null){
            Player killer = player.getKiller();
            ItemBuilder pomme = new ItemBuilder(Material.GOLDEN_APPLE, 1);
            ItemBuilder tnt = new ItemBuilder(Material.TNT, 1);
            killer.getInventory().addItem(pomme.toItemStack());
            killer.getInventory().addItem(tnt.toItemStack());


            Main.getInstance().getKillstreak().remove(player.getUniqueId());
            if(Booster.getMode() == true){
                coins.addCoins(killer, 1 * Booster.getMultiplier());
                Main.getInstance().title.sendActionBar(killer,"§bVous avez reçu §b"+1 * Booster.getMultiplier()+"§bcoins et une §apomme dorée");
            } else {
                coins.addCoins(killer, 1);
                Main.getInstance().title.sendActionBar(player, "§bVous avez reçu 1 coins et une §apomme dorée.");
            }
            if (Main.getInstance().getKillstreak().get(killer.getUniqueId()) == null) {
                Main.getInstance().getKillstreak().put(killer.getUniqueId(), 1);

            } else {
                Main.getInstance().getKillstreak().put(killer.getUniqueId(),
                        Main.getInstance().getKillstreak().get(killer.getUniqueId()) + 1);

            }

            if (Main.getInstance().getKillstreak().get(killer.getUniqueId()) == 3) {
                Bukkit.broadcastMessage("§a" + killer.getName() + " §evient de faire §a3kills §estopper, le §e!");
            }

            if (Main.getInstance().getKillstreak().get(killer.getUniqueId()) == 5) {
                Bukkit.broadcastMessage("§a" + killer.getName() + " §evient de faire §a5kills §estopper le, §e!");
            }

            if (Main.getInstance().getKillstreak().get(killer.getUniqueId()) == 8) {
                Bukkit.broadcastMessage("§a" + killer.getName() + " §evient de faire §a8kills §estopper le, §a#CHEVALIER §e!");
            }

            if (Main.getInstance().getKillstreak().get(killer.getUniqueId()) == 10) {
                Bukkit.broadcastMessage("§a" + killer.getName() + " §evient de faire §a10kills §estopper le, §4#DEMON §e!");
            }

            if (Main.getInstance().getKillstreak().get(killer.getUniqueId()) == 15) {
                Bukkit.broadcastMessage("§a" + killer.getName() + " §evient de faire §a15kills §estopper le, §7#SUPERHERO §e!");
            }

            if (Main.getInstance().getKillstreak().get(killer.getUniqueId()) == 20) {
                Bukkit.broadcastMessage("§a" + killer.getName() + " §evient de faire §a20kills §estopper le, §2#INVINCIBLE §e!");
            }

            if (Main.getInstance().getKillstreak().get(killer.getUniqueId()) == 25) {
                Bukkit.broadcastMessage("§a" + killer.getName() + " §evient de faire §a25kills §estopper le, §b#DIEU §e!");
            }

        }
    }

}
