package in.ineuron.questions;

public class Question02 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode l = head;

		while (l != null && l.next != null) {
			if (l.val != l.next.val) {
				l = l.next;
			} else {
				l.next = l.next.next;
			}
		}
		return head;
	}
}
