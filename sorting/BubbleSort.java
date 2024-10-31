public class BubbleSort { // in-place + stable
    // core method
    public static void bubbleSort(int[] arr) { // O(N^2)
        // const
        int N = arr.length;
        // vars
        int end = 0;
        boolean isSwapped = false;
        // bubble-sort
        while (end < N) {
            // find min in [end, N) && move it to end
            for (int i = N-1; i > end; i--) {
                if (arr[i] < arr[i-1]) {
                    swap(arr, i, i-1);
                    isSwapped = true;
                }
            }
            // case: aleady sorted
            if (!isSwapped)
                break;
            // step end
            ++end;
        }
    }

    // support method
    private static void swap(int[] arr, int p, int q) {
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }
}
