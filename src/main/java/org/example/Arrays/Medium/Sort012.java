package org.example.Arrays.Medium;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        function(new int[] {1,2,0,0,1,1,2,0});
        function(new int[] {0,1,2,1,2,1,0,0});
        function(new int[] {1,1,1,1,1,2,2,2,2,0,0,0});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        int s = 0, m = 0, e = n-1;

        while(m <= e) {
            if(arr[m] == 0) {
                swap(arr, s, m);
                s++;
                m++;
            }
            else if(arr[m] == 1) {
                m++;
            }
            else {
                swap(arr, m, e);
                e--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
