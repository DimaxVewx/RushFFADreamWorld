package mc.dimax.rushffa.Kits;

import mc.dimax.rushffa.Utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class Joueur {
    public static void kitSend(Player player){
        // Items
        ItemBuilder sword = new ItemBuilder(Material.IRON_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 1).setUnbreakable(true);
        ItemBuilder tnt = new ItemBuilder(Material.TNT, 32);
        ItemBuilder briquet = new ItemBuilder(Material.FLINT_AND_STEEL).setUnbreakable(true);
        ItemBuilder sand1 = new ItemBuilder(Material.SANDSTONE, 64);
        ItemBuilder pioche = new ItemBuilder(Material.IRON_PICKAXE).setUnbreakable(true);
        ItemBuilder pommedorée = new ItemBuilder(Material.GOLDEN_APPLE, 8);
        ItemBuilder chaussure = new ItemBuilder(Material.LEATHER_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setUnbreakable(true);
        ItemBuilder pontalon = new ItemBuilder(Material.LEATHER_LEGGINGS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setUnbreakable(true);
        ItemBuilder tshirt = new ItemBuilder(Material.LEATHER_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setUnbreakable(true);
        ItemBuilder casque = new ItemBuilder(Material.LEATHER_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setUnbreakable(true);
        //        // Give
        player.getInventory().clear();
        player.getInventory().setBoots(chaussure.toItemStack());
        player.getInventory().setLeggings(pontalon.toItemStack());
        player.getInventory().setChestplate(tshirt.toItemStack());
        player.getInventory().setHelmet(casque.toItemStack());
        player.getInventory().setItem(0, sword.toItemStack());
        player.getInventory().setItem(1, tnt.toItemStack());
        player.getInventory().setItem(2, briquet.toItemStack());
        player.getInventory().setItemInOffHand(sand1.toItemStack());
        player.getInventory().setItem(7, pioche.toItemStack());
        player.getInventory().setItem(8, pommedorée.toItemStack());
        player.updateInventory();
    }
}
