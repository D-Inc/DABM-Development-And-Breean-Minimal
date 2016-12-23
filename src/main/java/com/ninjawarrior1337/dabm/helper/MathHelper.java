package com.ninjawarrior1337.dabm.helper;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

/**
 * Created by ninjawarrior1337 on 12/4/16.
 */
public class MathHelper
{
    public static int[] doubleArrayToIntArray(double[] doubles) {
        int[] ret = new int[doubles.length * 2];
        for (int i = 0; i < doubles.length; i++) {
            long l = Double.doubleToLongBits(doubles[i]);
            ret[i] = (int) (l >>> 32);
            ret[i + 1] = (int) l;
        }
        return ret;
    }

    public static int[] longArrayToIntArray(long[] longs) {
        int[] ret = new int[longs.length * 2];
        for (int i = 0; i < longs.length; i++) {
            ret[i] = (int) (longs[i] >>> 32);
            ret[i + 1] = (int) longs[i];
        }
        return ret;
    }

    public static long[] intArrayToLongArray(int[] ints) {
        long[] ret = new long[ints.length / 2];
        for (int i = 0; i < ints.length; i += 2) {
            ret[i / 2] = ((long) ints[i]) << 32 | ints[i + 1];
        }
        return ret;
    }

    public static double[] intArrayToDoubleArray(int[] ints) {
        double[] ret = new double[ints.length / 2];
        for (int i = 0; i < ints.length; i += 2) {
            long l = ((long) ints[i]) << 32 | ints[i + 1];
            ret[i / 2] = Double.longBitsToDouble(l);
        }
        return ret;
    }

    public static float pointDistanceSpace(BlockPos p1, BlockPos p2) {
        return pointDistanceSpace(p1.getX(), p1.getY(), p1.getZ(), p2.getX(), p2.getY(), p2.getZ());
    }

    public static float pointDistanceSpace(double x1, double y1, double z1, double x2, double y2, double z2) {
        return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
    }

    // Backwards compatibility
    public static float pointDistancePlane(double x1, double y1, double x2, double y2) {
        return VanillaPacketDispatcher.pointDistancePlane(x1, y1, x2, y2);
    }

    public static void setEntityMotionFromVector(Entity entity, Vector3 originalPosVector, float modifier) {
        Vector3 entityVector = Vector3.fromEntityCenter(entity);
        Vector3 finalVector = originalPosVector.subtract(entityVector);

        if(finalVector.mag() > 1)
            finalVector = finalVector.normalize();

        entity.motionX = finalVector.x * modifier;
        entity.motionY = finalVector.y * modifier;
        entity.motionZ = finalVector.z * modifier;
    }

    private static final String[] ORDINAL_SUFFIXES = new String[]{ "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
    public static String numberToOrdinal(int i) {
        return i % 100 == 11 || i % 100 == 12 || i % 100 == 13 ? i + "th" : i + ORDINAL_SUFFIXES[i % 10];
    }
}
