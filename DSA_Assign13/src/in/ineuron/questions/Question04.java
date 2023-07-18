package in.ineuron.questions;

public class Question04 {
    public static Node reverseAlternateKNodes(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Reverse the first k nodes of the list
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Connect the reversed k nodes to the original list
        if (head != null) {
            head.next = current;
        }

        // Skip the next k nodes and recursively reverse the remaining list
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current != null) {
            current.next = reverseAlternateKNodes(current.next, k);
        }

        // Return the new head of the reversed list
        return prev;
    }

}