
package in.ineuron.questions;

import java.util.LinkedList;
import java.util.List;

public class Question01 {
	public ListNode mergeList(ListNode l1, ListNode l2) {

		List<Integer> newList = new LinkedList<>();

		while(l1.next != null || l2.next != null) {
			if(l1.val > l2.val) {
				newList.add(l1.val);
			} else {
				newList.add(l2.val);
			}
		}

		return newList;

	}
}