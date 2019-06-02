package mc.dimax.rushffa.Utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Booster {

    public static ArrayList<Player> booster = new ArrayList<>();

    public static ArrayList getBooster(){return booster;}
    private static int multiply;
    private static boolean moding;

    public static void setMultiplier(int multiplier){
        multiply = multiplier;
    }

    public static int getMultiplier() {
        return multiply;
    }

    public static Boolean setBoostingMode(boolean mode){
        moding = mode;
        return moding;
    }

    public static Boolean getMode(){
        return moding;
    }
}