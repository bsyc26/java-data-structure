/** Implementation of random seq generator with cmd args in algs4 */

import java.util.Random;

public class RandSeq {
    public static void main(String[] args) {
        // const
        Random rand = new Random();
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        // gen && print rand num
        for (int i = 0; i < N; i++) {
            double cur = rand.nextDouble(lo, hi);
            System.out.printf("%.2f\n", cur);
        }
    }
}
