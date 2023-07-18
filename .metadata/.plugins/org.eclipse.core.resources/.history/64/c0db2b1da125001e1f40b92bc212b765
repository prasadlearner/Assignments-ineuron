package in.ineuron.questions;

public class Question08 {
	public boolean hasCycle(ListNode head) {
		// Initialize two node slow and fast point to the head node...
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			// Move slow pointer by 1 node and fast at 2 at each step
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;
		}

		return false;
	}
}