/** Implementation of integer methods in algs4 */

public class IntegerMethods {
    public static int abs(int num) {
        return (num < 0) ? -num : num;
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i*i <= num; i++)
            if (num % i == 0)
                return false;
        return true;
    }
}
