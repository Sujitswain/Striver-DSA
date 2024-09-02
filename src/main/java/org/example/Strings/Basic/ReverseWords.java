package org.example.Strings.Basic;


import java.util.Arrays;
import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
        function("the sky is blue");
        function("  hello world  ");
        function("a good   example");
    }
    private static void function(String str) {
        // UseSplit(str);
        // UseStack(str);
        OptimalSolution(str);
    }
    private static void OptimalSolution(String str) {
        str = str.trim();
        int n = str.length();
        int e = n;
        String ans = "";
        String s = "";

        for(int i=n-1; i>=0; i--) {
            if(str.charAt(i) == ' ') {
                s = str.substring(i+1, e);
                if(s.trim().length() > 0)
                    ans += s + " ";

                e = i;
            }
        }
        s = str.substring(0, e).trim();
        if(s.length() > 0)
            ans += s;

        System.out.println(ans);
    }
    private static void UseStack(String str) {
        int n = str.length();
        Stack<String> st = new Stack<>();
        String s = "";

        for(int i=0; i<n; i++) {
            if(str.charAt(i) == ' ') {
                if(s.trim().length() > 0)
                    st.push(s);

                s = "";
            }
            else
                s += str.charAt(i);

            if(i == n-1 && s.trim().length() > 0)
                st.push(s);
        }

        while(!st.isEmpty()) {
            System.out.print(st.peek() + " ");
            st.pop();
        }
        System.out.println();
    }
    private static void UseSplit(String str) {
        int n = str.length();
        String[] arr = str.split("\\s+");
        for(int i=arr.length-1; i>=0; i--)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
