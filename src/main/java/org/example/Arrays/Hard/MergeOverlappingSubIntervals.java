package org.example.Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        function(new int[][] {{1,6}, {15,18}, {8,10}});
    }

    private static void function(int[][] arr) {
        int n = arr.length;

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr, (a, b) -> a[0]-b[0]);

        int start = arr[0][0];
        int end = arr[0][1];

        for(int i=1; i<n; i++) {
            if(end >= arr[i][0]) {
                end = Math.max(end, arr[i][1]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(start);
                l.add(end);
                res.add(l);

                start = arr[i][0];
                end = arr[i][1];
            }
        }
        List<Integer> l = new ArrayList<>();
        l.add(start);
        l.add(end);
        res.add(l);
        for(List<Integer> i : res)
            System.out.println(i);
    }
}
