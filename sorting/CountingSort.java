import java.util.Arrays;

public class CountingSort { // extra-space + stable
    // core method
    public static void countingSort(int[] arr) { // O(N+max-min)
        // const
        int N = arr.length;
        // var
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int elem : arr) {
            min = Math.min(min, elem);
            max = Math.max(max, elem);
        }
        int offset = -min;
        // build pre-sum count
        int[] count = new int[max-min+1];
        for (int elem : arr)
            ++count[elem+offset];
        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1]; 
        // build sorted
        int[] sorted = new int[N];
        for (int i = N-1; i >= 0; i--) { // reverse fill-in to keep stable
            int idx = arr[i] + offset;
            int end = count[idx];
            sorted[end-1] = arr[i];
            --count[idx];
        }
        for (int i = 0; i < N; i++)
            arr[i] = sorted[i];
    }

    // unit test
    public static void main(String[] args) {
        int[] arr = new int[]{ 0, 3, 1, 3, 1};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
