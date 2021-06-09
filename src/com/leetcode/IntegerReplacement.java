package com.leetcode;

/**
 * @Description : 397 整数替换
 * @Author : chen qi
 * @Date: 2021-06-09 09:49
 */
public class IntegerReplacement {
    /**
     * 1.偶数，无符号右移
     * 2.奇数，加一或减一后二进制中1的个数最少
     * 101111 -- > (110000 || 101110)
     *
     * @param n
     * @return
     */
    public static int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            //
            if ((n & 1) == 0) {
                n = n >>> 1;
                count++;
            } else {
                //识别奇数的上一位是否为1，即 以 10 结尾(xxxx01)还是以11结尾(xxxx11)
                //
                if ((n & 2) == 0) {
                    //  1100001 -> 1100010
                    n -= 1;
                    count++;
                } else {
                    //11结尾除3这个特殊情况外，其余选用 n + 1取代 n
                    if (n == 3) {
                        // 11
                        count += 2;
                        break;
                    }
                    // 1100011 -> 1100100
                    n += 1;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(4));
    }
}
