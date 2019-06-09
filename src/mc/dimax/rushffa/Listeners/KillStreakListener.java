package mc.dimax.rushffa.Listeners;

import mc.dimax.rushffa.Coins.Coins;
import mc.dimax.rushffa.Main;
import mc.dimax.rushffa.Utils.ItemBuilder;
import mc.dimax.rushffa.Utils.Title;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_9_R2.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillStreakListener implements Listener {

    private static fr.nexusmc.api.coins.Coins coins = new fr.nexusmc.api.coins.Coins();

    @EventHandler(priority = EventPriority.HIGH)
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        e.getDrops().clear();
        e.setDeathMessage(null);
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            PacketPlayInClientCommand cmd = new PacketPlayInClientCommand(
                    PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN);
            ((CraftPlayer) player).getHandle().playerConnection.a(cmd);
            player.playSound(player.getLocation(), Sound.ENTITY_GHAST_HURT, 1, 1);
        }, 1L);
        if(player.getKiller() != null && player.getKiller() != player){

            Player killer = player.getKiller();
            ItemBuilder pomme = new ItemBuilder(Material.GOLDEN_APPLE, 1);
            ItemBuilder tnt = new ItemBuilder(Material.TNT, 1);
            killer.getInventory().addItem(pomme.toItemStack());
            killer.getInventory().addItem(tnt.toItemStack());
            coins.addCoins(killer, 1);
            Main.getInstance().title.sendActionBar(killer,"§bVous avez reçu 1coins une §apomme dorée et une tnt");
            Main.getInstance().getKillstreak().remove(player.getUniqueId());
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
