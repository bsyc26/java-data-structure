/** Merge Sort: recursively slice array into two halfs, and then merge them orderly
  *
  * */

//
// T: O(NlogN)
// S: O(N) // N is the arr.length
//

public class MergeSort {
    // state
    private int[] tmp;

    // main method
    public static void mergeSort(int[] arr) {
        // const
        int N = arr.length;
        // field
        tmp = new int[N];
        // merge-sort
        sort(arr, 0, N-1);
    }

    // core methods
    private static void sort(int[] arr, int lo, int hi) {
        // base case
        if (lo == hi)
            return;
        // calc mid
        int mid = lo + (hi-lo)/2;
        // division
        sort(arr, lo, mid); // arr[lo..mid]
        sort(arr, mid+1, hi); // arr[mid+1..hi]
        // post-order
        merge(arr, lo, mid, hi);
    }
    private static void merge(int[] arr, int lo, int mid, int hi) {
        // copy vals into tmp[]
        for (int i = lo; i <= hi; i++)
            tmp[i] = arr[i];
        // var
        int left = lo;
        int right = mid+1;
        // two-pointers:left-right
        for (int i = lo; i <= hi; i++) {
            // border check
            if (left == mid+1)
                arr[i] = arr[right++];
            else if (right == hi)
                arr[i] = arr[left++];
            else if (tmp[left] > tmp[right])
                arr[i] = tmp[right++];
            else
                arr[i] = tmp[left++];
        }
    }
}
