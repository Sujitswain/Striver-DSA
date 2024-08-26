package org.example.BinarySearch.Arrays1D;

public class IndexOfRotatedMatrix {
    public static int findIndex(int[] arr, int s, int e) {
        while(s < e) {
            int m = s+(e-s)/2;

            if(arr[m] > arr[e]) {
                s=m+1;
            }
            else {
                e=m;
            }
        }
        return s;
    }
    public static void function(int[] arr) {
        System.out.println(findIndex(arr, 0, arr.length-1));
    }
    public static void main(String[] args) {
        function(new int[] {1,2,3,4,5});        // 0
        function(new int[] {2,3,4,5,1});        // 4
        function(new int[] {3,4,5,1,2});        // 3
        function(new int[] {4,5,1,2,3});        // 2
        function(new int[] {5,1,2,3,4});        // 1

          // for descending order change the
          // comparison operator
//        function(new int[] {5,4,3,2,1});        // 4
//        function(new int[] {4,3,2,1,5});        // 3
//        function(new int[] {3,2,1,5,4});        // 2
//        function(new int[] {2,1,5,4,3});        // 1
//        function(new int[] {1,5,4,3,2});        // 0
    }
}
