package org.example.Recursion;

import java.util.List;
import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        List.of(1,3,4,2,5).stream().forEach(a -> st.push(a));
        recursionMethod(st);

        System.out.println(st);
    }
    private static void recursionMethod(Stack<Integer> st) {
        if(st.empty())
            return;

        int top = st.pop();
        recursionMethod(st);
        insertAtLast(st, top);
    }
    private static void insertAtLast(Stack<Integer> st, int n) {
        if(st.empty()) {
            st.push(n);
            return;
        }

        int top = st.pop();
        insertAtLast(st, n);
        st.push(top);
    }
}
