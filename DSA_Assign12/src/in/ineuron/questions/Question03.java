package in.ineuron.questions;

public class Question03 {
	//Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(ListNode head, int n)
    {
    	ListNode slow = head;
    	ListNode fast = head;
    	Integer number = 0;

    	if(head == null){
    	    return -1;
    	}

    	for(int i = 0; i<n; i++){
    	    fast = fast.next;
    	}

    	if(fast == null){
    	    return -1;
    	}

    	while(fast.next != null){
    	    slow = slow.next;
    	    fast = fast.next;
    	}

    	number = slow.next.val;
    	return slow.next.val;


    }
}