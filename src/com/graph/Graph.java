package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description : 图
 * @Author : chen qi
 * @Date: 2021-09-07 10:27
 */
public class Graph {

    /**
     * 访问记录
     */
    boolean[] visited;

    List<Integer> postorder = new ArrayList<>();

    void traverse(int[][] graph, int s) {
        if (visited[s]) return;
        visited[s] = true;
        for (int v : graph[s]) {
            traverse(graph, v);
        }
        postorder.add(s);
    }

    public static void main(String[] args) {
        // 邻接表
        int[][] ints = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        Graph graph = new Graph();
        graph.visited = new boolean[ints.length];
        graph.traverse(ints, 0);

        //后序遍历倒序=拓扑排序
        Collections.reverse(graph.postorder);
        System.out.println(graph.postorder);
    }

}
