package com.leetcode;

/**
 * @author chen
 * @date 2022/1/11 11:13 上午
 */
public class IntToHex_405 {
    private final static char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toHex(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < 8) {
            stringBuilder.append(map[num & 0xf]);
            num = num >> 4;
            if (num == 0) {
                break;
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(-1));
        System.out.println(toHex(26));
    }
}
