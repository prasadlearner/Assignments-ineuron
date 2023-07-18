package in.ineuron.questions;

/*
💡 **Question 7**
	Given a **Doubly Linked List**, the task is to reverse the given Doubly Linked List.
 	**Example:**
 	Original Linked list 10 8 4 2
	Reversed Linked list 2 4 8 10
 */

public class Question07 {
	public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;

    }

}