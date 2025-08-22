package com.array;

/**
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips , trips[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * <p>
 * // 1 <= trips.length <= 1000
 * // trips[i].length == 3
 * // 1 <= numPassengersi <= 100
 * // 0 <= fromi < toi <= 1000
 * // 1 <= capacity <= 10⁵
 * 1094. 拼车
 *
 * @author chen
 * @date 2025/8/22
 */
public class CarPooling {
    /**
     * 你是一个开公交车的司机，公交车的最大载客量为 capacity，
     * 沿途要经过若干车站，给你一份乘客行程表int[][] trips，其中 trips[i]= [num，start，end]代表着有 num 个旅客要从站点start 上车到站点 end 下车，
     * 请你计算是否能够一次把所有旅客运送完毕(不能超过最大载客量 capacity)。
     *
     * @param trips
     * @param capacity
     * @return
     */
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference difference = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            // 上车
            int start = trip[1];
            // 下车，下车完同时可以下车，trip[2]-1
            int end = trip[2] - 1;
            difference.increment(start, end, val);
        }
        int[] result = difference.getResult();
        for (int i : result) {
            if (i > capacity) {
                return false;
            }
        }
        return true;
    }
}
