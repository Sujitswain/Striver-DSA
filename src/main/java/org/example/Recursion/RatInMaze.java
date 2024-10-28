package org.example.Recursion;

import java.util.Arrays;

public class RatInMaze {
    private static void printPath(int[][] path) {
        for(int i=0; i<path.length; i++) {
            for(int j=0; j<path[0].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean isSafe(int[][] arr, int row, int col, int i, int j, int[][] path) {
        if(i < 0 || j < 0 ||
           i >= row || j >= col ||
           arr[i][j] != 1 || path[i][j] == 1) {
            return false;
        }

        return true;
    }
    private static void recursionSolution(int[][] arr, int row, int col, int i, int j, int[][] path) {
        if(i == row-1 && j == col-1) {
            path[i][j] = 1;
            printPath(path);
            path[i][j] = 0;

            System.out.println();

            return;
        }

        if(isSafe(arr, row, col, i, j, path)) {
            path[i][j] = 1;
            // up
            recursionSolution(arr, row, col, i-1, j, path);

            // left
            recursionSolution(arr, row, col, i, j-1, path);

            // down
            recursionSolution(arr, row, col, i+1, j, path);

            // right
            recursionSolution(arr, row, col, i, j+1, path);

            path[i][j] = 0;
        }
    }
    private static void function(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        if(arr[0][0] != 1 && arr[row-1][col-1] != 1) {
            System.out.println("Solution Does not Exist");
            return;
        }

        int[][] path = new int[row][col];
        for(int i=0; i<row; i++)
            Arrays.fill(path[i], 0);

        recursionSolution(arr, arr.length, arr[0].length, 0, 0, path);
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
