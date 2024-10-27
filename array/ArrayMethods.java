/** Implementation of array methods in algs4 */

import java.util.Random;

public class ArrayMethods {
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    public static double getAvg(int[] arr) {
        int N = arr.length;
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum += arr[i];
        double avg = sum / N;
        return avg;
    }

    public static int[] copyOf(int[] arr) {
        int N = arr.length;
        int[] res = new int[N];
        for (int i = 0; i < N; i++)
            res[i] = arr[i];
        return res;
    }

    public static void reverse(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N/2; i++) {
            int tmp = arr[i];
            arr[i] = arr[N-1-1];
            arr[N-1-i] = tmp;
        }
    }

    public static void shuffle(int[] arr) { // randomly shuffle arr[]
        int N = arr.length;
        int rand = new Random();
        for (int i = 0; i < N; i++) {
            int r = i + rand.nextInt(N-i); // [i..N)
            int tmp = arr[i];
            arr[i] = arr[r];
            arr[r] = tmp;
        }
    }
}
