package org.example.BinarySearch.Arrays2D;

public class RowMax1 {
    public static void main(String[] args) {
        function(new int[][] {
                {1,1,1},
                {0,0,1},
                {0,0,0}
        });
        function(new int[][] {
                {0,0},
                {0,0}
        });
    }
    private static void function(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        int max = 0, r = 0;
        for(int i=0; i<row; i++) {
            int val = col - findFirstOccurence(arr[i], arr.length, 1);
            if(val > max) {
                max = val;
                r = i+1;
            }
        }
        System.out.println(r + " : " + max);
    }
    private static int findFirstOccurence(int[] arr, int n, int t) {
        int s = 0;
        int e = n-1;
        int ans = n;                 // if no element is found n-n = 0
        while(s <= e) {
            int m = s+(e-s)/2;
            if(arr[m] >= t) {
                ans = m;
                e = m - 1;
            }
            else
                s = m + 1;
        }
        return ans;
    }
}
