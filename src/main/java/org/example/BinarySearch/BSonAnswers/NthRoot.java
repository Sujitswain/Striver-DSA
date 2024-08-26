package org.example.BinarySearch.BSonAnswers;

public class NthRoot {

    private static int baseExp(int base, int exp) {
        int ans = 1;
        while (exp > 0) {
            if(exp%2 == 1) {
                ans = ans * base;
                exp--;
            }
            else {
                base = base * base;
                exp /= 2;
            }
        }
        return ans;
    }
    public static int bruteForce(int n, int e) {
        for(int i=1; i<=n; i++) {
            int val = baseExp(i, e);
            if(val == n)
                return i;
            if(val > n)
                break;
        }
        return -1;
    }
    public static int BSbaseExp(int mid, int n, int exp) {
        int ans = 1;
        for(int i=1; i<=exp; i++) {
            ans = ans * mid;
            if(ans > n) return 1;
        }
        if(ans == n)    return 0;
        return -1;
    }
    public static int BS(int n, int exp) {
        int s = 1;
        int e = n;

        while(s <= e) {
            int m = s+(e-s)/2;
            int check = BSbaseExp(m, n, exp);
            switch (check) {
                case 0:
                    return m;
                case 1:
                    e = m-1;
                    break;
                case -1:
                    s = m+1;
                    break;
            }
        }
        return -1;
    }

    private static void function(int number, int exp) {
        System.out.println(bruteForce(number, exp));
        System.out.println(BS(number, exp));
    }

    public static void main(String[] args) {
        function(64, 3);
        function(64, 2);
    }
}
