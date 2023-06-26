

/**
 * Implement a queue using a linked list in Java. Include the necessary methods 
 * such as enqueue, dequeue, and isEmpty.
 * 
 * 
 *
 */
class MyCircularQueue {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            next = null;
        }
    }
    int k;
    int size = 0;
    Node head;
    Node tail;
    public MyCircularQueue(int k) {
        this.k = k;
        head = null;
        tail = null;
    }

    public boolean enQueue(int value) {
        if(size < k) {
            size++;
            Node new_node = new Node(value);
            if(head == null) {
                head = new_node;
                tail = new_node;
                return true;
            } 
            tail.next = new_node;
            tail = tail.next;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(head == null) return false;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        size--;
        return true;
    }

    public boolean isEmpty() {
        return (head == null);
    }
}
