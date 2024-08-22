package org.example.Sorting;

import java.util.Arrays;

public class Bubble {

    public static void function(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++) {
            boolean swap = false;
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(swap == false)
                break;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        function(new int[] {13,46,24,52,20,9});
        function(new int[] {5,4,3,2,1});
    }
}
