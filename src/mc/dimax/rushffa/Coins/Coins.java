package mc.dimax.rushffa.Coins;

import mc.dimax.rushffa.Main;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Coins {
    public void createAccount(Player player, double coins) {
        try {
            PreparedStatement sts = Main.getInstance().mysql.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();

            if (!rs.next()) {
                sts.close();
                sts = Main.getInstance().mysql.getConnection().prepareStatement("INSERT INTO coins (player_uuid, coins) VALUES (?, ?)");
                sts.setString(1, player.getUniqueId().toString());
                sts.setDouble(2, coins);
                sts.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getCoins(Player player) {
        try {
            PreparedStatement sts = Main.getInstance().mysql.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();

            if (rs.next()) {
                return rs.getDouble("coins");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addCoins(Player player, double coins) {
        if (coins < 1) return;
        try {
            PreparedStatement sts = Main.getInstance().mysql.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();

            if (rs.next()) {
                long money = rs.getLong("coins");
                sts.close();
                sts = Main.getInstance().mysql.getConnection().prepareStatement("UPDATE coins SET coins=? WHERE player_uuid=?");
                sts.setDouble(1, (coins + money));
                sts.setString(2, player.getUniqueId().toString());
                sts.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCoins(Player player, double coins) {
        if (coins < 1) return;
        try {
            PreparedStatement sts = Main.getInstance().mysql.getConnection().prepareStatement("SELECT coins FROM coins WHERE player_uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();

            if (rs.next()) {
                long money = rs.getLong("coins");
                sts.close();

                if ((money - coins) < 0) {
                    coins = money;
                }

                sts = Main.getInstance().mysql.getConnection().prepareStatement("UPDATE coins SET coins=? WHERE player_uuid=?");
                sts.setDouble(1, (money - coins));
                sts.setString(2, player.getUniqueId().toString());
                sts.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
