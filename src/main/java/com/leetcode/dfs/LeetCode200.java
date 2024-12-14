package com.leetcode.dfs;

public class LeetCode200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        //行
        int row = grid.length;
        //列
        int column = grid[0].length;

        int isLands = 0;
        for (int r =0; r< row; ++ r) {
            for (int c =0; c< column; ++c) {
                if (grid[r][c] == '1') {
                    //如果数值是1,就进行深度优先搜索，并将1标记为0，表示已经遍历过了 。
                    //上下左右都遍历，如果是为1，同样标记为0.
                    isLands++;
                    dfs( grid, r, c);
                }
            }
        }

        return isLands;
    }


    /**
     深度优先搜索(dfs)。
     进行深度优先搜索，并将1标记为0，表示已经遍历过了 。
     上下左右都遍历，如果是为1，同样标记为0.

     */
    void dfs (char[][] grid, int r, int c) {
        int row = grid.length;
        int column = grid[0].length;

        if (r < 0 || c < 0 || r >= row || c >= column || grid[r][c] == '0') {
            return;
        }

        //标记为 0，表示已经遍历过了 。
        grid[r][c] = '0';

        //当前坐标的上一行
        dfs(grid, r-1, c);
        //当前坐标的下一行
        dfs(grid, r+1, c);
        //当前坐标的左一列
        dfs(grid, r, c-1);
        //当前坐标的右一列
        dfs(grid, r, c+1);

    }


}
