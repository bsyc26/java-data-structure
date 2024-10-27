/** Quick Sort (sort one elem, then the left)
  * recursively towards left / right: choose any elem as partition pivot (conventionally 1st elem)
  * move elems less than pivot to its left, those greater than pivot to its right */

// quick-sort: unstable + in-place
// T: O(NlogN) // N is the length of nums[]
// S: O(1)

import java.util.Random;
import java.util.Arrays;

public class QuickSort {
    // main method
    public static void quickSort(int[] nums) {
        // const
        int N = nums.length;
        // random shuffle the nums[]
        shuffle(nums);
        // quick-sort
        sort(nums, 0, N-1); // [0..N-1]
    }

    // core methods
    private static void sort(int[] nums, int lo, int hi) { // nums[lo..hi]
        // base case
        if (lo >= hi)
            return;
        // place pvt correctly
        int pvt = partition(nums, lo, hi); // nums[lo..pvt-1] <= nums[pvt] <= nums[pvt+1..hi]
        // division
        sort(nums, lo, pvt-1);
        sort(nums, pvt+1, hi);
    }
    private static int partition(int[] nums, int lo, int hi) {
        // var
        int pvt = lo;
        int pVal = nums[lo];
        int left = lo+1; // nums[lo..left) <= pVal
        int right = hi; // nums(right..hi] > pVal
        // two-pointers:left-right
        while (left <= right) {
            while (left < hi && nums[left] <= pVal) // until find nums[left] > pVal
                left++;
            while (right > lo && nums[right] > pVal) // until find nums[right] <= pVal
                right--;
            // edge case: 
            if (left >= right) break; // already ordered
            // swap left && right
            swap(nums, left, right);
        }
        // place pvt
        swap(nums, pvt, right);
        // return
        return right;
    }

    // support methods
    private static void shuffle(int[] nums) {
        // const
        int N = nums.length;
        Random rand = new Random();
        // traverse and randomly swap nums[i] with elem of num[i..N-1]
        for (int i = 0; i < N; i++) {
            int r = i + rand.nextInt(N-i); // r: [i..N) == [i..N-1]
            swap(nums, i, r);
        }
    }
    private static void swap(int[] nums, int ptA, int ptB) {
        int tmp = nums[ptA];
        nums[ptA] = nums[ptB];
        nums[ptB] = tmp;
    }

    // unit test
    public static void main(String[] args) {
        // test0: null
        int[] test0 = new int[]{};
        System.out.println(Arrays.toString(test0));
        quickSort(test0);
        System.out.println(Arrays.toString(test0));
        // test1: ordered
        int[] test1 = new int[]{ 0, 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(test1));
        quickSort(test1);
        System.out.println(Arrays.toString(test1));
        // test2: completely dis-ordered
        int[] test2 = new int[]{ 5, 4, 3, 2, 1, 0 };
        System.out.println(Arrays.toString(test2));
        quickSort(test2);
        System.out.println(Arrays.toString(test2));
    }
}
