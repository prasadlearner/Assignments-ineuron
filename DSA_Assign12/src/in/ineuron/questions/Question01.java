package in.ineuron.questions;

public class Question01 {

	public static ListNode mid(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	ListNode deleteMid(ListNode head) {
	        // This is method only submission.
	        // You only need to complete the method.
	        if(head==null || head.next==null){
	                return null;
	        }
	        ListNode midvalue=mid(head);
	        ListNode temp=head;
	        while(temp.next!=midvalue){
	            temp=temp.next;
	        }
	        temp.next=midvalue.next;
	        return head;
	}

}
