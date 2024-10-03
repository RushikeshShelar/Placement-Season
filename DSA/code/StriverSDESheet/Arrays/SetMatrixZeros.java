package StriverSDESheet.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/

public class SetMatrixZeros {

    //    Approach 1: brute Force
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    setRows(matrix, m, i);
                    setCols(matrix, n, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -10) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public void setRows(int[][] matrix, int len, int row) {
        for (int i = 0; i < len; i++) {
            if (matrix[row][i] != 0) {
                matrix[row][i] = -10;
            }
        }
    }

    public void setCols(int[][] matrix, int len, int col) {
        for (int i = 0; i < len; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = -10;
            }
        }
    }

    //    Approach 2: Better Approach
    public void setZerosBetter(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //    Approach 3: Optimal Solution (in place replacement)
    public void setZerosOptimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
//               Mark the ith row
                    matrix[i][0] = 0;
//                Mark th jth col
                    if (j != 0) {
                        matrix[0][j] = 0;
                    }else{
                        col0 = 0;
                    }

                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
//                   Check for col and row
                    if(matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j] = 0;
                    }

                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 0; j < m; j++){
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
