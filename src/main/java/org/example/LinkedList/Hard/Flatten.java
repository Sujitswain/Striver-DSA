package org.example.LinkedList.Hard;

class SpecialNode {
    int data;
    SpecialNode next;
    SpecialNode down;

    SpecialNode(int data) {
        this.data = data;
        this.next = this.down = null;
    }
}

class SpecialLL {
    SpecialNode head = null;
    public void printNodes() {
        SpecialNode temp1 = head;
        while (temp1 != null) {
            SpecialNode temp2 = temp1;
            while (temp2 != null) {
                System.out.print(temp2.data);
                if (temp2.down != null) {
                    System.out.print(" -> ");
                }
                temp2 = temp2.down;
            }
            System.out.println();
            temp1 = temp1.next;
        }
        System.out.println("\n");
    }
}

public class Flatten {
    private static SpecialNode mergeLL(SpecialNode n1, SpecialNode n2) {
        SpecialNode head = new SpecialNode(-1);
        SpecialNode temp = head;

        while(n1 != null && n2 != null) {
            if(n1.data < n2.data) {
                temp.down = n1;
                n1 = n1.down;
            }
            else {
                temp.down = n2;
                n2 = n2.down;
            }
            temp = temp.down;
        }
        while(n1 != null) {
            temp.down = n1;

            n1 = n1.down;
            temp = temp.down;
        }
        while(n2 != null) {
            temp.down = n2;

            n2 = n2.down;
            temp = temp.down;
        }
        return head.down;
    }
    private static SpecialNode flatten(SpecialNode head) {
        if(head == null || head.next == null)
            return head;

        SpecialNode nextList = flatten(head.next);
        SpecialNode ans = mergeLL(head, nextList);
        return ans;
    }
    public static void main(String[] args) {
        SpecialLL l1 = new SpecialLL();

        l1.head = new SpecialNode(5);
        l1.head.down = new SpecialNode(7);
        l1.head.down.down = new SpecialNode(8);
        l1.head.down.down.down = new SpecialNode(30);

        l1.head.next = new SpecialNode(10);
        l1.head.next.down = new SpecialNode(20);

        l1.head.next.next = new SpecialNode(19);
        l1.head.next.next.down = new SpecialNode(22);
        l1.head.next.next.down.down = new SpecialNode(50);

        l1.head.next.next.next = new SpecialNode(28);
        l1.head.next.next.next.down = new SpecialNode(35);
        l1.head.next.next.next.down.down = new SpecialNode(40);
        l1.head.next.next.next.down.down.down = new SpecialNode(45);

        l1.printNodes();
        l1.head = flatten(l1.head);
        l1.printNodes();
    }
}
