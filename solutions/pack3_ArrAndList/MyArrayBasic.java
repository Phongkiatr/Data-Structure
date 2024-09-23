package solutions.pack3_ArrAndList;
public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;
    public MyArrayBasic(int ... a) {
        if(a != null && a.length > MAX_SIZE) {
            MAX_SIZE = a.length;
            size = a.length;
            data = new int[MAX_SIZE];
            for (int i = 0; i < size; i++) {
                data[i] = a[i];
            }
        }
    }
    public void add(int d) {
        data[size++] = d;
    }
    public void insert(int d, int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1]; 
        }
        data[index] = d;
        size++;
    }
    public int find(int d) {
        for (int i = 0; i < size; i++) {
            if(data[i] == d) {
                return i;
            }
        }
        return -1;
    }
    public int binarySearch(int d) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == d)
                return mid;
            if (d < data[mid]) 
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
    public void delete(int index) {
        if (size > 0) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[--size] = 0;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0)
            sb.append(data[size - 1]);
        sb.append("]");
        return sb.toString();
    }
}