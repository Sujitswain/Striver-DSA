package org.example.Arrays.Medium;

import java.util.Arrays;

public class rotateMatrixBy90 {
    public static void main(String[] args) {
        function(new int[][] {{1,2,3},
                              {4,5,6},
                              {7,8,9}});
        function(new int[][] {{5,1,9,11},
                              {2,4,8,10},
                              {13,3,6,7},
                              {15,14,12,16}});
    }
    private static void function(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        // first transpose
        for(int i=0; i<row; i++) {
            for(int j=i+1; j<col; j++) {
                swap(arr, i, j);
            }
        }

        // swap from first and last
        for (int i = 0; i < row; i++) {
            int left = 0, right = row - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }

        for(int[] i: arr) {
            System.out.println(Arrays.toString(i));
        }
    }
    private static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
}
