package com.lunecatt_astennu72.defoliant.util;

import net.minecraft.util.math.BlockPos;

public class ModMath {

    //Gets the Euclidean distance between 2 block positions
    //Works for 2D and 3D
    //Minecraft does have distance calculator, but it's a Manhattan distance calculator.
    //I at least haven't seen a Euclidean distance calculator in their code
    public double getBlockDist(BlockPos pos1, BlockPos pos2){

        //Just gets the absolute distance between the x, z, and y
        int length = Math.abs(Math.abs(pos1.getX()) - Math.abs(pos2.getX()));
        int width = Math.abs(Math.abs(pos1.getZ()) - Math.abs(pos2.getZ()));
        int height = Math.abs(Math.abs(pos1.getY()) - Math.abs(pos2.getY()));

        //This is just two Pythagorean theorems in 1 line or a 3D Pythagorean theorem whatever you call it.
        //Then of course it's Square rooted
        double distance = Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2) + Math.pow(height, 2));
        return distance;
    }
}
