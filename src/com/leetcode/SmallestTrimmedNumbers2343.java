package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chen
 * @date 2023/8/15
 */
public class SmallestTrimmedNumbers2343 {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            res[i] = answer(nums, query[0], query[1]);
        }
        return res;
    }

    /**
     * @param nums 数字字符串
     * @param k    第 k 小
     * @param trim 剩余位数
     * @return trim 后 第 k 小的数字索引
     */
    public int answer(String[] nums, int k, int trim) {
        String[] trimNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            trimNums[i] =  nums[i].substring(nums[i].length() - trim);
        }
        // 返回排序后的原始索引
        Integer[] indexArray = new Integer[trimNums.length];
        // 初始化辅助数组
        for (int i = 0; i < indexArray.length; i++) {
            indexArray[i] = i;
        }
        Arrays.sort(indexArray, Comparator.comparing(a -> trimNums[a]));
        return indexArray[k - 1];
    }

    public static void main(String[] args) {
        SmallestTrimmedNumbers2343 solution = new SmallestTrimmedNumbers2343();
//        String[] nums = {"102", "473", "251", "814"};
//        int[][] queries = {{1, 1}, {2, 3}, {4, 2}, {1, 2}};

        //["24","37","96","04"]
//        String[] nums = {"24", "37", "96", "04"};
        // [[2,1],[2,2]]
//        int[][] queries = {{2, 1}, {2, 2}};

        //["64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"]
        //	[[9,4],[6,1],[3,8],[12,9],[11,4],[4,9],[2,7],[10,3],[13,1],[13,1],[6,1],[5,10]]
        String[] nums = {"64333639502", "65953866768", "17845691654", "87148775908", "58954177897", "70439926174", "48059986638", "47548857440", "18418180516", "06364956881", "01866627626", "36824890579", "14672385151", "71207752868"};
        int[][] queries = {{9, 4}, {6, 1}, {3, 8}, {12, 9}, {11, 4}, {4, 9}, {2, 7}, {10, 3}, {13, 1}, {13, 1}, {6, 1}, {5, 10}};
        System.out.println(Arrays.toString(solution.smallestTrimmedNumbers(nums, queries)));
    }

}
