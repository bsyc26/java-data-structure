public class ShellSort { // in-place + unstable
    // core method
    public static void shellSort(int[] arr) { // O(N^2) | Θ(N^3/2)
        // const
        int N = arr.length;
        // var
        int h = 1; // gen func: (3^k-1) / 2
        while (h < N / 3)
            h = h*3 + 1;
        // shell-sort
        while (h >= 1) {
            int end = h; // [0, end) is sorted
            while (end < N) {
                for (int i = end; i >= h; i -= h) {
                    if (arr[i] < arr[i-h])
                        swap(arr, i, i-h);
                    else
                        break;
                }
                // step end
                ++end;
            }
            // step h
            h /= 3;
        }
    }
}
