package org.example.Bitmanipulation;

public class DivideWithoutMulDivMod {
    public static void main(String[] args) {
        function(6, 3);
    }
    private static void function(int dividend, int divisor) {
        if(dividend == 0) {
            System.out.println(0);
            return;
        }

        if(divisor == 1) {
            System.out.println(dividend);
            return;
        }

        if(divisor == -1) {
            System.out.println((dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend);
            return;
        }

        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        long d1 = Math.abs((long) dividend);
        long d2 = Math.abs((long) divisor);

        int q = 0;
        for(int i=31; i>=0; i--) {
            if((d2 << i) <= d1) {
                d1 -= (d2 << i);
                q += 1 << i;
            }
        }

        System.out.println(isNeg ? -q : q);
    }
}
