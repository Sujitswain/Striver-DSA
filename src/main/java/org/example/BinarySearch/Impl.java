package org.example.BinarySearch;

public class Impl {

    private static int recursion(int[] arr, int s, int e, int t) {
        if(s <= e) {
            int m = s+(e-s)/2;
            if(arr[m] == t)
                return m;
            else if(arr[m] > t) {
                return recursion(arr, s, m-1, t);
            }
            else {
                return recursion(arr, m+1, e, t);
            }
        }

        return -1;
    }

    public static void function(int[] arr, int t) {
        System.out.println("Present At: " + recursion(arr, 0, arr.length-1, t));
    }

    public static void main(String[] args) {
        function(new int[] {1,2,3,4,5}, 1);
        function(new int[] {56,67,78,90,120}, 120);
        function(new int[] {12,23,34,45,56,67,78}, 67);
        function(new int[] {12,23,34,45,56,67,78}, 79);
    }
}
