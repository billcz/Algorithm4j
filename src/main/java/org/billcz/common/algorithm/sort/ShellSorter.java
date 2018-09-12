package org.billcz.common.algorithm.sort;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/30
 */
public class ShellSorter extends AbstractSorter {

    public static void sort(Comparable[] values) {
        int length = values.length;

        int h = 1;
        while (h < length/3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < length; i+=h) {
                for (int j = i; j > 0 && less(values[j], values[j-h]); j-=h) {
                    exchange(values, j, j-h);
                }
            }
            h = h/3;
        }
    }

    public static void sort(Object[] values, Comparator comparator) {
        int length = values.length;

        int h = 1;
        while (h < length/3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < length; i+=h) {
                for (int j = i; j > 0 && less(values[j], values[j-h], comparator); j-=h) {
                    exchange(values, j, j-h);
                }
            }
            h = h/3;
        }
    }
}
