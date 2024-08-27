package org.example.Arrays.Hard;

public class PascalTriangle {
    public static void main(String[] args) {
        function(5);
    }
    private static void function(int n) {
        for(int i=1; i<=n; i++) {
            optimalSolution(i);
        }
    }
    private static void optimalSolution(int n) {
        int ans = 1;
        System.out.print(ans + " ");
        for(int i=1; i<n; i++) {
            ans = ans * (n-i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }
}
