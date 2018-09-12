package org.billcz.common.util;

import org.billcz.common.algorithm.util.LinkedListStack;
import org.billcz.common.algorithm.util.Stack;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/23
 */
public class LinkedListStackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedListStack<Integer>();

        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("pop: " + i + "," + stack.pop());
        }

        for (Integer i : stack) {
            System.out.println("remain: " + i);
        }
        System.out.println("size: " + stack.size());
    }
}
