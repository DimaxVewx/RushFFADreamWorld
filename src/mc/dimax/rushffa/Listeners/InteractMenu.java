package mc.dimax.rushffa.Listeners;

import mc.dimax.rushffa.Kits.Joueur;
import mc.dimax.rushffa.Kits.VIP;
import mc.dimax.rushffa.Main;
import mc.dimax.rushffa.Managers.CoordonatesManager;
import mc.dimax.rushffa.Menus.HubMenu;
import mc.dimax.rushffa.Menus.InfosMenu;
import mc.dimax.rushffa.Utils.ItemBuilder;
import mc.dimax.rushffa.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class InteractMenu implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if(e.getItem() != null){
            if(e.getItem().getType() == Material.IRON_AXE){
                Joueur.kitSend(player);
                Main.getInstance().getCoords().forEach(a -> {
                    player.teleport(a.getSpawn());
                });
                Main.getInstance().title.sendActionBar(player, "§aVoici ton kit, bon courage.");
            }
            if(e.getItem().getType() == Material.BED){
                Main.getInstance().title.sendTitle(player, 20, 100, 20, "§4Retour vers le lobby");
                PlayerUtils.connect(player, "lobby");
            }
            if(e.getItem().getType() == Material.SKULL_ITEM){
                InfosMenu.open(player);
            }
            if(e.getItem().getType() == Material.GOLD_AXE){
                if(player.hasPermission("rushffa.kitvip")){
                    Main.getInstance().title.sendActionBar(player, "§6Voici ton kit maitre...");
                    Main.getInstance().getCoords().forEach(a -> {
                        player.teleport(a.getSpawn());
                    });
                    VIP.kitSend(player);
                } else {
                    Main.getInstance().title.sendActionBar(player, "§6Tu n'as pas acheter ce kit depuis le hub.");

                }
            }
        }

    }
    @EventHandler
    public void InventoryClick(InventoryClickEvent e){




        if(e.getCurrentItem() == null) return;
        switch (e.getCurrentItem().getType()) {
            case SANDSTONE:
            case TNT:
            case FLINT_AND_STEEL:
            case IRON_PICKAXE:
            case IRON_SWORD:
            case GOLDEN_APPLE:
                e.setCancelled(false);
                break;
            default:
                e.setCancelled(true);
                break;
        }


        // POUR SPECTATEUR
        Player player = (Player) e.getWhoClicked();
        if(e.getCurrentItem() == null)
            return;
            if (e.getCurrentItem().getType() == Material.WOOD_DOOR) {
                    player.teleport(new Location(Bukkit.getWorld("ffarush"), -1446.5, 105, -594.2));
                    player.getInventory().clear();
                    ItemBuilder jouer = new ItemBuilder(Material.IRON_AXE).setName("§bJouer au jeu").setUnbreakable(true);
                    ItemBuilder infos = new ItemBuilder(Material.REDSTONE).setName("§aVos informations");
                    ItemBuilder spec = new ItemBuilder(Material.NETHER_STAR).setName("§bMode spectateur");
                    ItemBuilder hub = new ItemBuilder(Material.BED).setName("§cRevenir au lobby");
                    player.getInventory().setItem(4, infos.toItemStack());
                    player.getInventory().setItem(0, jouer.toItemStack());
                    player.getInventory().setItem(8, hub.toItemStack());
                    player.getInventory().setItem(1, spec.toItemStack());
                    player.setGameMode(GameMode.SURVIVAL);
            }
        }
    }
