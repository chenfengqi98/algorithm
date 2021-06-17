package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 728.自除数
 * @Author : chen qi
 * @Date: 2021-06-17 14:27
 */
public class SelfDividingNumbers {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing2(n)) ans.add(n);
        }
        return ans;
    }

    public static boolean selfDividing1(int n) {
        for (char c : String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }

    public static boolean selfDividing2(int n) {
        int val = n;
        while (val > 0) {
            if (val % 10 == 0) {
                return false;
            } else {
                if (n % (val % 10) != 0) {
                    return false;
                }
            }
            val /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }
}
