package solutions.pack4;

import java.util.HashSet;

public class MyLinkedListTricky extends MyLinkedList {
    public void q1_rotate_counter_clockwise(int k) {
        if (k >= size()) {
            return;
        }
        Node current = head;
        int count = 1;

        if (current == null) {
            return;
        }

        while (count < k && current != null) { // k-th Node
            current = current.next;
            count++;
        }

        Node kthNode = current; // k-th Node

        while (current.next != null) { // Last Node
            current = current.next;
        }
        current.next = head;
        head = kthNode.next;
        kthNode.next = null;
    }

    public void q2_reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
    
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
    }
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
    
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    public void q3_remove_dup() {
        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.data)) { // Skip Node
                prev.next = current.next;
            } else {
                seen.add(current.data); // Add To HashSet
                prev = current;
            }
            current = current.next;
        }
    }
    public void q4_add_one() {
        head = reverse(head);

        Node current = head;
        int carry = 1;
        Node prev = null;

        while (current != null) {
            int sum = current.data + carry;
            carry = sum / 10;
            current.data = sum % 10;
    
            prev = current;
            current = current.next;
        }

        if (carry > 0) {
            prev.next = new Node(carry);
        }

        head = reverse(head);
    }
    
    public boolean q5_isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        Node middle = getMiddle(head);
        
        Node secondHalf = reverse(middle.next);
        middle.next = null;

        Node firstHalf = head;
        Node secondHalfCopy = secondHalf;

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        middle.next = reverse(secondHalfCopy);
        return true;
    }    

    private Node getMiddle(Node head) {
        int middleIndex = size() / 2;
        Node temp = head;
        for (int i = 0; i < middleIndex; i++) {
            temp = temp.next;
        }
        return temp;
    }
}