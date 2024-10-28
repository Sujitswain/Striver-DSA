package org.example.Sorting;

/*
    Heap is a (CBT) complete Binary Tree
    (Every level is completely filled except
    the last level, and the level are filled from the left).
    that comes with a Heap Order Property;

    if index is starting from 0:
        parent = (i-1)/2;
        left = 2*i+1;
        right = 2*i+2;

     In heapify we just make a node to place in
     in its correct position
 */

import java.util.Arrays;

public class HeapSort {

    private static void heapify(int[] arr, int n, int i) {
        int parent = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l < n && arr[l] > arr[parent]) {
            parent = l;
        }

        if(r < n && arr[r] > arr[parent]) {
            parent = r;
        }

        if(parent != i) {
            int temp = arr[i];
            arr[i] = arr[parent];
            arr[parent] = temp;

            heapify(arr, n, parent);
        }
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        for(int i=(n/2)-1; i>=0; i--) {
            heapify(arr, n, i);
        }

        for(int i=n-1; i>0; i--) {
            // swap last element
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // heapify except eliminating the last
            heapify(arr, i, 0);
        }

    }

    public static void function(int[] arr) {
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        function(new int[] {1,24,1,6,4});
        function(new int[] {8,3,5,1,99,3});
    }
}
