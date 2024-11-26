package org.example.Z_RANDOM_QUESTIONS;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Pair<K, V> {
    K first;
    V second;
    Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
    K getFirst() {
        return first;
    }
    V getSecond() {
        return second;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return first.equals(pair.first) && second.equals(pair.second);
    }
    @Override
    public int hashCode() {
        return 31 * first.hashCode() + second.hashCode();
    }
}

public class MaxDepthBT {
    private static int index = 0;

    static Node buildTree(Node root, int[] arr) {

        System.out.println("Enter the data: " + arr[index]);
        int data = arr[index];

        if(data == -1)
            return null;

        root = new Node(data);

        System.out.println("Enter the data for left of " + data);
        index++;
        root.left = buildTree(root.left, arr);

        index++;
        System.out.println("Enter the data for right of " + data);
        root.right = buildTree(root.right, arr);

        return root;
    }
    static void levelOrderTraversal(Node root) {
        if(root == null) {
            System.out.println("Empty...");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node temp = q.poll();

            if(temp == null) {
                System.out.println();
                if(!q.isEmpty())
                    q.add(null);
            }
            else {
                System.out.print(temp.data + " ");
                if(temp.left != null)
                    q.add(temp.left);

                if(temp.right != null)
                    q.add(temp.right);
            }
        }
    }
    static int maxDepth(Node root) {
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
    static Pair<Integer, Integer> maxDiameter(Node root) {
        if(root == null) {
                                          //  d  h
            return new Pair<Integer, Integer>(0, 0);
        }

        Pair<Integer, Integer> left = maxDiameter(root.left);
        Pair<Integer, Integer> right = maxDiameter(root.right);

        int leftHeight = left.second;
        int rightHeight = right.second;
        int diameter = left.first + right.second + 1;

        int Height = Math.max(leftHeight, rightHeight) + 1;
        int Diameter = Math.max(diameter, Math.max(left.first, right.first));

        return new Pair<>(Diameter, Height);
    }
    public static void main(String[] args) {
        // int[] arr = {1, 2, -1, -1, 3, 4, -1, -1, 5, -1, 6, 7, -1, -1, 8, -1, -1};
        int [] arr = {1, 2, -1, -1, 3, -1, -1};
        Node root = buildTree(null, arr);

        levelOrderTraversal(root);
        System.out.println(maxDepth(root));

        System.out.println(maxDiameter(root).first);
    }
}
