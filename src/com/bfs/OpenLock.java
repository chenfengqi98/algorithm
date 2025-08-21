package com.bfs;

import java.util.*;

/**
 * @Description : 752.开锁
 * 密码锁，在处出现 deadEnds 下，解开锁的最小次数
 * @Author : chen qi
 * @Date: 2021-08-18 17:17
 */
public class OpenLock {

    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        String[] deadEnds = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock.openLock(deadEnds, "0202"));
        System.out.println(openLock.getNeighbors("0202"));
    }

    public int openLock(String[] deadEnds, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadEnds));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add("0000");
        queue.offer("0000");
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (deads.contains(curr)) continue;
                if (curr.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String plus = plus(curr, j);
                    if (!visited.contains(plus)) {
                        queue.offer(plus);
                        visited.add(plus);
                    }
                    String sub = sub(curr, j);
                    if (!visited.contains(sub)) {
                        queue.offer(sub);
                        visited.add(sub);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String plus(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9')
            chars[i] = '0';
        else
            chars[i] += 1;
        return new String(chars);
    }

    public String sub(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0')
            chars[i] = '9';
        else
            chars[i] -= 1;
        return new String(chars);
    }

    public int openLock2(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000")) return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) return step;
                for (String neighbor : getNeighbors(cur)) {
                    if (!visited.contains(neighbor) && !set.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public List<String> getNeighbors(String curr) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String plus = plus(curr, i);
            res.add(plus);
            String sub = sub(curr, i);
            res.add(sub);
        }
        return res;
    }


}
