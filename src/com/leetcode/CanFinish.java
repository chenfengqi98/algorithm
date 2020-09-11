package com.leetcode;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author chen qi
 * @Date 2020-08-03 17:28
 * @Description: 207.课程表
 */
public class CanFinish {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        if (numCourses <= 1) {
//            return true;
//        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < prerequisites.length; i++) {
//            map.put(prerequisites[i][0], prerequisites[i][1]);
//        }
//        int index = -1;
//        for (int i = 0; i < numCourses; i++) {
//            if (!map.containsKey(i)) {
//                index = i;
//            }
//        }
//        if (index == -1) {
//            return false;
//        }
//        boolean flag = true;
//        int count = 0;
//        while (flag) {
//            if (map.containsValue(index)) {
//                for (Integer key : map.keySet()) {
//                    if (map.get(key) == index) {
//                        count++;
//                    }
//                }
//            } else {
//                flag = false;
//            }
//        }
//        return count == map.size();
        return false;
    }

    public static void main(String[] args) {
        int num = 3;
        int[][] prerequisites = {{1, 0}, {2, 1}, {2, 0}};
        System.out.println(canFinish(num, prerequisites));
    }
}
