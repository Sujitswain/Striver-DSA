package org.example.BinarySearch.BSonAnswers;

import java.util.Arrays;

public class BookAllocation {
    public static void main(String[] args) {
        function(new int[] {12, 34, 67, 90}, 2);
        function(new int[] {25, 46, 28, 49, 24}, 4);
    }
    private static void function(int[] arr, int s) {
        // bruteForce(arr, s);
        BS(arr, s);
    }
    private static void BS(int[] arr, int student) {
        int n = arr.length;

        if(student > n) {
            System.out.println("No Solution");
            return;
        }

        int s = Arrays.stream(arr).max().orElse(0);
        int e = Arrays.stream(arr).sum();

        while(s <= e) {
            int m = s+(e-s)/2;
            if(countStudents(arr, m, n) > student)
                s = m+1;
            else
                e = m-1;
        }
        System.out.println(s);
    }
    private static void bruteForce(int[] arr, int s) {
        int n = arr.length;

        if(s > n) {
            System.out.println("No Solution");
            return;
        }

        int start = Arrays.stream(arr).max().orElse(0);
        int end = Arrays.stream(arr).sum();
        for(int i=start; i<=end; i++) {
            if(countStudents(arr, i, n) == s) {
                System.out.println(i);
                return;
            }
        }
    }
    private static int countStudents(int[] arr, int page, int n) {
        int totolStudents = 1;
        int pagesPerStudent = 0;
        for(int i=0; i<n; i++) {
            if(pagesPerStudent + arr[i] <= page) {
                pagesPerStudent += arr[i];
            }
            else {
                totolStudents++;
                pagesPerStudent = arr[i];
            }
        }
        return totolStudents;
    }
}
