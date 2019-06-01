package mc.dimax.rushffa;

import mc.dimax.rushffa.Loaders.Loaders;
import mc.dimax.rushffa.Managers.BlockTask;
import mc.dimax.rushffa.Managers.CoordonatesManager;
import mc.dimax.rushffa.MySQL.MySQL;
import mc.dimax.rushffa.Scoreboard.ScoreboardManager;
import mc.dimax.rushffa.Utils.Title;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends JavaPlugin {
    private static Main instance;
    private ScoreboardManager scoreboardManager;
    public List<CoordonatesManager> coordonatesManagerList = new ArrayList<>();

    public MySQL mysql = new MySQL();

    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;
    public BlockTask timerblock = new BlockTask();

    private Map<UUID, Integer> killstreak;
    private List<Block> blocks;
    public Title title = new Title();

    @Override
    public void onEnable() {
        mysql.connect("91.134.172.75", "mc", 3306, "mc", "EZIPEZHUeuhzezbzqeezygzezkebze");
        instance = this;
        // Loaders
        Loaders.load(this);
        registerCoordonates();
        LoadBorders();

        Bukkit.getWorld("trush").setTime(600);
        Bukkit.getWorld("trush").setGameRuleValue("doDaylightCycle", "false");
        Bukkit.getWorld("ffarush").setTime(600);
        Bukkit.getWorld("ffarush").setGameRuleValue("doDaylightCycle", "false");
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        scheduledExecutorService = Executors.newScheduledThreadPool(16);
        executorMonoThread = Executors.newScheduledThreadPool(1);
        scoreboardManager = new ScoreboardManager();
        killstreak = new HashMap<>();
        blocks = new ArrayList<>();
        timerblock.runTaskTimer(this, 200, 20);

    }

    public void LoadBorders() {
        World w = Bukkit.getWorld("trush");
        WorldBorder bordure = w.getWorldBorder();
        bordure.setCenter(644.054, -272.508);
        bordure.setSize(200);

        World w2 = Bukkit.getWorld("ffarush");
        WorldBorder bordure2 = w2.getWorldBorder();
        bordure2.setCenter(-1446.520, -594.631);
        bordure2.setSize(39);
    }


    @Override
    public void onDisable() {
        getScoreboardManager().onDisable();
    }

    public static Main getInstance() {
        return instance;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public ScheduledExecutorService getExecutorMonoThread() {
        return executorMonoThread;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    public Map<UUID, Integer> getKillstreak() {
        return killstreak;
    }

    public List<CoordonatesManager> getCoordonatesManagerList() {
        return coordonatesManagerList;
    }

    public List<CoordonatesManager> getCoords() {
        return coordonatesManagerList;
    }

    public void registerCoordonates() {
        CoordonatesManager base1 = new CoordonatesManager("spawn00", 0, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 728.658, 5, -325.962));

        CoordonatesManager base2 = new CoordonatesManager("spawn01", 1, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 697.925, 5, -355.997));

        CoordonatesManager base3 = new CoordonatesManager("spawn02", 2, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 662.052, 5, -356.374));

        CoordonatesManager base4 = new CoordonatesManager("spawn03", 3, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 623.167, 8, -362.879));

        CoordonatesManager base5 = new CoordonatesManager("spawn04", 4, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 589.877, 5, -356.236));

        CoordonatesManager base6 = new CoordonatesManager("spawn05", 5, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 554.623, 7, -320.645));

        CoordonatesManager base7 = new CoordonatesManager("spawn06", 6, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 552.950, 8, -288.191));

        CoordonatesManager base8 = new CoordonatesManager("spawn07", 7, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 560.041, 5, -253.545));

        CoordonatesManager base9 = new CoordonatesManager("spawn08", 8, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 555.035, 6.5, -222.830));

        CoordonatesManager base10 = new CoordonatesManager("spawn09", 9, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 589.867, 8, -181.540));

        CoordonatesManager base11 = new CoordonatesManager("spawn10", 10, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 625.132, 5, -189.413));

        CoordonatesManager base12 = new CoordonatesManager("spawn11", 11, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 665.857, 7, -183.561));

        CoordonatesManager base13 = new CoordonatesManager("spawn12", 12, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 697.112, 8, -183.122));

        CoordonatesManager base14 = new CoordonatesManager("spawn13", 13, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 728, 5, -217.988));

        CoordonatesManager base15 = new CoordonatesManager("spawn14", 14, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 733.505, 7, -249.088));

        CoordonatesManager base16 = new CoordonatesManager("spawn15", 15, false, new ArrayList<>(),
                new Location(Bukkit.getWorld("trush"), 734.999, 8, -288.206));

        coordonatesManagerList.add(base1);
        coordonatesManagerList.add(base2);
        coordonatesManagerList.add(base3);
        coordonatesManagerList.add(base4);
        coordonatesManagerList.add(base5);
        coordonatesManagerList.add(base6);
        coordonatesManagerList.add(base7);
        coordonatesManagerList.add(base8);
        coordonatesManagerList.add(base9);
        coordonatesManagerList.add(base10);
        coordonatesManagerList.add(base11);
        coordonatesManagerList.add(base12);
        coordonatesManagerList.add(base13);
        coordonatesManagerList.add(base14);
        coordonatesManagerList.add(base15);
        coordonatesManagerList.add(base16);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    Collections.shuffle(coordonatesManagerList);
                }
            }
        }, 0, 100L);
    }
}
