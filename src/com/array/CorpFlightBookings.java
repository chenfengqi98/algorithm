package com.array;

import java.util.Arrays;

/**
 * leetcode 1109 航班预定统计
 *
 * @author chen
 * @date 2025/8/22
 */
public class CorpFlightBookings {
    /**
     * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
     * <p>
     * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
     * <p>
     * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
     * <p>
     * 示例 1：
     * <p>
     * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * 输出：[10,55,45,25,25]
     * 解释：
     * 航班编号        1   2   3   4   5
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       20  20
     * 预订记录 3 ：       25  25  25  25
     * 总座位数：      10  55  45  25  25
     * 因此，answer = [10,55,45,25,25]
     */

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n];
        Difference difference = new Difference(flights);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int seats = booking[2];
            difference.increment(i, j, seats);
        }
        return difference.getResult();
    }

    public static void main(String[] args) {
        int[] bookings = corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
        System.out.println(Arrays.toString(bookings));
    }
}
