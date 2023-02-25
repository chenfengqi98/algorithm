package com.bit.manipulation;

/**
 * @author chen
 * @date 2023/2/23
 */
public class BitManipulation {

    public static void main(String[] args) {
//        caseConversion();
//        swapArgs();
//        isDiffSign();
//        circleArr();
        delLastBit();
    }

    /**
     * 大小写转换
     */
    public static void caseConversion() {
        // 利用或操作`|`和空格将英文字符转换为小写
        int a = 'a';
        int space = ' ';
        System.out.println(a);
        System.out.println(space);
        System.out.println(a | space);
        System.out.println(('a' | ' ') == 'a');
        System.out.println(('A' | ' ') == 'a');

        // 利用与操作`&`和下划线将英文字符转换为大写
        System.out.println(('b' & '_') == 'B');
        System.out.println(('B' & '_') == 'B');

        // 利用异或操作`^`和空格将英文字符大小写转换
        System.out.println(('a' ^ ' ') == 'A');
        System.out.println(('A' ^ ' ') == 'a');
    }

    /**
     * 不使用临时变量
     */
    public static void swapArgs() {
        int a = 10, b = 20;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 判断两个数是否异号
     */
    public static void isDiffSign() {
        int a = 10, b = -20;
        System.out.println((a ^ b) < 0);
        System.out.println((-20 ^ -20) < 0);
    }

    /**
     * 循环遍历数组
     */
    public static void circleArr() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int idx = 0;
        while (idx < 20) {
            System.out.println(arr[idx % (arr.length)]);
            idx++;
        }
    }

    /**
     * 删除最后一位1
     */
    public static void delLastBit() {
        int a = 10;
        System.out.println(a & (a - 1));
    }

}
