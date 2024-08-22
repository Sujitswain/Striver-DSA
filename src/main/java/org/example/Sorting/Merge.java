package org.example.Sorting;

import java.util.Arrays;

public class Merge {

    private static void merge(int[] arr, int l, int m, int r) {
        int i=l, j=m+1, k=0;
        int[] temp = new int[r-l+1];

        while(i<=m && j<=r) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<=m) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while(j<=r) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for(i=l; i<r; i++) {
            arr[i] = temp[i-l];
        }

    }

    public static void divideConqueror(int[] arr, int l, int r) {
        if(l < r) {
            int m = l+(r-l)/2;
            divideConqueror(arr, l, m);
            divideConqueror(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void function(int[] arr) {
        divideConqueror(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        function(new int[] {4,2,1,6,7});
        function(new int[] {3,2,8,5,1,4,23});
    }
}
