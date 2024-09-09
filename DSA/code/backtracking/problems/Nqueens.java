package backtracking.problems;

public class Nqueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board,0));
    }

    static int queens(boolean[][] board, int row) {
        // Base Condition: When Queens are placed on Each row and no row is Left
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        // Place the Queen and Check foe every row and column
        for (int col = 0; col < board.length; col++) {
//            Place the Queen if it is Safe from all other Queens
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
//        Check vertical Row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

//        Check left Diagonal
        int maxLeft = Math.min(row, col);

        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }


//        Check Right Diagonal
        int maxRight = Math.min(row, board.length - col - 1);

        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }


    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }


}
