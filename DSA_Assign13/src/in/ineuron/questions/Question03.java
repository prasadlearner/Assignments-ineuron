package in.ineuron.questions;

public class Question03 {
	public static Node reverse(Node node, int k)
    {
        Node curr = node, prev = null; 
        int c = 0;

        while(curr != null && c<k)  {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            c++;
        }
        if(curr != null){
            node.next = reverse(curr, k);
        }
        return prev;    


    }
}