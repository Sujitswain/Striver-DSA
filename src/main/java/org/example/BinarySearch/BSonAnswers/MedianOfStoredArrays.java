package org.example.BinarySearch.BSonAnswers;

import java.util.Arrays;

public class MedianOfStoredArrays {
    public static void main(String[] args) {
        function(new int[] {1,3,4,7,10,12}, new int[] {2,3,6,15});
        function(new int[] {2,3,4}, new int[] {1,3});
        function(new int[] {1,3}, new int[] {2});
        function(new int[] {1,2}, new int[] {3,4});
    }
    private static void function(int[] arr1, int[] arr2) {
        // UsingMergeSortWithSpace(arr1, arr1.length, arr2, arr2.length);
        // UsingMergeSortWithoutSpace(arr1, arr1.length, arr2, arr2.length);
        ApplyBinarySearch(arr1, arr2);
    }
    private static void ApplyBinarySearch(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length) {
            ApplyBinarySearch(arr2, arr1);
            return;
        }

        int n1 = arr1.length, n2 = arr2.length;
        int total = n1 + n2;
        int totalElementsOfLeft = (n1 + n2 + 1) / 2;

        int s = 0, e = n1;
        while(s <= e) {
            int m1 = s+(e-s)/2;
            int m2 = totalElementsOfLeft - m1;

            int l1 = m1 > 0 ? arr1[m1-1] : Integer.MIN_VALUE;
            int l2 = m2 > 0 ? arr2[m2-1] : Integer.MIN_VALUE;
            int r1 = m1 < n1 ? arr1[m1] : Integer.MAX_VALUE;
            int r2 = m2 < n2 ? arr2[m2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if((total & 1) == 1) {
                    System.out.println(Math.max(l1, l2));
                    return;
                }
                else {
                    double m = ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2;
                    System.out.println(m);
                    return;
                }
            }
            else if(l1 > r2)
                e = m1-1;
            else
                s = m1+1;
        }
    }
    private static void UsingMergeSortWithoutSpace(int[] arr1, int n1, int[] arr2, int n2) {

        int total = n1 + n2;
        int index2 = total/2, index1 = (total/2)-1;
        int el1 = -1, el2 = -1;

        int c = 0;
        int i=0, j=0;
        while(i<n1 && j<n2) {
            if(arr1[i] < arr2[j]) {
                if(c == index1)
                    el1 = arr1[i];
                if(c == index2)
                    el2 = arr1[i];
                i++;
            }
            else {
                if(c == index1)
                    el1 = arr2[j];
                if(c == index2)
                    el2 = arr2[j];
                j++;
            }
            c++;
        }

        while(i<n1) {
            if(c == index1)
                el1 = arr1[i];
            if(c == index2)
                el2 = arr1[i];
            c++;
            i++;
        }

        while(j<n2) {
            if(c == index1)
                el1 = arr2[j];
            if(c == index2)
                el2 = arr2[j];
            c++;
            j++;
        }

        if((total & 1) == 1)
            System.out.println(el2);
        else
            System.out.println((double)((double)(el1 + el2))/2);
    }
    private static void UsingMergeSortWithSpace(int[] arr1, int n1, int[] arr2, int n2) {
        int total = n1 + n2;
        int[] res = new int[total];

        int i=0, j=0, k=0;

        while(i<n1 && j<n2) {
            if(arr1[i] < arr2[j]) {
                res[k] = arr1[i];
                i++;
            }
            else {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i<n1) {
            res[k] = arr1[i];
            i++;
            k++;
        }

        while(j<n2) {
            res[k] = arr2[j];
            j++;
            k++;
        }

        System.out.println(Arrays.toString(res));
        if((total & 1) == 1)
            System.out.println(res[total/2]);
        else {
            int m = (res[(total/2)-1] + res[total/2]) / 2;
            System.out.println(m);
        }
    }
}
