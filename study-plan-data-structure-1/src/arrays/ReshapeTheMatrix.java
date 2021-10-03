package arrays;

/**
 * 566. Reshape the Matrix (easy)
 *
 * In MATLAB, there is a handy function called reshape which can reshape
 * an m x n matrix into a new one with a different size r x c keeping its original data.
 *
 * You are given an m x n matrix mat and two integers r and c representing
 * the number of rows and the number of columns of the wanted reshaped matrix.
 *
 * The reshaped matrix should be filled with all the elements
 * of the original matrix in the same row-traversing order as they were.
 *
 * If the reshape operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 */
public class ReshapeTheMatrix {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reshape the Matrix.
     * Memory Usage: 40 MB, less than 59.82% of Java online submissions for Reshape the Matrix.
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c)
            return mat;

        int[][] res_mat = new int[r][c];
        int rows = 0;
        int cols = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                res_mat[rows][cols] = mat[i][j];
                cols++;

                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }

        return res_mat;
    }
}
