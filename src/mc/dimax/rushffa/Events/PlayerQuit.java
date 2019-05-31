package mc.dimax.rushffa.Events;

import mc.dimax.rushffa.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();
        Main.getInstance().getScoreboardManager().onLogout(player);
        player.getInventory().clear();
        e.setQuitMessage(null);
    }

}
