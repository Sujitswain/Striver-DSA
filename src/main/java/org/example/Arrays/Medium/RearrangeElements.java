package org.example.Arrays.Medium;

import java.util.Arrays;

public class RearrangeElements {
    public static void main(String[] args) {
        function(new int[] {3,1,-2,-5,2,-4});
        function(new int[] {-1,1});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int pos = 0;
        int neg = 1;
        for(int i=0; i<n; i++) {
            if(arr[i] > 0) {
                res[pos] = arr[i];
                pos += 2;
            }
            else {
                res[neg] = arr[i];
                neg += 2;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
