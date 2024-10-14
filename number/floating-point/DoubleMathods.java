/** Implementation of double methods in algs4 */

public class DoubleMethods {
    public static double sqrt(double num) { // Newton's method
        if (num < 0) return Double.NaN;
        double err = 1e-15;
        double root = num;
        while (Math.abs(root-num/root) > err*root)
            root = (num/root+root) / 2.0;
        return root;
    }
}
