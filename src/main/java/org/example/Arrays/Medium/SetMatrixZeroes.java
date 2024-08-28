package org.example.Arrays.Medium;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        function(new int[][] {{1,1,1}, {1,0,1}, {1,1,1}});
        function(new int[][] {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}});
    }
    private static void function(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int[] row = new int[r];
        int[] col= new int[c];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(row[i] == 1 || col[j] == 1)
                    arr[i][j] = 0;
            }
        }

        for(int[] s : arr) {
            System.out.println(Arrays.toString(s));
        }
    }
}
