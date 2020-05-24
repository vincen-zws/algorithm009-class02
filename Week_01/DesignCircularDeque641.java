public class DesignCircularDeque641 {

    int _capacity;
    int size;
    Node head;
    Node tail;

    class Node{
        int val;
        Node pre;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DesignCircularDeque641(int k) {
        this._capacity = k;
        this.size = 0;

        this.head = new Node(-1);
        this.tail = new Node(-1);

        head.next = tail;
        tail.pre = head;
    }


    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())
            return false;

        Node node = new Node(value);
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
        ++size;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())
            return false;

        Node node = new Node(value);
        node.next = tail;
        node.pre = tail.pre;

        tail.pre.next = node;
        tail.pre = node;
        ++size;
        return true;
    }



    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())
            return false;

        Node node = head.next;

        node.next.pre = node.pre;
        node.pre.next = node.next;

//        head.next = head.next.next; 这个在上两步已经做了,留下来警示自己

        node.next = node.pre = null;
        --size;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())
            return false;

        Node node = tail.pre;

        node.next.pre = node.pre;
        node.pre.next = node.next;

        //        tail.pre = head.pre.pre; 这个在上两步已经做了,留下来警示自己

        node.next = node.pre = null;
        --size;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty())
            return -1;
        return head.next.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty())
            return -1;
        return tail.pre.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head.next == tail;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size >= _capacity;
    }

    public static void main(String[] args) {
        DesignCircularDeque641 designCircularDeque641 = new DesignCircularDeque641(4);
        designCircularDeque641.insertFront(9);
        designCircularDeque641.deleteLast();
        designCircularDeque641.getRear();
        designCircularDeque641.getFront();
        designCircularDeque641.getFront();
        designCircularDeque641.deleteFront();
        designCircularDeque641.insertFront(6);
        designCircularDeque641.insertLast(5);
        designCircularDeque641.insertFront(9);
        designCircularDeque641.getFront();
        designCircularDeque641.insertFront(6);


    }
}
