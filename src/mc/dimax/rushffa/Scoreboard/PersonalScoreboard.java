package mc.dimax.rushffa.Scoreboard;

import mc.dimax.rushffa.Coins.Coins;
import mc.dimax.rushffa.Main;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

/*
 * This file is part of SamaGamesAPI.
 *
 * SamaGamesAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SamaGamesAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SamaGamesAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class PersonalScoreboard {
    private Player player;
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;

    public int getPing(Player player) {
        return ((CraftPlayer) player).getHandle().ping;
    }

    PersonalScoreboard(Player player){
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "DreamWorld");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData(){}

    public void setLines(String ip){
        Coins coins = new Coins();
        objectiveSign.setDisplayName("§b§l§nDream§a§l§nWorld");


        objectiveSign.setLine(0, "         §c§k! §4Serveur en beta §c§k!");
        objectiveSign.setLine(1, "§1");
        objectiveSign.setLine(2, "   §7Mort(s): §a"+ player.getStatistic(Statistic.DEATHS));
        objectiveSign.setLine(3, "   §7Kill(s): §a" + player.getStatistic(Statistic.PLAYER_KILLS));
        objectiveSign.setLine(4, "   §7Ping: §a"+ getPing(player));
        objectiveSign.setLine(5, "   §7Coins: §a"+ coins.getCoins(player));
        objectiveSign.setLine(6, "§7");
        objectiveSign.setLine(7, "   §7Blocks: "+ String.format("§b%d:%02d", Main.getInstance().timerblock.getTimer() / 60, Main.getInstance().timerblock.getTimer() % 60));
        objectiveSign.setLine(8, "   §7Joueurs: §b"+Bukkit.getOnlinePlayers().size());
        objectiveSign.setLine(9, "   §7Serveur: §bRushFFA #1");
        objectiveSign.setLine(10, "   §2");
        objectiveSign.setLine(11, "    "+ip);

        objectiveSign.updateLines();
    }

    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}
