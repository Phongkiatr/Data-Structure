package solutions.pack9_Heap;

public class MyHeapSort extends MyMinHeap {
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
