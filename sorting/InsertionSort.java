public class InsertionSort { // in-place + stable
    // core method
    public static void insertionSort(int[] arr) { // O(N^2) | Ω(N) 
        // const
        int N = arr.length;
        // var
        int end = 0;
        // insertion-sort
        while (end < N) {
            // insert arr[end] into sorted[0, end)
            for (int i = end; i > 0; i--) {
                if (arr[i] < arr[i-1])
                    swap(arr, i, i-1);
                else
                    break;
            }
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
