package in.ineuron.questions;

/*
💡 **Question 5**
	Given a linked list and a key to be deleted. Delete last occurrence of key from linked. 
	The list may have duplicates.
 **Examples**:
		Input:   1->2->3->5->2->10, key = 2
		Output:  1->2->3->5->10
 */

public class Question05 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i<n; i++)
            fast = fast.next;

        if(fast == null)
            return head.next;

        while(fast.next != null){ //lastNode -> fast.next != null
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;

    }

}