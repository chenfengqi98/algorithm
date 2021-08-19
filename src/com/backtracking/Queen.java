package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Queen {

    public List<List<String>> queens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(generateBoard(n), 0, res);
        return res;
    }

    void backtrack(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            res.add(boardFormat(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row + 1, res);
            board[row][col] = '.';
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        int length = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < length;
             i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public char[][] generateBoard(int n) {
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        return chars;
    }

    public List<String> boardFormat(char[][] board) {
        ArrayList<String> res = new ArrayList<>();
        for (char[] chars : board) {
            res.add(new String(chars));
        }
        return res;
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        List<List<String>> queens = queen.queens(8);
        for (List<String> strings : queens) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("---------");
        }
    }
}
