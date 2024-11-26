package org.example.Bitmanipulation;

public class CountTotalSetBits {
    private static int powerLessThanN(int n) {
        int x = 0;
        while((1<<x) <= n) {
            System.out.println((1 << x));
            x++;
        }
        System.out.println("X : " + (x-1));
        return x-1;
    }
    private static int function(int n) {

        if(n == 0)
            return 0;

        int x = powerLessThanN(n);

        int b2x = x * (1 << (x-1));
        int msb2xTon = n - (1 << x) + 1;
        int rest = n - (1 << x);

        int ans = b2x + msb2xTon + function(rest);

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(function(17));
    }
}
