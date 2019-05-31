package mc.dimax.rushffa.Utils;

import java.util.Arrays;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

    private ItemStack is;

    public ItemBuilder(Material m) {
        this(m, 1);
    }

    public ItemBuilder(ItemStack is) {
        this.is = is;
    }

    public ItemBuilder(Material m, int amount) {
        is = new ItemStack(m, amount);
    }

    public ItemBuilder(Material m, int amount, short meta){
        is = new ItemStack(m, amount, meta);
    }

    public ItemBuilder clone() {
        return new ItemBuilder(is);
    }

    /**
     * Set a durability on an ItemBuilder
     * @param dur
     * @return
     */

    public ItemBuilder setDurability(short dur) {
        is.setDurability(dur);
        return this;
    }

    /**
     * Set a name on the Item
     * @param name
     * @return
     */

    public ItemBuilder setName(String name) {
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);
        return this;
    }

    /**
     * Add an unsafe enchantment
     * @param ench
     * @param level
     * @return
     */

    public ItemBuilder addUnsafeEnchantment(Enchantment ench, int level) {
        is.addUnsafeEnchantment(ench, level);
        return this;
    }

    /**
     * Remove an enchantment
     * @param ench
     * @return
     */

    public ItemBuilder removeEnchantment(Enchantment ench) {
        is.removeEnchantment(ench);
        return this;
    }

    /**
     * Set a Player's Skull Name if you using a Skull
     * @param owner
     * @return
     */

    public ItemBuilder setSkullOwner(String owner) {
        try {
            SkullMeta im = (SkullMeta) is.getItemMeta();
            im.setOwner(owner);
            is.setItemMeta(im);
        } catch (ClassCastException expected) {
        }
        return this;
    }

    /**
     * Add an Enchantment
     * @param ench
     * @param level
     * @return
     */

    public ItemBuilder addEnchantment(Enchantment ench, int level) {
        ItemMeta im = is.getItemMeta();
        im.addEnchant(ench, level, true);
        is.setItemMeta(im);
        return this;
    }

    /**
     * Set unbreakable mode
     * @return
     */

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        ItemMeta im = is.getItemMeta();
        im.spigot().setUnbreakable(unbreakable);
        return this;
    }

    /**
     * Set a description on an ItemBuilder
     * @param lore
     *       Description
     * @return
     */

    public ItemBuilder setLore(String... lore) {
        ItemMeta im = is.getItemMeta();
        im.setLore(Arrays.asList(lore));
        is.setItemMeta(im);
        return this;
    }

    /**
     * Set a wool Color if you using Wool
     * @param color
     * @return
     */

    @SuppressWarnings("deprecation")
    public ItemBuilder setWoolColor(DyeColor color) {
        if (!is.getType().equals(Material.WOOL))
            return this;
        this.is.setDurability(color.getWoolData());
        return this;
    }

    /**
     * Set a Clay color if you using Clay
     * @param color
     * @return
     */

    @SuppressWarnings("deprecation")
    public ItemBuilder setClayColor(DyeColor color) {
        if (!is.getType().equals(Material.STAINED_CLAY))
            return this;
        this.is.setDurability(color.getDyeData());
        return this;
    }

    /**
     * Set a glass Color if you using a Glass
     * @param color
     * @return
     */

    @SuppressWarnings("deprecation")
    public ItemBuilder setGlassColor(DyeColor color) {
        if (!is.getType().equals(Material.STAINED_GLASS_PANE))
            return this;
        this.is.setDurability(color.getDyeData());
        return this;
    }

    /**
     * Set a color on a Carpet
     * @param color
     * @return
     */

    @SuppressWarnings("deprecation")
    public ItemBuilder setCarpetColor(DyeColor color) {
        if (!is.getType().equals(Material.CARPET))
            return this;
        this.is.setDurability(color.getDyeData());
        return this;
    }

    /**
     * Set a color on a leather armor
     * @param color
     * @return
     */

    public ItemBuilder setLeatherArmorColor(Color color) {
        try {
            LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
            im.setColor(color);
            is.setItemMeta(im);
        } catch (ClassCastException expected) {
        }
        return this;
    }

    /**
     * Convert the ItemBuilder to ItemStack for it can be compatible with Bukkit.
     * @return
     */

    public ItemStack toItemStack() {
        return is;
    }
}