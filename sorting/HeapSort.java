public class HeapSort { // in-place + unstable
    // core methods
    public void sort(int[] arr) { // O(NlogN)
        // const
        int N = arr.length;
        // build max-heap in-place
        for (int i = 0; i < N; i++)
            maxHeapSwim(arr, i);
        // var
        int size = N; // num of elems in maxHeap
        // heap-sort
        while (size > 0) {
            // del heap top elem -- the reason why use max heap
            swap(arr, 0, size-1);
            --size;
            // restore max heap
            maxHeapSink(arr, 0, size); // [0..size) is max-heap, [size..N) is sorted
        }
    }
    private void maxHeapSwim(int[] heap, int node) { // O(logN)
        while (node > 0 && heap[parent(node)] < heap[node]) {
            swap(heap, parent(node), node);
            node = parent(node);
        }
    }
    private void maxHeapSink(int[] heap, int node, int size) { // O(logN)
        while (left(node) < size || right(node) < size) {
            int max = node;
            if (left(node) < size && heap[left(node)] > heap[max])
                max = left(node);
            if (right(node) < size && heap[right(node)] > heap[max])
                max = right(node);
            if (max == node) // already max heap
                break;
            swap(heap, node, max);
            node = max;
        }
    }

    // support methods
    private int parent(int node) {
        return (node-1) / 2;
    }
    private int left(int node) {
        return node*2 + 1;
    }
    private int right(int node) {
        return node*2 + 2;
    }
    private void swap(int[] arr, int p, int q) {
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }
}
