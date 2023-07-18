package in.ineuron.questions;

import java.util.ArrayList;


public class Question05 {
	public static void removeLoop(ListNode head) {
		// code here
		// remove the loop without losing any nodes
		ArrayList<Integer> item = new ArrayList<Integer>();
		ListNode temp = head;
		while (true) {
			if (temp.next == null) {
				return;
			}
			if (temp.next.val == -1) {
				temp.next = null;
				break;
			}
			item.add(temp.val);
			temp.val = -1;
			temp = temp.next;
		}
		temp = head;
		for (int i = 0; i < item.size(); i++) {
			temp.val = item.get(i);
			temp = temp.next;
		}
		return;

	}

}