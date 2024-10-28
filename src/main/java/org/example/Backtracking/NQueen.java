package org.example.Backtracking;

import java.util.Arrays;

public class NQueen {
    public static void main(String[] args) {
        function(4);
    }
    private static void function(int n) {
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(arr[i], 0);
        }
        recursionSolution(arr, 0, n);
    }
    private static void recursionSolution(int[][] arr, int col, int n) {
        if(col == n) {
            System.out.println("=== SOLUTION ===");
            for(int a[] : arr) {
                System.out.println(Arrays.toString(a));
            }
            System.out.println();
            return;
        }

        for(int row=0; row<n; row++) {
            if(isSafe(arr, row, col)) {
                arr[row][col] = 1;
                recursionSolution(arr, col+1, n);
                arr[row][col] = 0;
            }
        }
    }
    private static boolean isSafe(int[][] arr, int row, int col) {
        int duprow = row;
        int dupcol = col;

        // forward left diagonal
        while (row >= 0 && col >= 0) {
            if (arr[row][col] == 1)
                return false;
            row--;
            col--;
        }

        // column
        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (arr[row][col] == 1)
                return false;
            col--;
        }

        // downward right diagonal
        row = duprow;
        col = dupcol;
        while (col >= 0 && row < arr.length) {
            if (arr[row][col] == 1)
                return false;
            col--;
            row++;
        }
        return true;
    }
}
