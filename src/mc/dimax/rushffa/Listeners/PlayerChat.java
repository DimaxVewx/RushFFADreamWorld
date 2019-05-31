package mc.dimax.rushffa.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerChat implements Listener {

    @EventHandler
    public void chat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        PermissionUser user = PermissionsEx.getUser(player);
        e.setFormat(user.getPrefix().replaceAll("&", "§") + player.getName()+"§r: §r"+e.getMessage());
    }
}

