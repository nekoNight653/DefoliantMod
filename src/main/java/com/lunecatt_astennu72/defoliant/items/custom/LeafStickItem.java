package com.lunecatt_astennu72.defoliant.items.custom;

import com.lunecatt_astennu72.defoliant.items.types.VeinBreakerItem;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;

public class LeafStickItem extends VeinBreakerItem {
    public LeafStickItem(Properties properties, int size) {
        super(properties, size);
    }

    @Override
    protected boolean isValidBlock(Block block) {
        //Leaves(:
        return block instanceof LeavesBlock;
    }
}
