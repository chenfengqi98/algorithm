package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 78.子集
 * @Author : chen qi
 * @Date: 2020-09-10 16:09
 */
public class SubSet {

    public List<List<Integer>> subSet(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        dfs(res, nums, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> list, int index) {
        // 1. terminator
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 2.process
        // 2.1. not pick the number
        dfs(res, nums, list, index + 1);
        // 2.2 pick the number
        list.add(nums[index]);
        dfs(res, nums, list, index + 1);
        // restore state
        list.remove(list.size() - 1);
    }

    /**
    * @description 迭代法，先在res中添加空数组，遍历res，在res中已经存在的结果里面加入num[i]
    * @author chen qi 
    * @date 2020/9/10 16:52
    */
    public List<List<Integer>> subSet1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        res.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSet = new ArrayList<>();
            for (List<Integer> re : res) {
                ArrayList<Integer> newSubSet = new ArrayList<>(re);
                newSubSet.add(num);
                newSet.add(newSubSet);
            }
            res.addAll(newSet);
        }
        return res;
    }

    public static void main(String[] args) {
        SubSet subSet = new SubSet();
        System.out.println(subSet.subSet(new int[]{1, 2, 3}));
        System.out.println(subSet.subSet1(new int[]{1, 2, 3}));
    }
}
