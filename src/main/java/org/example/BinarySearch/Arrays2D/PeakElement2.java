package org.example.BinarySearch.Arrays2D;

import java.util.Arrays;

public class PeakElement2 {
    public static void main(String[] args) {
        function(new int[][] {
                {1, 4},
                {3, 2}
        });
        function(new int[][] {
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32}
        });
        function(new int[][] {
                {41,8,2,48,18},
                {16,15,9,7,44},
                {48,35,6,38,28},
                {3,2,14,15,33},
                {39,36,13,46,42}
        });
    }
    private static void function(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        int s = 0, e = col - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            int r = findMax(arr, row, m);

            int top = r > 0 ? arr[r - 1][m] : Integer.MIN_VALUE;
            int right = m < col - 1 ? arr[r][m + 1] : Integer.MIN_VALUE;
            int bottom = r < row - 1 ? arr[r + 1][m] : Integer.MIN_VALUE;
            int left = m > 0 ? arr[r][m - 1] : Integer.MIN_VALUE;

            if (arr[r][m] >= Math.max(Math.max(top, right), Math.max(bottom, left))) {
                System.out.println(arr[m][r]);
                return;
            } else if (arr[r][m] < left) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
    }

    private static int findMax(int[][] arr, int row, int m) {
        int max = arr[0][m];
        int maxRow = 0;
        for (int i = 1; i < row; i++) {
            if (arr[i][m] > max) {
                max = arr[i][m];
                maxRow = i;
            }
        }
        return maxRow;
    }
}

