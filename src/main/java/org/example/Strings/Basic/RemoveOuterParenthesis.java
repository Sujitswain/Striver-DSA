package org.example.Strings.Basic;

import java.util.Stack;

public class RemoveOuterParenthesis {
    public static void main(String[] args) {
        function("(()())(())");
        function("(()())(())(()(()))");
        function("()()");
    }

    private static void function(String str) {
        UsingStack(str);
        // constantSpace(str);
    }
    private static void constantSpace(String s) {
        int c = 0;
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                if(c > 0)
                    sb.append(ch);
                c++;
            }
            else {
                if(c > 1)
                    sb.append(ch);
                c--;
            }
        }
        System.out.println(sb);
    }
    private static void UsingStack(String str) {
        int n = str.length();
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        int j = 1;

        for(int i=0; i<n; i++) {
            if(str.charAt(i) == '(')
                s.add('(');
            else {
                s.pop();
                if(s.isEmpty()) {
                    sb.append(str.substring(j, i));
                    j=i+2;
                }
            }
        }
        System.out.println(sb);
    }
}
