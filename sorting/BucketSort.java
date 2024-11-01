import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort { // extra-space + dependent-stable
    // core method
    @SuppressWarnings("unchecked")
    public static void bucketSort(int[] arr, int bucketCount) { // O(N^2) | Ω(N+K)
        // var
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int elem : arr) {
            min = Math.min(min, elem);
            max = Math.max(max, elem);
        }
        int offset = -min;
        // build buckets
        int bucketSize = (max-min)/bucketCount + 1;
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];  // O(N+K)
        for (int i = 0; i < bucketCount; i++)
            buckets[i] = new ArrayList<>();
        // assign elems into buckets
        for (int elem : arr) {
            int i = (elem+offset) / bucketSize; // elem maps to i-th bucket
            buckets[i].add(elem);
        }
        // sort buckets
        for (int i = 0; i < bucketCount; i++)
            insertionSort(buckets[i]);
        // merge sorted buckets
        int idx = 0;
        for (int i = 0; i < bucketCount; i++) {
            for (int elem : buckets[i]) {
                arr[idx] = elem;
                ++idx;
            }
        }
    }

    // support method
    private static void insertionSort(ArrayList<Integer> arr) {
        // const
        int N = arr.size();
        // var
        int end = 0;
        // insertion-sort
        while (end < N) {
            for (int i = end-1; i >= 0; i--) {
                if (arr.get(i) > arr.get(i+1))
                    swap(arr, i, i+1);
                else
                    break;
            }
            ++end;
        }
    }
    private static void swap(ArrayList<Integer> arr, int p, int q) {
        int pVal = arr.get(p);
        int qVal = arr.get(q);
        arr.set(p, qVal);
        arr.set(q, pVal);
    }

    // unit test
    public static void main(String[] args) {
        int[] arr = new int[]{ 0, 1, 5, 3, 2, 4 };
        bucketSort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
