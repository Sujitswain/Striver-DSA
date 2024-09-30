package org.example.LinkedList.Hard;

import java.util.HashMap;
import java.util.Map;

class NodeWithR {
    int data;
    NodeWithR next;
    NodeWithR random;
    NodeWithR(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}
public class CopyLLRandomPointer {
    public static void printNodes(NodeWithR head) {
        NodeWithR temp = head;
        while(temp != null) {
            System.out.println("temp.data = " + temp.data + ", temp.random = " + (temp.random != null ? temp.random.data : "null" ));
            temp = temp.next;
        }
    }
    public static NodeWithR insertAtLast(NodeWithR head, int data) {
        NodeWithR newNode = new NodeWithR(data);
        if (head == null)
            return newNode;

        NodeWithR temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        return head;
    }
    private static void cloneNodeUsingSpace(NodeWithR l1) {
        Map<NodeWithR, NodeWithR> mp = new HashMap<>();

        NodeWithR originalHead = l1;
        NodeWithR cloneHead = null;

        // cloning the next node
        while(originalHead != null) {
            cloneHead = insertAtLast(cloneHead, originalHead.data);
            originalHead = originalHead.next;
        }
        System.out.println("\nCopied next");
        printNodes(cloneHead);

        originalHead = l1;
        NodeWithR cloneIterator = cloneHead;
        while(originalHead != null) {
            mp.put(originalHead, cloneIterator);

            originalHead = originalHead.next;
            cloneIterator = cloneIterator.next;
        }

        // cloning the random node
        originalHead = l1;
        cloneIterator = cloneHead;
        while(originalHead != null) {
            cloneIterator.random = mp.get(originalHead.random);

            cloneIterator = cloneIterator.next;
            originalHead = originalHead.next;
        }

        System.out.println("\nCopied random");
        printNodes(cloneHead);
    }
    private static void cloneNodeOptimal(NodeWithR head) {
        NodeWithR originalIterator = head;
        NodeWithR cloneHead = null;

        while(originalIterator != null) {
            cloneHead = insertAtLast(cloneHead, originalIterator.data);
            originalIterator = originalIterator.next;
        }
        System.out.println("\nClone next:");
        printNodes(cloneHead);

        // swapping the links
        originalIterator = head;
        NodeWithR cloneIterator = cloneHead;
        while(originalIterator != null) {
            NodeWithR temp = originalIterator.next;
            originalIterator.next = cloneIterator;
            originalIterator = temp;

            temp = cloneIterator.next;
            cloneIterator.next = originalIterator;
            cloneIterator = temp;
        }

        // clone the random nodes
        NodeWithR temp = head;
        while(temp != null) {
            if(temp.next != null)
                temp.next.random = temp.random != null ?
                                    temp.random.next :
                                    null;

            temp = temp.next.next;
        }

        // make the original and clone as per the structure
        originalIterator = head;
        cloneIterator = cloneHead;
        while(originalIterator != null && cloneIterator != null) {
            originalIterator.next = cloneIterator.next;
            originalIterator = originalIterator.next;

            if(originalIterator != null){
                cloneIterator.next = originalIterator.next;
            }

            cloneIterator = cloneIterator.next;
        }
        System.out.println("\nClone random:");
        printNodes(cloneHead);
    }
    public static void main(String[] args) {
        NodeWithR l1 = new NodeWithR(7);
        l1.next = new NodeWithR(13);
        l1.next.next = new NodeWithR(11);
        l1.next.next.next = new NodeWithR(10);
        l1.next.next.next.next = new NodeWithR(1);

        l1.random = l1.next.next.next.next.next;
        l1.next.random = l1;
        l1.next.next.random = l1.next.next.next.next;
        l1.next.next.next.random = l1.next.next;
        l1.next.next.next.next.random = l1;

        printNodes(l1);

        // using map
        // cloneNodeUsingSpace(l1);

        // optimal solution
        cloneNodeOptimal(l1);
    }
}
