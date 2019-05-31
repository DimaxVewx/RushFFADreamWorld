package mc.dimax.rushffa.Managers;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.UUID;

public class CoordonatesManager {

    private String name;
    private int id;
    private boolean gameStarted;
    private ArrayList<UUID> playersInRush;
    private Location spawn;

    public CoordonatesManager(String name, int id, boolean gameStarted, ArrayList<UUID> playersInRush, Location spawn) {
        this.name = name;
        this.id = id;
        this.gameStarted = gameStarted;
        this.playersInRush = playersInRush;
        this.spawn = spawn;
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setSpawn(Location spawn1) {
        this.spawn = spawn1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public ArrayList<UUID> getPlayersInRush() {
        return playersInRush;
    }

    public void setPlayersInRush(ArrayList<UUID> playersInArena) {
        this.playersInRush = playersInArena;
    }

}
