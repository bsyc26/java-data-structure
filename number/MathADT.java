/** Simple interface of Math in algs4 */

public interface MathADT {
    public static int abs(int num);
    public static int max(int num0, int num1);
    public static int min(int num0, int num1);

    public static double sin(double theta);
    public static double cos(double theta);
    public static double tan(double theta);

    public static double exp(double num); // e^num
    public static double log(double num); // ln(num)
    public static double pow(double base, double power); // base^power

    public static double random(); // [0, 1)
    public static double sqrt(double num);

    public static double E = 2.72; // e
    public static double PI = 3.14;
}
