package org.example.Recursion;

import java.util.ArrayList;

public class Combination3 {
    public static void main(String[] args) {
        // function(3, 7);
        function(3, 9);
    }
    private static void function(int k, int n) {
        // recursion1(k, n, 1, new ArrayList<>());
        recursion2(k, n, 1, new ArrayList<>());
    }
    private static void recursion2(int k, int n, int start, ArrayList<Object> temp) {
        if(k == 0 && n== 0) {
            System.out.println(temp);
            return;
        }

        if(k < 0 || n < 0)
            return;

        // 10 because that the end point in question
        // suppose if we have array we would give arr.length
        for(int i=start; i<10; i++) {
            temp.add(i);
            recursion2(k-1, n-i, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
    private static void recursion1(int k, int target, int start, ArrayList<Object> temp) {
        if(k == 0 && target == 0) {
            System.out.println(temp);
            return;
        }

        if(k < 0 || target < 0 || start >= 10)
            return;

        temp.add(start);
        recursion1(k-1, target-start, start+1, temp);
        temp.remove(temp.size()-1);

        recursion1(k, target, start+1, temp);
    }
}
