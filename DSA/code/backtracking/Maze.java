package backtracking;

//Maze Question : Move from a Start point to End point using some rules
//Rules: YOu can only move Right & down


import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(count(3, 3));
//        paths("", 3, 3);
//        System.out.println(pathRet("", 3, 3));
//        System.out.println(pathRetDiagonal("", 3, 3));

        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, false, true}
        };

        pathRestrictions(board, "", 0, 0);
    }

    static int count(int row, int col) {
        if (row == 1 || col == 1) return 1;

        int left = count(row - 1, col);
        int right = count(row, col - 1);

        return left + right;
    }

    static void paths(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(processed);
            return;
        }

        if (row > 1) {
            paths(processed + 'D', row - 1, col);
        }

        if (col > 1) {
            paths(processed + 'R', row, col - 1);
        }
    }

    static ArrayList<String> pathRet(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (row > 1) {
            list.addAll(pathRet(processed + 'D', row - 1, col));
        }

        if (col > 1) {
            list.addAll(pathRet(processed + 'R', row, col - 1));
        }
        return list;
    }

    static ArrayList<String> pathRetDiagonal(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (row > 1 && col > 1) {
            list.addAll(pathRetDiagonal(processed + 'D', row - 1, col - 1));
        }

        if (row > 1) {
            list.addAll(pathRetDiagonal(processed + 'V', row - 1, col));
        }

        if (col > 1) {
            list.addAll(pathRetDiagonal(processed + 'H', row, col - 1));
        }
        return list;
    }

    static void pathRestrictions(boolean[][] maze, String processed, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        if (row < maze.length - 1) {
            pathRestrictions(maze, processed + 'D', row + 1, col);
        }

        if (col < maze[0].length - 1) {
            pathRestrictions(maze, processed + 'R', row, col + 1);
        }
    }

}
