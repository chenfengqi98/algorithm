package com.leetcode;

import java.io.IOException;
import java.util.HashSet;

/**
 * @author chenqi
 * @date 2020-06-01 16:52
 * @Descripion 202.快乐数
 */
public class IsHappy {
    /**
     * 由于会死循环，所以需要使用快慢指针的方式寻找是否成环
     *
     * @param num
     * @return
     */
    public static boolean isHappy(int num) {
        int slow = num, fast = squareSum(num);
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return slow == 1;
    }

    public static int squareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num = num / 10;
        }
        return sum;
    }

    /**
     * set判断重复
     *
     * @param num
     * @return
     */
    public static boolean isHappy2(int num) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            num = squareSum(num);
            if (num == 1) {
                return true;
            }
            if (!set.add(num)) {
                // 加入失败，有重复
                return false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(isHappy2(19));
        Integer s = 999999;
        System.out.println(String.format("%06d", s));
        System.in.read();
    }
}
