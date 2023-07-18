package in.ineuron.questions;

/*
 * <aside>
💡 **Question 8**

Given a doubly linked list and a position. The task is to delete a node from given position in a doubly linked list.

**Example 1:**

```
Input:
LinkedList = 1 <--> 3 <--> 4
x = 3
Output:1 3
Explanation:After deleting the node at
position 3 (position starts from 1),
the linked list will be now as 1->3.

```

**Example 2:**

</aside>
 * 
 */

public class Question08 {
    public static Node deleteNode(Node head, int position) {
        if (head == null) {
            return null;
        }

        if (position == 1) {
            if (head.next != null) {
                head.next.prev = null;
            }
            return head.next;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return head; // Position exceeds the length of the list
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }

        return head;
    }

}