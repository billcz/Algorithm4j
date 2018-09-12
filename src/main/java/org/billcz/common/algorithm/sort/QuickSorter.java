package org.billcz.common.algorithm.sort;

import org.billcz.common.algorithm.util.Arrays;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/31
 */
public class QuickSorter extends AbstractSorter {
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

        int j = partition(values, lo, hi);

        sort(values, lo, j - 1);
        sort(values, j + 1, hi);
    }

    private static void sort(Object[] values, int lo, int hi, Comparator comparator) {
        if (lo >= hi) return;

        int j = partition(values, lo, hi, comparator);

        sort(values, lo, j - 1, comparator);
        sort(values, j + 1, hi, comparator);
    }

    private static int partition(Comparable[] values, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = values[lo];

        while (true) {
            while (less(values[++i], v)) {
                if (i == hi) break;
            }

            while (less(v, values[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exchange(values, i, j);
        }

        exchange(values, lo, j);

        return j;
    }

    private static int partition(Object[] values, int lo, int hi, Comparator comparator) {
        int i = lo;
        int j = hi + 1;
        Object v = values[lo];

        while (true) {
            while (less(values[++i], v, comparator)) {
                if (i == hi) break;
            }

            while (less(v, values[--j], comparator)) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exchange(values, i, j);
        }

        exchange(values, lo, j);

        return j;
    }
}
