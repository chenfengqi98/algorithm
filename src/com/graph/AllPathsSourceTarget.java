package com.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description : 797 所有可能路径
 * 输入一幅有向无环图，这个图包含n个节点，标号为0, 1, 2,..., n - 1，请你计算所有从节点0到节点n - 1的路径。
 * @Author : chen qi
 * @Date: 2021-09-07 16:54
 */
public class AllPathsSourceTarget {

    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> paths = new LinkedList<>();
        traverse(graph, 0, paths);
        return res;
    }

    void traverse(int[][] graph, int s, LinkedList<Integer> paths) {
        // 添加节点 s
        paths.addLast(s);

        if (s == graph.length - 1) {
            // 到达终点
            res.add(new LinkedList<>(paths));
            paths.removeLast();
            return;
        }

        for (int v : graph[s]) {
            traverse(graph, v, paths);
        }

        paths.removeLast();
    }

    public static void main(String[] args) {
        AllPathsSourceTarget allPathsSourceTarget = new AllPathsSourceTarget();
        /*
            0  ->  1
            |      |
            v      v
            2  ->  3
         */
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget.allPathsSourceTarget(graph));
    }
}
