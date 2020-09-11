package com.leetcode;

/**
 * @author chenqi
 * @date 2020-06-18 17:30
 * @Description 324.4的幂
 */
public class IsPowerOfFour {
    public static boolean isPowerOfFour(int num) {
        if (num == 1) {
            return true;
        }
        if(num > 0 && (num & (num -1)) != 0){
            return false;
        }
        while (num > 1) {
            num = num >> 2;
            if(num == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPowerOfFour2(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }

    public static void main(String[] args) {
        System.out.println(1 >> 4);
        System.out.println(isPowerOfFour(5));
    }
}
