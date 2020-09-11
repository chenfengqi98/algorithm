package com.leetcode;

import java.util.Stack;

/**
 * @Description : 84.柱状图最大矩形
 * @Author : chen qi
 * @Date: 2020-08-26 18:52
 */
public class LargestRectangleArea {
    // 找左边界和右边界
    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i, right = i;
            while (left > 0) {
                if (heights[left] >= heights[i]) {
                    left--;
                } else {
                    break;
                }
            }
            while (right < heights.length) {
                if (heights[right] >= heights[i]) {
                    right++;
                } else {
                    break;
                }
            }
            if (left == i || right == i) {
                System.out.println((right - left) * heights[i]);
                max = Math.max(max, (right - left) * heights[i]);
            } else {
                System.out.println((right - left - 1) * heights[i]);
                max = Math.max(max, (right - left - 1) * heights[i]);
            }
//            while (left - 1 >= 0 && heights[left - 1] >= heights[i]) {
//                --left;
//            }
//            while (right + 1 < heights.length && heights[right + 1] >= heights[i]) {
//                ++right;
//            }
//            System.out.println((right - left + 1) * heights[i]);
//            max = Math.max(max, (right - left + 1) * heights[i]);
        }
        return max;
    }

    public static int largestRectangleArea2(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, (stack.pop() - i - 1) * heights[i]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {

        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}
