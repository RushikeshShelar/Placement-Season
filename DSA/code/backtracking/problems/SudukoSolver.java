package backtracking.problems;

public class SudukoSolver {
    public static void main(String[] args) {
        int[][] sudoku = {{5, 3, 0, 0, 7, 0, 0, 0, 0}, {6, 0, 0, 1, 9, 5, 0, 0, 0}, {0, 9, 8, 0, 0, 0, 0, 6, 0}, {8, 0, 0, 0, 6, 0, 0, 0, 3}, {4, 0, 0, 8, 0, 3, 0, 0, 1}, {7, 0, 0, 0, 2, 0, 0, 0, 6}, {0, 6, 0, 0, 0, 0, 2, 8, 0}, {0, 0, 0, 4, 1, 9, 0, 0, 5}, {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        boolean canSolve = solve(sudoku);
        if (canSolve) {
            display(sudoku);
            System.out.println(true);
        }


    }

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

//         This is how we are replacing the r,c form the arguments
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
//             If you Found Empty Element in row, then  break
            if (!emptyLeft) {
                break;
            }
        }

        if (emptyLeft) {
            return true;
        }

//         Back Tracking pArt
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    return true;
                } else {
//                  backtrack
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    static boolean isSafe(int[][] board, int row, int col, int num) {
//        Check the Row
        for (int i = 0; i < board.length; i++) {
//            Check if the Number is already in row or not?
            if (board[row][i] == num) {
                return false;
            }
        }

//        check the Col
        for (int[] nums : board) {
//            Check if the Number is already in Col or not?
            if (nums[col] == num) {
                return false;
            }
        }

        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
