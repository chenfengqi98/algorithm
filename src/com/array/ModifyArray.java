package com.array;

import java.util.Arrays;

/**
 * leetcode 370.区间加法
 * 要差分数组的技巧，类似前缀和技巧构造的 prefix 数组，我们先对 nums 数组构造⼀个 diff 差
 * 分数组，diff[i] 就是 nums[i] 和 nums[i-1] 之差：
 *
 * @author chen
 * @date 2025/8/22
 */
public class ModifyArray {
    /**
     * 假设你有一个长度为n的数组，初始情况下所有的数字均为0，你将会被给出k个更新的操作。
     * 其中，每个操作会被表示为一个三元组:[startIndex,endlndex,inc]，你需要将子数组 A[startIndex...endIndex](包括 startindex和endIndex)增加 inc。
     * 请你返回 k 次操作后的数组。
     * 示例:
     * 输入:length=5，updates=[[1,3,2],[2,4,3],[0,2,-2]]输出:[-2,0,3,5,3]
     * 解释:
     * 初始状态:
     * [0,0,0,0,0]
     * 进行了操作[1,3,2]后的状态:
     * [0,2,2,2,0]
     * 进行了操作[2,4,3]后的状态:[0,2,5,5,3]
     * 进行了操作[0,2,-2]后的状态:[-2,0,3,5,3]
     */
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        Difference difference = new Difference(res);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int v = update[2];
            difference.increment(i, j, v);
        }
        return difference.getResult();
    }

    public static void main(String[] args) {
        int[] modifiedArray = getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
        System.out.printf("ModifiedArray: %s\n", Arrays.toString(modifiedArray));
    }
}
