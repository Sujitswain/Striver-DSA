package org.example.Arrays.Medium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        function(new int[] {1,2,7,8,6,5,4});
        function(new int[] {1,2,4,6,5});
        function(new int[] {1,2,3});
        function(new int[] {3,2,1});
        function(new int[] {1,1,5});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        int index = -1;
        for(int i=n-2; i>=0; i--) {
            if(arr[i] > arr[i+1])
                continue;

            index = i;
            break;
        }
        if(index == -1) {
            reverse(arr, 0, n);
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i=n-1; i>index; i--) {
            if(arr[i] > arr[index]) {
                swap(arr, i, index);
                break;
            }
        }
        reverse(arr, index+1, n);
        System.out.println(Arrays.toString(arr));
    }
    private static void reverse(int[] arr, int s, int e) {
        for(int i=s, j=e-1; i<j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
