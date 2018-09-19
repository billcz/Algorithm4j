package org.billcz.common.algorithm.sort;

import org.billcz.common.algorithm.util.Arrays;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/17
 */
public class Quick3WaySorter extends AbstractSorter {
    public static void sort(Comparable[] values) {
        Arrays.shuffle(values);
        sort(values, 0, values.length - 1);
    }

    public static void sort(Object[] values, Comparator comparator) {
        Arrays.shuffle(values);
        sort(values, 0, values.length - 1, comparator);
    }


    private static void sort(Comparable[] values, int lo, int hi) {
        if (lo >= hi) return;

        int lt = lo;
        int gt = hi;
        Comparable v = values[lo];
        int i = lo + 1;

        while (i <= gt) {
            int cmp = values[i].compareTo(v);
            if (cmp < 0) {
                exchange(values, lt++, i++);
            } else if (cmp > 0) {
                exchange(values, i, gt--);
            } else {
                i++;
            }
        }

        sort(values, lo, lt - 1);
        sort(values, gt + 1, hi);
    }



    private static void sort(Object[] values, int lo, int hi, Comparator comparator) {
        if (lo >= hi) return;

        int lt = lo;
        int gt = hi;
        Object v = values[lo];
        int i = lo + 1;

        while (i <= gt) {
            int cmp = comparator.compare(values[i], v);
            if (cmp < 0) {
                exchange(values, lt++, i++);
            } else if (cmp > 0) {
                exchange(values, i, gt--);
            } else {
                i++;
            }
        }

        sort(values, lo, lt - 1, comparator);
        sort(values, gt + 1, hi, comparator);
    }

}
