package org.example.Arrays.TwoPointer;

public class TrapRainWater {
    public static void main(String args[]) {
        function(new int[] {0,2,0,3,1,0,1,3,2,1});
                        //  0 1 2 3 4 5 6 7 8 9
    }
    private static void function(int[] arr) {
        // UsingSpace(arr);
        OptimalSolution(arr);
    }
    private static void OptimalSolution(int[] arr) {
        int n = arr.length;
        int l = 0, r = n-1;
        int leftMax = arr[l];
        int rightMax = arr[r];

        int res = 0;
        while(l < r) {
            if(leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, arr[l]);
                res += leftMax - arr[l];
                System.out.print("LeftMax: " + leftMax + ", arr["+l+"]: " +arr[l]);
            }
            else {
                r--;
                rightMax = Math.max(rightMax, arr[r]);
                res += rightMax - arr[r];
                System.out.print("RightMax: " + rightMax + ", arr["+r+"]: " +arr[r]);
            }
            System.out.println(", Res: " + res);
            System.out.println();
        }
        System.out.println(res);
    }
    private static void UsingSpace(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        rightMax[n-1] = arr[n-1];

        for(int i=1; i<n; i++)
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);

        for(int i=n-2; i>=0; i--)
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);

        int res = 0;
        for(int i=0; i<n; i++) {
            int val = Math.min(leftMax[i], rightMax[i])-arr[i];
            if(val > 0)
                res += val;
        }
        System.out.println(res);
    }
}
