package org.example.Sorting;

import java.util.Arrays;

public class CountSort {

    public static void function(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];

        int max = Arrays.stream(arr).max().orElse(0);
        int[] count = new int[max+1];

        for(int i=0; i<n; i++)
            count[arr[i]]++;
        System.out.println(Arrays.toString(count));

        for(int i=1; i<=max; i++)
            count[i] = count[i-1] + count[i];
        System.out.println(Arrays.toString(count));

        for(int i=n-1; i>=0; i--) {
            count[arr[i]]--;
            output[count[arr[i]]] = arr[i];
        }

        System.out.println(Arrays.toString(output));
    }

    public static void main(String[] args) {
        function(new int[] {2,1,4,5,3,2,1,3,5,6,2,7});
    }
}
