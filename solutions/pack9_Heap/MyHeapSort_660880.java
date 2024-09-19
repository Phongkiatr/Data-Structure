package solutions.pack9_Heap;

public class MyHeapSort_660880 extends MyMinHeap_660880 {
    public String sort() {
        int originalSize = size;
        int sortedHeap[] = new int[size];
        for (int i = 0; i < originalSize; i++) {
            sortedHeap[i] = remove();
        }
        heap = sortedHeap;
        size = heap.length;
        return toString();
    }
}
