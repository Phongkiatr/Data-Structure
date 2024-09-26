package Labs;
import solutions.pack4.MyLinkedList;
import solutions.pack4.MyLinkedListTricky;

public class Lab4_MyLinkedListMain {
    public static void main(String[] args) {
        demo1();
    }

    static void demo1() {
        MyLinkedList list = new MyLinkedList();
        list.add(5);
        list.add(1);
        list.insert(4);
        list.insert(3);
        list.insert(2);
        System.out.println(list);
        list.delete(6);
        System.out.println("5 is at " + list.find(5));
        System.out.println(list);
    }
    
    static void demo2() {
        int [] arr = {50,40,30,20,10};
        MyLinkedList mList = new MyLinkedList();
        mList.add(arr);
        System.out.println(mList);
    }

    static void q1() {
        int [] d = {10,20,30,40,50};
        MyLinkedListTricky mList = new MyLinkedListTricky();
        mList.add(d);
        System.out.println("before -> " + mList);
        mList.q1_rotate_counter_clockwise(1);
        System.out.println("(k = " + 1 + ") -> " + mList);
        mList.q1_rotate_counter_clockwise(3);
        System.out.println("(k = " + 3 + ") -> " +mList);
        mList.q1_rotate_counter_clockwise(7);
        System.out.println("(k = " + 7 + ") -> " +mList);
    }
    static void q2() {
        int [] d = {1,2,3,4,5,6,7,8};
        MyLinkedListTricky mList = new MyLinkedListTricky();
        mList.add(d);
        System.out.println("before -> " + mList);
        mList.q2_reverse();
        System.out.println("after -> " + mList);
    }
    static void q3() {
        int [] d = {13, 11, 4, 15, 4};
        MyLinkedListTricky mList = new MyLinkedListTricky();
        mList.add(d);
        System.out.println("before -> " + mList);
        mList.q3_remove_dup();
        System.out.println("after -> " + mList);
        int [] e = {13, 11, 15, 4};
        mList = new MyLinkedListTricky();
        mList.insert(e);
        System.out.println("before -> " + mList);
        mList.q3_remove_dup();
        System.out.println("after -> " + mList);
    }

    static void q4() {
        int [] d = {1, 9, 9, 9};
        MyLinkedListTricky mList = new MyLinkedListTricky();
        mList.add(d);
        System.out.println("before -> " + mList);
        mList.q4_add_one();
        System.out.println("after -> " + mList);
    }
    static void q5() {
        int [] d = {21, 33, 33, 21};
        boolean isPalind;
        MyLinkedListTricky mList = new MyLinkedListTricky();
        mList.add(d);
        isPalind = mList.q5_isPalindrome();
        System.out.println(mList + " isPalindrome() = " + isPalind);
        int [] e = {21, 33, 44, 33, 21};
        mList = new MyLinkedListTricky();
        mList.add(e);
        isPalind = mList.q5_isPalindrome();
        System.out.println(mList + " isPalindrome() = " + isPalind);
        int [] f = {1, 9, 9, 9};
        mList = new MyLinkedListTricky();
        mList.add(f);
        isPalind = mList.q5_isPalindrome();
        System.out.println(mList + " isPalindrome() = " + isPalind);
    }
}