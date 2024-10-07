package org.example.Recursion;

public class Atoi {
    private static void iterativeFunction(String str) {
        int n = str.length();
        int res = 0;
        boolean sign = false;
        int i = 0;

        while (i < n && Character.isWhitespace(str.charAt(i)))
            i++;

        if(i < n && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i) == '-';
            i++;
        }

        while(i < n && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';

            if (res > (Integer.MAX_VALUE - digit) / 10) {
                res = sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                System.out.println(res);
                return;
            }

            res = res * 10 + digit;
            i++;
        }

        if(sign)
            res *= -1;

        System.out.println(res);
    }
    private static int recursion(String str, int index, int res, Boolean sign, int n) {
        if (index >= n)
            return sign ? -res : res;

        while (index < n && sign == null && str.charAt(index) == ' ')
            index++;

        if (index < n && sign == null && (str.charAt(index) == '-' || str.charAt(index) == '+')) {
            sign = (str.charAt(index) == '-');
            index++;
        }

        if (index < n && Character.isDigit(str.charAt(index))) {
            sign = sign == null ? false : sign;
            int digit = str.charAt(index) - '0';

            if (res > (Integer.MAX_VALUE - digit) / 10)
                return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            return recursion(str, index + 1, res * 10 + digit, sign, n);
        }

        return (sign != null && sign == true) ? -res : res;
    }
    private static void recursiveFunction(String str) {
        if(str.equals("")) {
            System.out.println(0);
            return;
        }
        int res = recursion(str, 0, 0, null, str.length());
        System.out.println(res);
    }
    public static void main(String[] args) {
//        iterativeFunction("42");                 // 42
//        iterativeFunction(" -042");              // -42
//        iterativeFunction("1337c0d3");           // 1337
//        iterativeFunction("0-1");                // 0
//        iterativeFunction("words and 987");      // 0

//        recursiveFunction("42");
          recursiveFunction(" -042");
//        recursiveFunction("1337c0d3");
//        recursiveFunction("0-1");
//        recursiveFunction("words and 987");

        // recursiveFunction("0-1");
        // recursiveFunction("    +2-1");
    }
}
