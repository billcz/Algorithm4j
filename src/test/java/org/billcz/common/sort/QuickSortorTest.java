package org.billcz.common.sort;

import org.billcz.common.algorithm.sort.MergeSorter;
import org.billcz.common.algorithm.sort.QuickSorter;

import java.util.Random;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/29
 */
public class QuickSortorTest {
    public static void main(String[] args) {
        int length = 10;
        Integer[] values = new Integer[length];
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < length; i++) {
            values[i] = random.nextInt(length);
        }

        QuickSorter.sort(values);

        for (int i = 0; i < length; i++) {
            System.out.println(values[i]);
        }
    }
}
