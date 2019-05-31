package mc.dimax.rushffa.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandeSetSpawn implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("spawn")) {
                if (args.length == 0) {
                    if (player.hasPermission("dreamworld.spawn")) {

                    } else {
                        player.sendMessage("§cTu ne peux pas faire /spawn sur ce serveur !");
                        return true;
                    }
                } else if (args.length == 1) {
                    if (player.hasPermission("dreamworld.tpspawn")) {

                    } else {
                        player.sendMessage("§cTu ne peux pas faire tp au spawn sur ce serveur !");
                        return true;
                    }
                } else {
                    player.sendMessage("§cFait: §5" + cmd.getUsage());
                }
            } else if (cmd.getName().equalsIgnoreCase("setspawn")) {
                if (player.hasPermission("dreamworld.setspawn")) {
                    if (args.length == 0) {

                    } else if (args.length == 3) {

                    } else if (args.length == 5) {

                    } else {
                        player.sendMessage("§cFait: §5" + cmd.getUsage());
                    }
                } else {
                    player.sendMessage("§4Tu n'as pas la permission !");
                    return true;
                }
            }

        } else {
            sender.sendMessage("§cSpawn ajouté");
            return true;
        }

        return true;
    }

}