package org.billcz.common.sort;

import org.billcz.common.algorithm.sort.*;

import java.util.Random;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/30
 */
public class SortCompare {
    private static Integer[] getRandomValues(int length) {
        Integer[] values = new Integer[length];
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < length; i++) {
            values[i] = random.nextInt(length);
        }
        return values;
    }

    private static void SortCompare(Integer[] values, int round, String sortName) {
        Integer[] values1 = new Integer[values.length];
        System.arraycopy(values, 0, values1, 0, values.length);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < round; i++) {
            if (sortName.equals("BubbleSorter"))
                BubbleSorter.sort(values1);
            else if (sortName.equals("SelectionSorter"))
                SelectionSorter.sort(values1);
            else if (sortName.equals("InsertionSorter"))
                InsertionSorter.sort(values1);
            else if (sortName.equals("ShellSorter"))
                ShellSorter.sort(values1);
            else if (sortName.equals("MergeSorter"))
                MergeSorter.sort(values1);
            else if (sortName.equals("QuickSorter"))
                QuickSorter.sort(values1);
            else if (sortName.equals("Quick3WaySorter"))
                Quick3WaySorter.sort(values1);
        }

        System.out.println(sortName + " time cost: " + ((System.currentTimeMillis() - startTime) * 1.0f / round));
    }

    public static void main(String[] args) {
        int length = 100000;
        int round = 10;
        Integer[] values = getRandomValues(length);

//        SortCompare(values, round, "BubbleSorter");

//        SortCompare(values, round, "SelectionSorter");

        SortCompare(values, round, "InsertionSorter");

        SortCompare(values, round, "ShellSorter");

        SortCompare(values, round, "MergeSorter");

        SortCompare(values, round, "QuickSorter");

        SortCompare(values, round, "Quick3WaySorter");
    }
}
