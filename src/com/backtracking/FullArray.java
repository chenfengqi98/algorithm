package com.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class FullArray {
    public List<List<Integer>> fullArray(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new LinkedList<>(), res);
        return res;
    }

    public void helper(int[] nums, LinkedList<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new LinkedList<>(curr));
            return;
        }
        for (int num : nums) {
            if (curr.contains(num)) {
                continue;
            }
            curr.add(num);
            helper(nums, curr, res);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        FullArray fullArray = new FullArray();
        System.out.println(fullArray.fullArray(new int[]{1, 3, 4, 5}));
    }
}
