package in.ineuron.questions;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListMerge {
    public static ListNode mergeLists(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        ListNode firstPtr = first;
        ListNode secondPtr = second;

        while (firstPtr != null && secondPtr != null) {
            ListNode firstNext = firstPtr.next;
            ListNode secondNext = secondPtr.next;

            firstPtr.next = secondPtr;
            secondPtr.next = firstNext;

            firstPtr = firstNext;
            secondPtr = secondNext;
        }

        second = secondPtr;

        return first;
    }

    public static void printList(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // First linked list: 5->7->17->13->11
        ListNode first = new ListNode(5);
        first.next = new ListNode(7);
        first.next.next = new ListNode(17);
        first.next.next.next = new ListNode(13);
        first.next.next.next.next = new ListNode(11);

        // Second linked list: 12->10->2->4->6
        ListNode second = new ListNode(12);
        second.next = new ListNode(10);
        second.next.next = new ListNode(2);
        second.next.next.next = new ListNode(4);
        second.next.next.next.next = new ListNode(6);

        // Merge lists
        first = mergeLists(first, second);

        // Print the merged list
        printList(first);
    }
}