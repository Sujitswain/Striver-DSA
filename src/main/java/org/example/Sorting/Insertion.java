package org.example.Sorting;

import java.util.Arrays;

public class Insertion {

    public static void insertionSort1(int[] arr, int i) {
        int j=i-1;
        int val = arr[i];
        while(j>=0 && arr[j] > val) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = val;
    }
    private static void solution1(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {
            insertionSort1(arr, i);
        }
        System.out.println(Arrays.toString(arr));
    }
    private static int binarySearch(int[] arr, int val, int low, int high) {
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(arr[mid] >= val) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }
    private static void insertionSort2(int[] arr, int i) {
        int val = arr[i];
        int j = binarySearch(arr, val, 0, i-1);

        for(int k=i-1; k>=j; k--) {
            arr[k+1] = arr[k];
        }
        arr[j] = val;
    }
    private static void solution2(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            insertionSort2(arr, i);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void function(int[] arr) {
        // solution1(arr);
        solution2(arr);
    }
    public static void main(String[] args) {
        function(new int[] {13,46,24,52,20,9});
        function(new int[] {5,4,3,2,1});
    }
}
