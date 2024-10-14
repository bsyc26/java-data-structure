/** Insertion Sort (sort left-range and insert right elem)
  * maintain nums[0..toSortIdx) as ordered (non-decreasing)
  * move nums[toSortIdx] insert into nums[0..toSortIdx) */

// insertion-sort // stable + in-place + prone-ordered
// T: O(N^2) // N: length of nums[]
// S: O(1)

import java.util.Arrays;

public class InsertionSort {
    // main method
    public static void insertionSort(int[] nums) {
        // const
        int N = nums.length;
        // traverse nums[0..N)
        for (int i = 1; i < N; i++) {
            // traverse nums[0..i) && insert nums[i]
            for (int j = i; j > 0; j--) {
                if (nums[j-1] > nums[j]) // maintain [0..toSortIdx] ordered
                    swap(nums, j-1, j);
                else // [0..toSortIdx] already order
                    break;
            }
        }
    }

    // support method
    private static void swap(int[] nums, int ptA, int ptB) throws IllegalArgumentException {
        // const
        int N = nums.length;
        // edge case
        if (ptA < 0 || ptA >= N || ptB < 0 || ptB >= N)
            throw new IllegalArgumentException("Invalid argument, index exceeds the range of array!");
        // exec swap
        int tmp = nums[ptA];
        nums[ptA] = nums[ptB];
        nums[ptB] = tmp;
    }

    // unit test
    public static void main(String[] args) {
        // var
        int[] test0 = new int[]{};
        int[] test1 = new int[]{ 0, 1, 2, 4, 5, 3 };
        int[] test2 = new int[]{ 5, 4, 3, 2, 1, 0 };
        // print orig
        System.out.println(Arrays.toString(test0));
        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        // sort
        insertionSort(test0);
        insertionSort(test1);
        insertionSort(test2);
        // print sorted
        System.out.println(Arrays.toString(test0));
        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
    }
}
