import java.util.Random;
import java.util.Arrays;

public class QuickSort { // in-place + unstable
    // core methods
    public static void quickSort(int[] arr) { // O(NlogN)~O(N^2)
        shuffle(arr);
        partition(arr, 0, arr.length-1);
    }
    private static void partition(int[] arr, int lo, int hi) { // 3way
        // base case
        if (lo >= hi)
            return;
        // vars
        int pivot = arr[lo];
        int lt = lo; // [0, lt) < v
        int gt = hi; // (gt, hi] > v
        int i = lo+1; // [lt, gt] = v
        // pre order
        while (i <= gt) {
            if (arr[i] < pivot)
                swap(arr, lt++, i++);
            else if (arr[i] > pivot)
                swap(arr, i, gt--);
            else
                ++i;
        }
        // traverse
        partition(arr, lo, lt-1); // [lo..lt-1] < pivot
        partition(arr, gt+1, hi); // [gr+1..hi] > pivot
    }

    // support methods
    private static void shuffle(int[] arr) {
        int N = arr.length;
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int r = i + rand.nextInt(N-i);
            swap(arr, i, r);
        }
    }
    private static void swap(int[] arr, int p, int q) {
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }

    // unit test
    public static void main(String[] args) {
        int[] arr = new int[]{ 3, 2, 1, 5, 3, 6 };
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
