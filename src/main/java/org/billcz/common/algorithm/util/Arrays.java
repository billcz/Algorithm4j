package org.billcz.common.algorithm.util;

import java.util.Random;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/12
 */
public class Arrays {
    public static void shuffle(Object[] values) {
        int length = values.length;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            int j = random.nextInt(length);
            exchange(values, i, j);
        }
    }
    public static void shuffle(int[] values) {
        int length = values.length;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            int j = random.nextInt(length);
            exchange(values, i, j);
        }
    }
    public static void shuffle(long[] values) {
        int length = values.length;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            int j = random.nextInt(length);
            exchange(values, i, j);
        }
    }
    public static void shuffle(float[] values) {
        int length = values.length;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            int j = random.nextInt(length);
            exchange(values, i, j);
        }
    }

    public static void shuffle(double[] values) {
        int length = values.length;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            int j = random.nextInt(length);
            exchange(values, i, j);
        }
    }

    private static void exchange(Object[] values, int i, int j) {
        Object swap = values[i];
        values[i] = values[j];
        values[j] = swap;
    }
    private static void exchange(int[] values, int i, int j) {
        int swap = values[i];
        values[i] = values[j];
        values[j] = swap;
    }
    private static void exchange(long[] values, int i, int j) {
        long swap = values[i];
        values[i] = values[j];
        values[j] = swap;
    }
    private static void exchange(float[] values, int i, int j) {
        float swap = values[i];
        values[i] = values[j];
        values[j] = swap;
    }
    private static void exchange(double[] values, int i, int j) {
        double swap = values[i];
        values[i] = values[j];
        values[j] = swap;
    }
}
