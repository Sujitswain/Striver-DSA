package org.example.Arrays.Easy;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        function(new int[] {1,2,3,4,5,6,7}, 3);
        function(new int[] {-1,-100,3,99}, 2);
    }
    private static void function(int[] arr, int k) {
        int n = arr.length;
        reverse(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0, k-1);
        System.out.println(Arrays.toString(arr));
        reverse(arr, k, n-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void reverse(int[] arr, int s, int e) {
        for(int i=s, j=e; i<j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
