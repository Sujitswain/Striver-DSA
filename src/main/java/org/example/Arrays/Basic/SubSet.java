package org.example.Arrays.Basic;

/*
* we know that if n elements are present
* then we will have 2^n subsets
*
* example if we have
* 2 = 4
* 3 = 8
* */

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        // function(new int[] {1,2});
        function(new int[] {1,2,3});
        // function(new int[] {1,2,3,4});
    }
    private static void function(int[] arr) {
        System.out.println("Iterative: ");
        bruteForce(arr);
//        System.out.println("Recursion: ");
//        System.out.println(new ArrayList<>());
//        recursion(arr, 0, arr.length, new ArrayList<>());
    }

    private static void recursion(int[] arr, int index, int n, ArrayList<Integer> res) {
        if(index == n) {
            return;
        }

        for(int i=index; i<n; i++) {
            res.add(arr[i]);
            System.out.println(res);
            recursion(arr, i+1, n, res);
            res.remove(res.size()-1);
        }
    }

    private static void bruteForce(int[] arr) {
        int n = arr.length;
        int totalsubsets = 1 << n;

        for(int i=0; i<totalsubsets; i++) {
            List<Integer> res = new ArrayList<>();
            for(int j=0; j<n; j++) {
                if((i & (1 << j)) != 0)
                    res.add(arr[j]);
            }
            System.out.println(res);
        }

    }
}
