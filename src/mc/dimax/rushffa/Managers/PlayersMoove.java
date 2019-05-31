package mc.dimax.rushffa.Managers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayersMoove implements Listener {


    @EventHandler
    public void onMoove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        if(player.getLocation().getY() <= -25 && player.getHealth() > 0 ){
            player.setHealth(0);
        }
    }
}
