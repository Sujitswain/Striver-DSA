package org.example.Recursion;

public class Pow {
    private static double iterativeFunction(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n *= -1;
        }

        double result = 1.0;
        double currentProduct = x;

        while (n > 0) {
            if ((n & 1) == 1)
                result *= currentProduct;

            currentProduct *= currentProduct;
            n >>= 1;
        }
        return result;
    }
    private static double recursion(double x, int n, double res) {
        if(n == 0)
            return res;

        if(n < 0) {
            x = 1/x;
            n *= -1;
        }

        if((n&1) == 1)
            res *= x;

        return recursion(x * x, n>>1, res);
    }
    private static void recursiveFunction(double x, int n) {
        System.out.println(recursion(x, n, 1));
    }
    public static void main(String[] args) {
        System.out.println("Iterative: ");
        // System.out.println(iterativeFunction(2, 5));
        System.out.println(iterativeFunction(5, -2));
        // System.out.printf("%.4f", iterativeFunction(5, -2));

        System.out.println("Recursive: ");
        recursiveFunction(2, 5);
        recursiveFunction(5, -2);
        recursiveFunction(2, 7);
    }
}
