package org.example.Sorting;

import java.util.Arrays;

public class Selection {
    public static int selectionSort(int arr[], int i, int n)
    {
        int pos = i;
        for(int j=i+1; j<n; j++) {
            if(arr[pos] > arr[j]) {
                pos = j;
            }
        }
        return pos;
    }

    public static void function(int arr[])
    {
        int n = arr.length;
        boolean swapped;
        for(int i=0; i<n-1; i++) {
            int pos = selectionSort(arr, i, n);
            if(pos != i) {
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        function(new int[] {1, 3, 9, 7});
        function(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
    }
}



//public class Selection {
//
//    public static void selectionSort(int arr[]) {
//        int n = arr.length;
//        boolean swapped;
//        for (int i = 0; i < n - 1; i++) {
//            int minIndex = i;
//            swapped = false;
//            for (int j = i + 1; j < n; j++) {
//                if (arr[j] < arr[minIndex]) {
//                    minIndex = j;
//                    swapped = true;
//                }
//            }
//            if (minIndex != i) {
//                int temp = arr[i];
//                arr[i] = arr[minIndex];
//                arr[minIndex] = temp;
//            }
//            if (!swapped) {
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//    }
//
//    public static void main(String[] args) {
//        selectionSort(new int[]{1, 3, 9, 7});
//        selectionSort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
//    }
//}
