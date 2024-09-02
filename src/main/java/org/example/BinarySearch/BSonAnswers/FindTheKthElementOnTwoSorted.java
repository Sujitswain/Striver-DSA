package org.example.BinarySearch.BSonAnswers;

public class FindTheKthElementOnTwoSorted {
    public static void main(String[] args) {
        function(new int[] {2,3,6,7,9}, new int[] {1,4,8,10}, 5);
        function(new int[] {100,112, 256,349,770}, new int[] {72,86,113,119,265,445,892}, 7);
    }
    private static void function(int[] arr1, int[] arr2, int k) {
        // UsingMergeWithSpace(arr1, arr2, k);
        // UsingMergeWithoutSpace(arr1, arr2, k);
        UsingMergeSort(arr1, arr2, k);
    }
    private static void UsingMergeSort(int[] arr1, int[] arr2, int k) {
        if(arr1.length > arr2.length) {
            UsingMergeSort(arr2, arr1, k);
            return;
        }

        int n1 = arr1.length;
        int n2 = arr2.length;

        int left = k;

        int s = Math.max(0, k-n1), e = Math.min(k, n2);
        while(s <= e) {
            int m1 = s+(e-s)/2;
            int m2 = left - m1;

            int l1 = m1 > 0 ? arr1[m1-1] : Integer.MIN_VALUE;
            int l2 = m2 > 0 ? arr2[m2-1] : Integer.MIN_VALUE;
            int r1 = m1 < n1 ? arr1[m1] : Integer.MAX_VALUE;
            int r2 = m2 < n2 ? arr2[m2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                System.out.println(Math.max(l1, l2));
                return;
            }
            else if(l1 > r2)
                e = m1-1;
            else
                s = m1+1;
        }
    }
    private static void UsingMergeWithoutSpace(int[] arr1, int[] arr2, int l) {
        int n1 = arr1.length, n2 = arr2.length;

        int i=0, j=0, k=0;
        int el = Integer.MIN_VALUE;

        while(i<n1 && j<n2) {
            if(arr1[i] < arr2[j]) {
                if(k == l-1) {
                    el = arr1[i];
                    break;
                }
                i++;
            }
            else {
                if(k == l-1) {
                    el = arr2[j];
                    break;
                }
                j++;
            }
            k++;
        }

        while(i<n1 && el == Integer.MIN_VALUE) {
            if(k == l-1) {
                el = arr1[i];
                break;
            }
            i++;
            k++;
        }

        while(j<n2 && el == Integer.MIN_VALUE) {
            if(k == l-1) {
                el = arr2[j];
                break;
            }
            j++;
            k++;
        }
        System.out.println(el);
    }
    private static void UsingMergeWithSpace(int[] arr1, int[] arr2, int l) {
        int n1 = arr1.length, n2 = arr2.length;
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

        System.out.println(res[l-1]);
    }
}
