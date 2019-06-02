package mc.dimax.rushffa.Commands;

import mc.dimax.rushffa.Utils.Booster;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BoosterCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("booster")){
            Player p = (Player)commandSender;
            if(args.length == 0){
                if(p.isOp()){
                    p.sendMessage("§6---------------------------------------");
                    p.sendMessage("§b/booster custom <multiplier> §ePermet d'activer un booster avec un multiplieur spécifique.");
                    p.sendMessage("§b/booster off §ePermet de désactiver le Booster actuel.");
                    p.sendMessage("§6----------------------------------------");
                } else {
                    p.sendMessage("§cTu n'as pas la permission d'éxécuter cette commande !");
                }
            } else if(args[0].equalsIgnoreCase("on")){
                for(Player pls : Bukkit.getOnlinePlayers()){
                    Booster.setMultiplier(2);
                    Booster.setBoostingMode(true);
                    Booster.booster.add(pls);
                    commandSender.sendMessage("§aOK");
                    Bukkit.broadcastMessage("§b§lUn booster a été activé par un administrateur pendant une durée déterminée. Vos gains de coins sont multipliés par 2.");
                }
            } else if(args[0].equalsIgnoreCase("off")){
                for(Player pls : Bukkit.getOnlinePlayers()){
                    Booster.setMultiplier(1);
                    Booster.setBoostingMode(false);
                    Booster.booster.remove(pls);
                    commandSender.sendMessage("§aOK");
                }
            } else if(args[0].equalsIgnoreCase("custom")){
                int multiplier = Integer.valueOf(args[1]);
                for(Player pls : Bukkit.getOnlinePlayers()){
                    if(Booster.booster.contains(p)){
                        commandSender.sendMessage("§cVous devez d'abord enlever les joueurs de l'ArrayList en faisant un /booster off");
                    } else {
                        Booster.setMultiplier(Integer.valueOf(args[1]));
                        Booster.setBoostingMode(true);
                        Booster.booster.add(pls);
                        commandSender.sendMessage("§aVous avez mit un booster de §a"+args[1]+"§a.");
                        pls.sendMessage("§b§lUn booster a été activé par un administrateur pendant une durée déterminée. Vos gains de coins sont multipliés par §a"+args[1]+"§a.");
                    }
                }
            }
        }
        return true;
    }
}