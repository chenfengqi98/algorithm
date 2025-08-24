package com.binary.search;

/**
 * 1011. 在 D 天内送达包裹的能力
 * <p>
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], days = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 *
 * @author chen
 * @description leetcode 1011. 在 D 天内送达包裹的能力
 * @date 2025/8/24
 */
public class ShipWithinDays {
    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }
        if (days == 1) {
            return right;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(weights, days, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean canShip(int[] weights, int days, int cap) {
        int day = 0;
        int cur = 0;
        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];
            if (weight > cap) {
                return false;
            }
            if (cur + weight > cap) {
                day++;
                cur = weight;
            } else {
                cur += weight;
            }
            if (i == weights.length - 1) {
                day++;
            }
        }
        return day <= days;
    }

    static boolean check(int[] weights, int cap, int days) {
        int n = weights.length;
        int day = 1;
        for (int i = 1, sum = weights[0]; i < n; sum = 0, day++) {
            while (i < n && sum + weights[i] <= cap) {
                sum += weights[i];
                i++;
            }
        }
        return day - 1 <= days;
    }


    public static void main(String[] args) {
//        System.out.println(canShip(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1, 15));
//        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2));
//        System.out.println(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
//        System.out.println(canShip(new int[]{1, 2, 3, 1, 1}, 4, 2));
//        System.out.println(shipWithinDays(new int[]{147, 73, 265, 305, 191, 152, 192, 293, 309, 292, 182, 157, 381, 287, 73, 162, 313, 366, 346, 47}, 10));
        System.out.println(canShip(new int[]{
                147, 73, 265,
                305, 191,
                152, 192,
                293,
                309,
                292, 182,
                157, 381,
                287, 73, 162,
                313,
                366,
                346, 47}, 10, 602));
    }
}
