package org.example.Recursion;

import java.util.ArrayList;

public class subSets {
    public static void main(String[] args) {
        function(new int[] {1,2,3});
    }
    private static void function(int[] arr) {
        iterativeFunction(arr);
        recursiveFunction(arr, arr.length, new ArrayList<Integer>(), 0);
    }

    /**
     *      i        	Binary Representation	Subset
     * (Subset Index)
     *      0               000	                      []
     *      1	            001	                     [1]
     *      2	            010	                     [2]
     *      3	            011	                  [1, 2]
     *      4	            100	                     [3]
     *      5	            101	                  [1, 3]
     *      6	            110	                  [2, 3]
     *      7               111	               [1, 2, 3]
     */

    private static void iterativeFunction(int[] arr) {
        int n = arr.length;
        int totalSubset = 1<<n;                     // 2^n
        for(int i=0; i<totalSubset; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(i + " & " +(1<<j) + " = " +(i & (1<<j)) + ", ");
                if((i & (1<<j)) != 0)               // if 1 include
                    System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
    private static void recursiveFunction(int[] arr, int n, ArrayList<Integer> temp, int i) {
        if(i == n) {
            System.out.println(temp);
            return;
        }

        recursiveFunction(arr, n, temp, i+1);
        temp.add(arr[i]);

        recursiveFunction(arr, n, temp, i+1);
        temp.remove(temp.size()-1);
    }
}
