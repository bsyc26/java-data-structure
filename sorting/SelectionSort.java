public class SelectionSort { // in-place + unstable
    // core method
    public static void selectionSort(int[] arr) { // O(N^2) | Ω(N^2)
        // const
        int N = arr.length;
        // var
        int end = 0; // [0, end) is sorted
        // selection-sort
        while (end < N) {
            // find min in [end, N)
            int min = end;
            for (int i = end+1; i < N; i++)
                if (arr[i] < arr[min])
                    min = i;
            // swap min and end
            swap(arr, min, end);
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
