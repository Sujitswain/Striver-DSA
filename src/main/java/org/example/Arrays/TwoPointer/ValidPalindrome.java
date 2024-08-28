package org.example.Arrays.TwoPointer;

public class ValidPalindrome {
    public static void main(String[] args) {
        function("A man, a plan, a canal: Panama");
        function("race a car");
    }
    private static void function(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122)
                sb.append(s.charAt(i));
        }
        System.out.println(sb);
        int l = 0;
        int r = sb.length()-1;

        while(l < r) {
            if(sb.charAt(l) !=sb.charAt(r)) {
                System.out.println("No");
                return;
            }
            l++;
            r--;
        }
        System.out.println("Yes");
    }
}
