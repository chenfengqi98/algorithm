package com.dfs;

/**
 * @Description : 200. 岛屿的数量
 * @Author : chen qi
 * @Date: 2021-10-18
 */
public class NumIslands {

    public static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    // 沉没相连的岛屿
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    /**
     * 从 (i, j) 开始，将与之相邻的陆地都变成海水
     *
     * @param grid
     * @param i
     * @param j
     */
    public static void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
