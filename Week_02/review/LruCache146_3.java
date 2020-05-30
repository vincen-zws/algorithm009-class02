package review;

import java.util.HashMap;
//第三遍
public class LruCache146_3 {
    class Node {
        int key;
        int val ;
        Node pre;
        Node next;
        public Node(int key , int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int capacity;
    int size;
    HashMap<Integer,Node> keyAndPoint = new HashMap<>();

    public LruCache146_3(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);

        head.next = tail;
        tail.pre = head;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public Node addFirst(Node node) {
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
        return node;
    }

    public Node remove(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;

        node.pre = node.next = null;
        return node;
    }

    public Node removeTail() {
        if(isEmpty())
            return null;
        keyAndPoint.remove(tail.pre.key);
        --size;
        return remove(tail.pre);
    }

    public int get(int key) {
        if (keyAndPoint.containsKey(key)) {
           Node node = keyAndPoint.get(key);
           remove(node);
           addFirst(node);
           return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {


        if (keyAndPoint.containsKey(key)) {
            Node node = keyAndPoint.get(key);
            node.val = value;
            remove(node);
            addFirst(node);

        } else {
            if(isFull())
                removeTail();
            Node node = new Node(key,value);
            keyAndPoint.put(key,node);
            addFirst(node);
            ++size;
        }
    }

    public static void main(String[] args) {
        LruCache146_3 lruCache146_3 = new LruCache146_3(2);
        lruCache146_3.put(2,6);
        lruCache146_3.put(1,5);
        lruCache146_3.put(1,2);
        System.out.println(lruCache146_3.get(1));
        System.out.println(lruCache146_3.get(2));

    }
}
