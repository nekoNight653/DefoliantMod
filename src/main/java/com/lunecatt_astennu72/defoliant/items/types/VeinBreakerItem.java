package com.lunecatt_astennu72.defoliant.items.types;

import com.lunecatt_astennu72.defoliant.util.ModMath;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class VeinBreakerItem extends Item {
    //This makes items that vein mine blocks
    //The logic for which blocks it mines is in the isValidBlock boolean
    //The reach of the vein mine is declared by the int size
    private final int size;
    public VeinBreakerItem(Properties properties, int size) {
        super(properties);
        this.size = size;
    }
    //The logic for which blocks it chooses goes in here
    protected abstract boolean isValidBlock(Block block);

    //If the item breaks a valid block, and it's server world this is called
    //It will then find if there are any instances of the valid blocks around it and recurse for each of them
    //It uses the first blockPos for recursing. And uses the second one, so it knows where it originated
    //It tests if it's too far away from the starting position and stops if it is
    protected void veinBreak(World world, BlockPos pos, BlockPos origin){
        //Note BlockPos.betweenClosed requires the smaller numbers first, or it breaks
        Iterable<BlockPos> blocks = BlockPos.betweenClosed(
                pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1,
                pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
        ModMath modMath = new ModMath();
        //Just recurses and breaks the block if any of the surrounding blocks are a valid block and close enough
        for(BlockPos blockPos : blocks){
            if(isValidBlock(world.getBlockState(blockPos).getBlock()) && modMath.getBlockDist(origin, blockPos) <= size){
                world.destroyBlock(blockPos, true);
                veinBreak(world, blockPos, origin);
            }
        }
    }

    //This triggers whenever a block is mined, so we will call our veinBreak method whenever this triggers
    //Doesn't trigger if you're in creative.. not sure how to fix it or if it matters that much
    @Override
    public boolean mineBlock(ItemStack itemStack, World world, BlockState blockState, BlockPos pos, LivingEntity entity) {
        //I think this only triggers on server but still
        if(!world.isClientSide && isValidBlock(blockState.getBlock())){
            //It takes two block positions because the right one will be kept as the original blockPos it was called for
            //since it stops if it gets too far from the origin
            veinBreak(world, pos, pos);
        }

        return super.mineBlock(itemStack, world, blockState, pos, entity);
    }
}
