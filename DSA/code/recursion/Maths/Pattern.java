package recursion.Maths;

class Pattern {
    public static void main(String[] args) {
        printTriangle(4, 0);
        System.out.println();
        printReverseTriangle(4, 0);
    }
    
    static void printTriangle(int row, int col) {
        // *
        // **
        // ***
        // ****

        if (row == 0)
            return;

        if (col < row) {
            printTriangle(row, col + 1);
            System.out.print("*");
        } else {

            printTriangle(row - 1, 0);
            System.out.println();
        }

    }
    static void printReverseTriangle(int row, int col) {
        // ****
        // ***
        // **
        // *

        if (row == 0)
            return;

        if (col < row) {
            System.out.print("*");
            printReverseTriangle(row, col + 1);
        } else {

            System.out.println();
            printReverseTriangle(row - 1, 0);
        }

    }
}