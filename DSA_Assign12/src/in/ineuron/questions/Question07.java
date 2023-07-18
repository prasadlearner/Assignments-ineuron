package in.ineuron.questions;

public class Question07 {
	public ListNode mergeLists(ListNode l1, ListNode l2) {

		if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l2.next != null ) {
        	l1.next = mergeLists(l1.next, l2);
        	return l1;
        } 
        if(l1.next != null) {
        	 l2.next = mergeLists(l1, l2.next);
             return l2;
        }
		return l1;
	}
}