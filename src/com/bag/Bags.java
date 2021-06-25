package com.bag;

import java.util.Arrays;

/**
 * @Description : 动态规划-背包问题
 * @Author : chen qi
 * @Date: 2021-06-25 10:13
 */
public class Bags {
    public static void bags() {
        // 各个物品的重量
        int[] weights = new int[]{1, 3, 4};
        // //对应的价值
        int[] values = new int[]{15, 20, 30};
        // 背包大小
        int bagWeight = 4;
        // 二维数组：状态定义:dp[i][j]表示从0-i个物品中选择不超过j重量的物品的最大价值
        int[][] dp = new int[weights.length + 1][bagWeight + 1];

        // 初始化:第一列都是0，第一行表示只选取0号物品最大价值
        for (int j = bagWeight; j >= weights[0]; j--) {
            dp[0][j] = dp[0][j - weights[0]] + values[0];
        }

        for (int i = 1; i < weights.length; i++) { // 遍历物品(第0个物品已经初始化)
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weights[i]) {
                    // 背包放不下第i个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 背包能放下第i个物品
                    // 选择拿，或者不拿
                    // 拿：最大价值是前 i-1 个物品扣除第i个物品的重量的最大价值 加上i个物品的价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[weights.length - 1][bagWeight]);
    }

    public static void main(String[] args) {
        bags();
    }
}
