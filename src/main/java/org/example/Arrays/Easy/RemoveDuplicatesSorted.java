package org.example.Arrays.Easy;

import java.util.Arrays;

public class RemoveDuplicatesSorted {
    public static void main(String[] args) {
        function(new int[] {1,1,2});
        function(new int[] {0,0,1,1,1,2,2,3,3,4});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        int j = 1;
        for(int i=1; i<n; i++) {
            if(arr[i-1] != arr[i]) {
                arr[j] = arr[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
