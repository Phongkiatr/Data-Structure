package solutions.pack3_ArrAndList;

public class MyArray extends MyArrayBasic {
    public MyArray() {
        MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
    }
    public MyArray(int max) {
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
    }
    public boolean isFull() {
        return size == MAX_SIZE;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void expandByK(int k) {
        MAX_SIZE *= k;
        int tmp[] = new int[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = data[i];
        }
        data = new int[MAX_SIZE];
        for (int i = 0; i < tmp.length; i++) {
            data[i] = tmp[i];
        }
    }
    public void expand() {
        expandByK(2);
    }
    public void add(int d) {
        if (isFull()) {
            expand();
        }
        super.add(d);
    }
}