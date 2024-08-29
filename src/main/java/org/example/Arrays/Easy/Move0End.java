package org.example.Arrays.Easy;

import java.util.Arrays;

public class Move0End {
    public static void main(String[] args) {
        function(new int[] {0,1,0,3,12});
        function(new int[] {0});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        int j = 0;

        for(int i=0; i<n; i++) {
            if(arr[i] != 0) {
                arr[j] = arr[i];
                j++;

                if(i != j-1)
                    arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
