package org.example.Backtracking;

import java.util.Arrays;

public class RatMaze2 {
    private static void function(int[][] arr) {
        if(arr[0][0] != 1 || arr[arr.length-1][arr[0].length-1] != 1) {
            System.out.println("Solution Not possible");
            return;
        }

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, -1, 0, 1};
        char[] p = {'U', 'L', 'D', 'R'};

        recursionSolution(arr, arr.length, arr[0].length, x, y, p, 0, 0, "");
    }
    private static boolean isSafe(int[][] arr,
                                  int i, int j,
                                  int row, int col) {
        if(i < 0 || j < 0 || i >= row || j >= col ||
                arr[i][j] == 0) {
            return false;
        }
        return true;
    }
    private static void recursionSolution(int[][] arr,
                                          int row, int col,
                                          int[] x, int[] y,
                                          char[] p,
                                          int i, int j, String str) {
        if(i == row-1 && j == col-1) {
            System.out.println(str);
            return;
        }
        for(int d=0; d<4; d++) {
           if(isSafe(arr, i, j, row, col)) {
               arr[i][j] = 0;
               recursionSolution(arr, row, col, x, y, p, i+x[d], j+y[d], str+p[d]);
               arr[i][j] = 1;
           }
        }
    }
    public static void main(String[] args) {
        function(new int[][] {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        });
    }
}
