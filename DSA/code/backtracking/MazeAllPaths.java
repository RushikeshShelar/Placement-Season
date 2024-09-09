package backtracking;

//    This is where Actual Backtracking Concept Starts
//    thought Process of backtracking is: Make the Change , Then reverse the Change

import java.util.Arrays;

public class MazeAllPaths {

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

//        allPaths(board, "", 0, 0);

        int[][] path = new int[board.length][board[0].length];
        printMatrix(board, "", 0, 0, path, 1);
    }


    static void allPaths(boolean[][] maze, String processed, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }

        if (!maze[row][col]) {
            return;
        }

//        I am Considering this path, hence block this path
        maze[row][col] = false;

        if (row < maze.length - 1) {
            allPaths(maze, processed + 'D', row + 1, col);
        }

        if (col < maze[0].length - 1) {
            allPaths(maze, processed + 'R', row, col + 1);
        }

        if (row > 0) {
            allPaths(maze, processed + 'U', row - 1, col);
        }

        if (col > 0) {
            allPaths(maze, processed + 'L', row, col - 1);
        }

//        This is the Line Where the Function Gets Over
//        So Before the Function gets Removed, Revert the Changes that Were made by that function.
        maze[row][col] = true;
    }

    static void printMatrix(boolean[][] maze, String processed, int row, int col, int[][] path, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
//            This last step is also a Step
            path[row][col] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        maze[row][col] = false;
        path[row][col] = step;

        if (row < maze.length - 1) {
            printMatrix(maze, processed + 'D', row + 1, col, path, step + 1);
        }

        if (col < maze[0].length - 1) {
            printMatrix(maze, processed + 'R', row, col + 1, path, step + 1);
        }

        if (row > 0) {
            printMatrix(maze, processed + 'U', row - 1, col, path, step + 1);
        }

        if (col > 0) {
            printMatrix(maze, processed + 'L', row, col - 1, path, step + 1);
        }

        maze[row][col] = true;
        path[row][col] = 0;
    }
}
