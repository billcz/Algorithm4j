package org.billcz.common.algorithm.sort;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/31
 */
public class MergeSorter extends AbstractSorter {
    public static void sort(Comparable[] values) {
        int length = values.length;
        Comparable[] temps = new Comparable[length];
        sort(values, temps, 0, length - 1);
    }

    public static void sort(Object[] values, Comparator comparator) {
        int length = values.length;
        Object[] temps = new Object[length];
        sort(values, temps, 0, length - 1, comparator);
    }

    private static void sort(Comparable[] values, Comparable[] temps, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;

        sort(values, temps, lo, mid);
        sort(values, temps, mid + 1, hi);

        merge(values, temps, lo, mid, hi);
    }

    private static void sort(Object[] values, Object[] temps, int lo, int hi, Comparator comparator) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;

        sort(values, temps, lo, mid, comparator);
        sort(values, temps, mid + 1, hi, comparator);

        merge(values, temps, lo, mid, hi, comparator);
    }

    private static void merge(Comparable[] values, Comparable[] temps, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        System.arraycopy(values, lo, temps, lo, hi + 1 - lo);

        for (int n = lo; n <= hi; n++) {
            if (i > mid) values[n] = temps[j++];
            else if (j > hi) values[n] = temps[i++];
            else if (less(temps[i], temps[j])) values[n] = temps[i++];
            else values[n] = temps[j++];
        }

    }

    private static void merge(Object[] values, Object[] temps, int lo, int mid, int hi, Comparator comparator) {
        int i = lo;
        int j = mid + 1;

        System.arraycopy(values, lo, temps, lo, hi + 1 - lo);

        for (int n = lo; n <= hi; n++) {
            if (i > mid) values[n] = temps[j++];
            else if (j > hi) values[n] = temps[i++];
            else if (less(temps[i], temps[j], comparator)) values[n] = temps[i++];
            else values[n] = temps[j++];
        }

    }
}
