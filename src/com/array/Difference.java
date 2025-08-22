package com.array;

/**
 * 差分数组
 * 适用场景是频繁对原始数组的某个区间进行元素增减
 *
 * @author chen
 * @date 2025/8/22
 */
public class Difference {

    private int[] diff;

    /**
     * 要差分数组的技巧，类似前缀和技巧构造的 prefix 数组，我们先对 nums 数组构造⼀个 diff 差
     * 分数组，diff[i] 就是 nums[i] 和 nums[i-1] 之差：
     *
     * @param nums
     */
    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public int[] getResult() {
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }

    /**
     * 数组 i-j 增加值
     * 回想 diff 数组反推 nums 数组的过程，diff[i] += 3 意味着给 nums[i..] 所有的元素都
     * 加了 3，然后 diff[j+1] -= 3 ⼜意味着对于 nums[j+1..] 所有元素再减 3，那综合起来，是不是就是对
     * nums[i..j] 中的所有元素都加 3 了？
     *
     * @param i
     * @param j
     * @param val
     */
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

}
