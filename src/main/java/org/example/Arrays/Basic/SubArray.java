package org.example.Arrays.Basic;

import java.util.ArrayList;

public class SubArray {
    public static void main(String[] args) {
        function(new int[] {1,2,3});
    }
    private static void function(int[] arr) {
        bruteForce(arr);
    }
    private static void bruteForce(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                for(int k=i; k<=j; k++)
                    System.out.print(arr[k] + " ");
                System.out.println();
            }
        }
    }
}
