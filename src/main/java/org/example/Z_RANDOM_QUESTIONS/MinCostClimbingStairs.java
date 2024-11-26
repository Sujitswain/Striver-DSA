package org.example.Z_RANDOM_QUESTIONS;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        function(new int[] {16, 19, 10, 12, 18});   // 31
        function(new int[] {2, 5, 3, 1, 7, 3, 4});  // 9
    }
    private static void function(int[] arr) {
        // Recursion
        // System.out.println(recursion(arr, arr.length));

        // DP memoization
        // int[] memo = new int[arr.length+1];
        // Arrays.fill(memo, -1);
        // System.out.println(dpMemoization(arr, arr.length, memo));

        // DP tabulation
        // System.out.println(dpTabulation(arr, arr.length));
    }
    private static int dpTabulation(int[] arr, int n) {
        int[] table = new int[n];

        table[0] = 0;
        table[1] = 0;

        for(int i=2;  i<=n; i++)
            table[i] = Math.min( (table[i-1] + arr[i-1]), (table[i-2] + arr[i-2]) );

        return table[n];
    }
    private static int dpMemoization(int[] arr, int n, int[] memo) {
        if(n <= 1)
            return 0;

        if(memo[n] != -1)
            return memo[n];

        int top = dpMemoization(arr, n-1, memo) + arr[n-1];
        int oneDown = dpMemoization(arr, n-2, memo) + arr[n-2];

        memo[n] = Math.min(top, oneDown);
        return memo[n];
    }
    private static int recursion(int[] arr, int n) {
        if(n <= 1)
            return 0;
        int top = recursion(arr, n-1) + arr[n-1];
        int oneDown = recursion(arr, n-2) + arr[n-2];

        return Math.min(top, oneDown);
    }
}
