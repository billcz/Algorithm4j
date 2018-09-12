package org.billcz.common.sort;

import org.billcz.common.algorithm.sort.BubbleSorter;

import java.util.Random;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/29
 */
public class BubbleSortorTest {
    public static void main(String[] args) {
        int length = 100;
        Integer[] values = new Integer[length];
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < length; i++) {
            values[i] = random.nextInt(length);
        }

        BubbleSorter.sort(values);

        for (int i = 0; i < length; i++) {
            System.out.println(values[i]);
        }
    }
}
