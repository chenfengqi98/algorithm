package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description : 207. 课程表
 * tips 构造图，并判断有没有环
 * <p>
 * 207. 课程表II
 * 返回一个合理的上课顺序，保证开始修每个课程时，前置的课程都已经修完。
 * @Author : chen qi
 * @Date: 2021-09-07 17:10
 */
public class ClassSchedule {


    /**
     * 记录遍历过的路径，只用 path 会超时
     */
    boolean[] visited;

    /**
     * 记录当前traverse经过的路径
     */
    boolean[] onPath;

    boolean hasCycle;

    /**
     * @param graph
     * @param s
     */
    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            return;
        }
        // 将节点 s 标记为已遍历
        visited[s] = true;
        // 开始遍历节点 s
        onPath[s] = true;
        for (Integer v : graph[s]) {
            traverse(graph, v);
        }

        // 后序遍历位置
        postorder.add(s);

        // 节点 s 遍历完成
        onPath[s] = false;
    }

    /**
     * 构造图
     *
     * @param numCourses
     * @param prerequisites [0,1] 想学习课程0，需要先完成课程1
     */
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int form = edge[1];
            int to = edge[0];
            // form -> to
            // 修完课程 from 才能修课程 to
            graph[form].add(to);
        }

        return graph;
    }

    boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        // 不是所有节点都相连
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    public static void main(String[] args) {
        ClassSchedule classSchedule = new ClassSchedule();

//        boolean res = classSchedule.canFinish(3, new int[][]{{2, 1}, {1, 0}, {1, 2}});
//        System.out.println(res);

//        List<Integer> order = classSchedule.findOrder(3, new int[][]{{2, 1}, {1, 0}});
        List<Integer> order = classSchedule.findOrder(2, new int[][]{{1, 0}});
        System.out.println(order);
    }

    List<Integer> postorder = new ArrayList<>();

    List<Integer> findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        if (hasCycle) {
            return new ArrayList<>();
        }
        // 将后序遍历反转
        Collections.reverse(postorder);

        return postorder;
    }
}
