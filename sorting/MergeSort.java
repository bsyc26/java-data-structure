import java.util.Arrays;

public class MergeSort { // extra-space + stable
    // state
    private static int[] temp; // O(N)

    // core methods
    public static void mergeSort(int[] arr) { // O(NlogN)
        int N = arr.length;
        temp = new int[N];
        sort(arr, 0, N-1);
    }
    private static void sort(int[] arr, int lo, int hi) {
        // base case
        if (lo == hi)
            return;
        // pre order
        int mid = lo + (hi-lo)/2;
        // division
        sort(arr, lo, mid);
        sort(arr, mid+1, hi);
        // post order
        merge(arr, lo, mid, hi);
    }
    private static void merge(int[] arr, int lo, int mid, int hi) {
        // copy to temp
        for (int i = lo; i <= hi; i++)
            temp[i] = arr[i];
        // two-pointers:parallel
        int first = lo; // first: lo..mid
        int second = mid+1; // second: mid+1..hi
        for (int i = lo; i <= hi; i++) {
            // case: one ptr reaches end
            if (first == mid+1)
                arr[i] = temp[second++];
            else if (second == hi+1)
                arr[i] = temp[first++];
            // case: comp and step ptr
            else if (temp[first] > temp[second])
                arr[i] = temp[second++];
            else
                arr[i] = temp[first++];
        }
    }

    // unit test
    public static void main(String[] args) {
        int[] arr = new int[]{ 3, 4, 6, 2, 1, 9, 3, 5 };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
