package org.example.Backtracking;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RatMaze {
    private static void function(int[][] arr) {
        if(arr[0][0] != 1 || arr[arr.length-1][arr[0].length-1] != 1) {
            System.out.println("Solution Not possible");
            return;
        }

        int[][] path = new int[arr.length][arr[0].length];
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, -1, 0, 1};

        for(int i=0; i<arr.length; i++) {
            Arrays.fill(path[i], 0);
        }

        recursionSolution(arr, arr.length, arr[0].length, x, y, 0, 0, path);
    }
    private static boolean isSafe(int[][] arr,
                                  int i, int j,
                                  int row, int col,
                                  int[][] path) {
        if(i < 0 || j < 0 || i >= row || j >= col ||
            path[i][j] == 1 || arr[i][j] == 0) {
            return false;
        }
        return true;
    }

    private static void recursionSolution(int[][] arr,
                                          int row, int col,
                                          int[] x, int[] y,
                                          int i, int j,
                                          int[][] path) {
        if(i == row-1 && j == col-1) {
            System.out.println(" === Solution === ");
            for(int k=0; k<row; k++) {
                System.out.println(Arrays.toString(path[k]));
            }
            System.out.println();
            return;
        }
        for(int d=0; d<x.length; d++) {
            if(isSafe(arr, i, j, row, col, path)) {
                path[i][j] = 1;
                recursionSolution(arr, row, col, x, y, i+x[d], j+y[d], path);
                path[i][j] = 0;
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
