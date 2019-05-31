package mc.dimax.rushffa.Utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import mc.dimax.rushffa.Main;
import org.bukkit.entity.Player;

public class PlayerUtils {
    public static void connect(Player player, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
    }
}
