package com.bit.manipulation;

/**
 * @author chen
 * @date 2023/2/23
 */
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(8));
        System.out.println(hammingWeight(16));

        System.out.println(isPowerOfTwo(8));
    }

    private static int hammingWeight(int i) {
        int res = 0;
        while (i != 0) {
            i = i & (i - 1);
            res++;
        }
        return res;
    }

    private static boolean isPowerOfTwo(int i) {
        return (i & (i - 1)) == 0;
    }
}
