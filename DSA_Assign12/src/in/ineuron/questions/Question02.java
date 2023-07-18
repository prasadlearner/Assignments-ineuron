package in.ineuron.questions;

public class Question02 {
	public static boolean detectLoop(ListNode head){

		ListNode slow= head;
		ListNode fast= head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
            if(slow==fast){
                return true;
            }
        }

        return false;
    }
}
