package in.ineuron.questions;

public class Question06 {
	public ListNode deleteMAndRetainNNodes(ListNode head, int m, int n) {
		ListNode p1 = head;
		ListNode p2 = head;

		while(p1 != null || p1.next != null) {
			for(int i = 0; i<m; i++) {
				p1 = p1.next;
				p2 = p1.next;
			}
			for(int j = 0; j<n; j++) {
				p1 = p1.next;
			}
			p2.next = p1.next;

		}
		return head;
	}
}