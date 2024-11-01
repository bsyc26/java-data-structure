import java.util.Arrays;

public class RadixSort {
    // core method
    public static void radixSortLSD(int[] arr) { //
        // const
        int N = arr.length;
        // var
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int elem : arr) {
            min = Math.min(min, elem);
            max = Math.max(max, elem);
        }
        // apply offset on arr[]
        int offset = -min;
        for (int i = 0; i < N; i++)
            arr[i] += offset;
        int maxLen = 1; // max len of digit
        while (max > 0) {
            max /= 10;
            ++maxLen;
        }
        // counting-sort for each digit in LSD
        for (int i = 0; i < maxLen; i++)
            countingSort(arr, i);
        // remove offset on arr[]
        for (int i = 0; i < N; i++)
            arr[i] -= offset;
    }

    // support method
    private static void countingSort(int[] arr, int k) { // k-th digit from right
        // const
        int N = arr.length;
        // vars
        int[] count = new int[10]; // 0..9
        int[] sorted = new int[N];
        int divisor = (int)Math.pow(10, k);
        // build pre-sum count[]
        for (int elem : arr) {
            int digit = (elem/divisor) % 10;
            ++count[digit];
        }
        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1];
        // build sorted[]
        for (int i = N-1; i >= 0; i--) {
            int digit = (arr[i]/divisor) % 10;
            int end = count[digit];
            sorted[end-1] = arr[i];
            --count[digit];
        }
        // copy sorted[] to arr[]
        for (int i = 0; i < N; i++)
            arr[i] = sorted[i];
    }

    // unit test
    public static void main(String[] args) {
        int[] arr = new int[]{ 0, 5, 3, 2, 1, 4 };
        radixSortLSD(arr);
        System.out.println(Arrays.toString(arr));
    }
}
