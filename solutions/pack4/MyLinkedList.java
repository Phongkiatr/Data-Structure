package solutions.pack4;

public class MyLinkedList_660880 {
    public class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
        }
    }
    Node head = null; // start
    
    public void add(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
    }
    public void add(int ... arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            add(arr[i]);
        }
    }

    public void insert(int d) {
        Node p = new Node(d);
        if (head == null || head.data >= p.data) {
            p.next = head;
            head = p;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data < p.data) {
            current = current.next;
        }
        p.next = current.next;
        current.next = p;
    }
    public void insert(int ... arr) {
        for (int d : arr) {
            insert(d);
        }
    }

    public void delete(int d) {
        Node cur = head;
        while( (cur.next != null) && (cur.next.data != d) ) {
            cur = cur.next;
        }
        if(cur.next != null) {
            cur.next = cur.next.next;
        }
    }

    public int find(int d) {
        Node current = head;
        int idx = 0;
        while (current != null) {
            if (current.data == d) {
                return idx;
            }
            current = current.next;
            idx++;
        }
        return -1;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while(p!=null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("--> null");
        return new String(sb);
    }
}