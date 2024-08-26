package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        function(new int[] {140,54,534,6,62,201,400});
    }

    private static void function(int[] arr) {
        // 1
        // bubbleSort(arr, arr.length);
        // bubbleSortRecursion(arr, arr.length-1);

        // 2
        // insertionSort(arr, arr.length);
        // insertionSortRecursion(arr, arr.length-1);

        // 3
        // selectionSort(arr, arr.length);
        // selectionSortRecursion(arr, arr.length-1, 0);

        // 4
        // mergeSort(arr, 0, arr.length-1);

        // 5
        // pivotSort(arr, 0, arr.length-1);

        // 6
        // heapSort(arr, arr.length);

        // 7
        // countSort(arr, arr.length);

        // 8
        // radixSort(arr, arr.length);

        // 9
        shellSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr, int n) {
        for(int gap = n/2; gap>0; gap/=2) {
            for(int i=gap; i<n; i++) {
                int j=i;
                int val = arr[i];

                while(j>=gap && arr[j-gap] > val) {
                    arr[j] = arr[j-gap];
                    j-=gap;
                }
                arr[j] = val;
            }
        }
    }

    private static void countSortForRadix(int[] arr, int n, int e) {
        int[] output = new int[n];
        int[] count = new int[10];

        for(int i=0; i<n; i++)
            count[(arr[i]/e) % 10]++;

        for(int i=1; i<10; i++)
            count[i] += count[i-1];

        for(int i=n-1; i>=0; i--) {
            int index = (arr[i] / e) % 10;
            output[count[index]-1] = arr[i];
            count[index]--;
        }

        for(int i=0; i<n; i++)
            arr[i] = output[i];
    }

    private static void radixSort(int[] arr, int length) {
        int max = Arrays.stream(arr).max().orElse(0);

        for(int i=1; max/i > 0; i*=10) {
            countSortForRadix(arr, arr.length, i);
        }
    }

    private static void countSort(int[] arr, int n) {
        int[] output = new int[n];

        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(0);

        int[] count = new int[max-min+1];
        Arrays.fill(count, 0);

        for(int i=0; i<n; i++)
            count[arr[i] - min]++;

        for(int i=1; i<count.length; i++)
            count[i] += count[i-1];

        for(int i=n-1; i>=0; i--) {
            int index = arr[i]-min;
            output[count[index]-1] = arr[i];
            count[index]--;
        }

        for(int i=0; i<n; i++)
            arr[i] = output[i];

    }

    private static void heapify(int[] arr, int n, int i) {
        int parent = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left < n && arr[left] > arr[parent])
            parent = left;
        if(right < n && arr[right] > arr[parent])
            parent = right;
        if(parent != i) {
            swap(arr, i, parent);
            heapify(arr, n, parent);
        }
    }

    private static void heapSort(int[] arr, int n) {
        for(int i=(n/2)-1; i>=0; i--) {
            heapify(arr, n, i);
        }
        for(int i=n-1; i>=0; i--) {
            swap(arr,0, i);
            heapify(arr, i, 0);
        }
    }

    private static int nextPivot(int[] arr, int s, int e) {
        int pivot = arr[e];
        int i = s-1;
        for(int j=s; j<e; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, e);
        return i;
    }

    private static void pivotSort(int[] arr, int s, int e) {
        if(s < e) {
            int pivot = nextPivot(arr, s, e);
            pivotSort(arr, s, pivot-1);
            pivotSort(arr, pivot+1, e);
        }
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] temp = new int[e-s+1];
        int i=s, j=m+1, k=0;

        while(i<=m && j<=e) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<=m) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while(j<=e) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for(i=s; i<=e; i++)
            arr[i] = temp[i-s];
    }

    private static void mergeSort(int[] arr, int s, int e) {
        if(s < e) {
            int m = s+(e-s)/2;
            mergeSort(arr, s, m);
            mergeSort(arr, m+1, e);
            merge(arr, s, m, e);
        }
    }

    private static void selectionSortRecursion(int[] arr, int n, int i) {
        if(i > n)
            return;

        int pos = i;
        for(int j=i+1; j<=n; j++) {
            if(arr[j] < arr[pos])
                pos = j;
        }

        if(pos != i)
            swap(arr, i, pos);

        selectionSortRecursion(arr, n, i+1);
    }

    private static void selectionSort(int[] arr, int n) {
        for(int i=0; i<n; i++) {
            int pos = i;
            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[pos])
                    pos = j;
            }

            if(pos != i)
                swap(arr, i, pos);
        }
    }

    private static void insertionSortRecursion(int[] arr, int n) {
        if(n < 1)
            return;

        insertionSortRecursion(arr, n-1);
        int j = n-1;
        int val = arr[n];

        while(j>=0 && arr[j] > val) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = val;
    }

    private static void insertionSort(int[] arr, int n) {
        for(int i=1; i<n; i++) {
            int j=i-1;
            int val = arr[i];
            while(j>=0 && arr[j]>val) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = val;
        }
    }

    private static void bubbleSortRecursion(int[] arr, int n) {
        if(n < 1)
            return;

        boolean swap = false;
        for(int i=0; i<n; i++) {
            if(arr[i] > arr[i+1]) {
                swap = true;
                swap(arr, i, i+1);
            }
        }

        if(!swap)
            return;

        bubbleSortRecursion(arr, n-1);
    }

    private static void bubbleSort(int[] arr, int n) {
        for(int i=0; i<n-1; i++) {
            boolean swap = false;
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap = true;
                    swap(arr, j, j+1);
                }
            }
            if(!swap)
                break;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}




























































