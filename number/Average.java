/** Implementation of average method of double in algs4 */

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        // var
        Scanner sc = new Scanner(System.in);
        double sum = 0.0;
        int cnt = 0;
        // read-in numbers
        while (sc.hasNext()) {
            sum += sc.nextDouble();
            cnt++;
        }
        // calc avg
        double avg = sum / cnt;
        System.out.printf("Average is %.5f\n", avg);
    }
}
