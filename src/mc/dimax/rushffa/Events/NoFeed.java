package mc.dimax.rushffa.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoFeed implements Listener {

    @EventHandler
    public void onfeed(FoodLevelChangeEvent e){
        e.setFoodLevel(20);
    }
}
