package org.example.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static void main(String[] args) {
        function(new int[] {2, 3, 6, 7, 1}, 7);
    }
    private static void function(int[] arr, int t) {
        recursionSolution(arr, 0, 0, t, new ArrayList<>());
    }
    private static void recursionSolution(int[] arr, int index, int sum, int t, List<Integer> l) {
        if(index >= arr.length) {
            if (sum == t)
                System.out.println(l);
            return;
        }

        if(sum <= t) {
            l.add(arr[index]);
            recursionSolution(arr, index, sum+arr[index], t, l);
            l.remove(l.size()-1);
        }
        recursionSolution(arr, index+1, sum, t, l);
    }
}
