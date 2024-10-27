/** Implementation of matrix methods in algs4 */

public class MatrixMethods {
    public static int[][] matMult(int[][] mat0, int[][] mat1) {
        int N = mat0.length;
        int[][] res = new int[N][N];
        for (int row = 0; row < N; row++)
            for (int col = 0; col < N; col++)
                for (int i = 0; i < N; i++)
                    res[row][col] += mat0[row][i] * mat1[i][col];
        return res;
    }
}
