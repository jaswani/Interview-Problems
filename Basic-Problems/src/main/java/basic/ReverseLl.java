package basic;

import java.util.Random;

/**
 * Created by jai on 8/18/15.
 */
public class ReverseLl {

    private static class linklist {
        int value;
        linklist next;
        linklist(int value) {
            this.value = value;
            this.next = null;
        }
        void setNext(linklist next) {
            this.next = next;
        }
    }

    static linklist reverse(linklist node) {
        if (node == null) {
            return null;
        }

        linklist head, newllhead, nexthead;
        head = node;
        nexthead = node.next;
        newllhead = null;

        while(head != null) {
            head.next = newllhead;
            newllhead = head;
            head = nexthead;
            if (nexthead != null) {
                nexthead = nexthead.next;
            }
        }
        return newllhead;
    }

    static void print(linklist node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String []args) {
        Random r = new Random(System.currentTimeMillis());
        linklist head = null;
        int length = 7;
//        int length = r.nextInt(10);
        for (int i = 0; i < length; i++) {
            linklist temp = new linklist(r.nextInt(10));
            temp.setNext(head);
            head = temp;
        }
        print(head);
        head = reverse(head);
        print(head);
    }
}
