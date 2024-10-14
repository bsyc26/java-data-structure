/** Implementation of BinarySearch in algs4 */

import java.util.Arrays;

public class BinarySearch {
    // search method
    public static int binarySearch(int[] arr, int key) { // arr must be sorted
        // const
        int N = arr.length;
        // var
        int lo = 0;
        int hi = N-1; // [0, N-1]
        // binary search
        while (lo <= hi) {
            // calc mid && get arr[mid]
            int mid = lo + (hi-lo)/2;
            int cur = arr[mid];
            // step next || return idx
            if (cur < key)
                lo = mid+1;
            else if (cur > key)
                hi = mid-1;
            else
                return mid;
        }
        // return fallback if key not in arr[]
        return -1;
    }
    
    public static int binarySearchRecur(int[] arr, int key) {
        return rank(arr, 0, arr.length-1, key);
    }
    private static int rank(int[] arr, int lo, int hi, int key) {
        // base case
        if (lo > hi)
            return -1;
        // calc mid && get arr[mid]
        int mid = lo + (hi-lo)/2;
        int cur = arr[mid];
        // step next
        if (cur < key)
            return rank(arr, mid+1, hi, key);
        else if (cur > key)
            return rank(arr, lo, mid-1, key);
        else
            return mid;
    }

    // main method
    public static void main(String[] args) {
        // test 0
        int[] arr0 = new int[]{};
        Arrays.sort(arr0);
        System.out.println(binarySearch(arr0, 1));
        System.out.println(binarySearchRecur(arr0, 1));

        // test 1
        int[] arr1 = new int[]{ 2, 0, 1 };
        Arrays.sort(arr1);
        System.out.println(binarySearch(arr1, 1));
        System.out.println(binarySearchRecur(arr1, 1));

        // test 2
        int[] arr2 = new int[]{ 2, 0 };
        Arrays.sort(arr2);
        System.out.println(binarySearch(arr2, 1));
        System.out.println(binarySearchRecur(arr2, 1));
    }
}
