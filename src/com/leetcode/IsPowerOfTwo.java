package com.leetcode;

/**
 * @author chenqi
 * @date 2020-06-01 16:32
 * @Descripion 231.2的幂
 */
public class IsPowerOfTwo {
    /**
     * 暴力解法，让power左移，如果最后溢出了，值就变成了Integer.MIN_VALUE
     *
     * @param num
     * @return
     */
    public static boolean isPowerOfTwo(int num) {
        int power = 1;
        while (power <= num) {
            if (power == num) {
                return true;
            }
            power = power << 1;
            if (power == Integer.MIN_VALUE) {
                break;
            }
        }
        return false;
    }

    /**
     * Integer.highestOneBit 方法可能还记得。可以实现保留最高位的 1 ，
     * 然后将其它位全部置为 0。即，把 0 0 0 1 X X X X 变成 0 0 0 1 0 0 0 0 。
     * @param num
     * @return
     */
    public static boolean isPowerOfTwo2(int num) {
        if(num == 0 || num == Integer.MIN_VALUE){
            return false;
        }
        return Integer.highestOneBit(num) == num;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1024));
        System.out.println(isPowerOfTwo2(1024));
    }
}
