package com.lunecatt_astennu72.defoliant.init;

import com.lunecatt_astennu72.defoliant.Defoliant;
import com.lunecatt_astennu72.defoliant.items.custom.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Defoliant.MOD_ID);
    //Items
    public static final RegistryObject<Item> LAWN_STICK = ITEMS.register("lawn_stick", () ->
            new LawnStickItem(new Item.Properties().stacksTo(1).tab(Defoliant.TAB), 4));
    public static final RegistryObject<Item> TRUE_LAWN_STICK = ITEMS.register("true_lawn_stick", () ->
            new LawnStickItem(new Item.Properties().stacksTo(1).tab(Defoliant.TAB), 20));
    public static final RegistryObject<Item> LEAF_STICK = ITEMS.register("leaf_stick", () ->
            new LeafStickItem(new Item.Properties().stacksTo(1).tab(Defoliant.TAB), 4));
}
