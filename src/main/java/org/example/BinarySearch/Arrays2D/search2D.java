package org.example.BinarySearch.Arrays2D;

/*
You are given an m x n integer matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
*/

public class search2D {
    public static void main(String[] args) {
        function(new int[][] {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        }, 3);
        function(new int[][] {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        }, 13);
    }
    private static void function(int[][] arr, int t) {
        // optimalSolution1(arr, t);
        Assume1DPureBS(arr, t);
    }
    private static void Assume1DPureBS(int[][] arr, int t) {
        int row = arr.length;
        int col = arr[0].length;

        int s = 0;
        int e = row * col;

        while(s <= e) {
            int m = s+(e-s)/2;
            int cr = m/col;
            int cc = m%col;
            if(arr[cr][cc] == t) {
                System.out.println("Fount at: " + cr+" "+cc);
                return;
            }
            else if(arr[cr][cc] > t) {
                e=m-1;
            }
            else {
                s=m+1;
            }
        }
        System.out.println("Not found");
    }
    private static void optimalSolution1(int[][] arr, int t) {
        int row = arr.length;
        int col = arr[0].length;

        for(int i=0; i<row; i++) {
            if(arr[i][0] <= t && arr[i][col-1] >= t) {
                int val = searchBS(arr[i], col, t);
                System.out.println(i + " : " + val);
                return;
            }
        }
        System.out.println("Element not found");
    }

    private static int searchBS(int[] arr, int n, int t) {
        int s = 0;
        int e = n-1;

        while(s <= e) {
            int m = s+(e-s)/2;
            if(arr[m] == t)
                return m;
            else if(arr[m] > t)
                e=m-1;
            else
                s=m+1;
        }
        return -1;
    }
}
