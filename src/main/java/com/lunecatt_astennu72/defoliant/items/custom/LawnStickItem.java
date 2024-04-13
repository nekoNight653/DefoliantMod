package com.lunecatt_astennu72.defoliant.items.custom;

import com.lunecatt_astennu72.defoliant.items.types.VeinBreakerItem;
import net.minecraft.block.*;

public class LawnStickItem extends VeinBreakerItem {
    public LawnStickItem(Properties properties, int size) {
        super(properties, size);
    }

    @Override
    protected boolean isValidBlock(Block block) {
        boolean isGrass = block instanceof TallGrassBlock || block instanceof DoublePlantBlock || block instanceof SeaGrassBlock;
        //Because TallFlowerBlock extends DoublePlantBlock
        boolean largeFlower = block instanceof TallFlowerBlock;
        return isGrass && !largeFlower;
    }
}
