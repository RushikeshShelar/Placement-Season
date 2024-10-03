package StriverSDESheet.Patterns;

public class Main {

    public static void main(String[] args) {
//        simple();
//        triangle();
//        numTriangle();
//        numTriangleRow();
//        revTriangle();
//        revNumTriangle();
//        pyramid(5);
//        revPyramid(5);
//        diamond(5);
//        halfDiamond(5);
//        binaryNumTriangle(5);
//        numberCrown(7);
//        seqNumTriangle(5);
//        alphaTriangle(5);
//        revAlphaTriangle(5);
//        alphaTriangleRow(5);


        alphaPyramid(5);

    }


    public static void simple() {
        /*
          To Print Simple Block pattern
          *****
          *****
          *****
          *****
          *****
         */

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void triangle() {
        /*
          To Print pattern
          *
          **
          ***
          ****
          *****
         */

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void revTriangle() {
        /*
          To Print pattern
          *****
          ****
          ***
          **
          *
         */

        for (int row = 5; row > 0; row--) {
            for (int col = row; col > 0; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void numTriangle() {
        /*
          To Print pattern
          1
          12
          123
          1234
          12345
         */

        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void revNumTriangle() {
        /*
          To Print pattern
          12345
          1234
          123
          12
          1
         */

        for (int row = 5; row > 0; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void numTriangleRow() {
        /*
          To Print pattern
          1
          22
          333
          4444
          55555
         */

        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }

    public static void pyramid(int n) {
        /*
        To Print Pattern
            *
           ***
          ******
         ********
        **********

        NO. OF. SPACES = N - i(index of row) - 1
        NO. OF. STARS = 2 * i(index of row) + 1
         */
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < 2 * row + 1; i++) {
                System.out.print("*");
            }

            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void revPyramid(int n) {
         /*
        To Print Pattern
        **********
         *******
          ******
           ***
            *
        NO. OF. SPACES = N - i(index of row) - 1
        NO. OF. STARS = 2 * i(index of row) + 1
         */
        for (int row = n - 1; row >= 0; row--) {
            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < 2 * row + 1; i++) {
                System.out.print("*");
            }

            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void diamond(int n) {
       /* To Print Pattern
            *
           ***
          ******
         ********
        **********
        **********
         *******
          *****
           ***
            *
        NO. OF. SPACES = N - i(index of row) - 1
        NO. OF. STARS = 2 * i(index of row) + 1

        */

//      tOP PYRAMID
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < 2 * row + 1; i++) {
                System.out.print("*");
            }

            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        // BOTTOM REVERSE PYRAMID
        for (int row = n - 1; row >= 0; row--) {
            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < 2 * row + 1; i++) {
                System.out.print("*");
            }

            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void halfDiamond(int n) {
        /*
          To Print pattern
          *
          **
          ***
          ****
          *****
          ****
          ***
          **
          *
         */

        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int row = n - 1; row > 0; row--) {
            for (int col = row; col > 0; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void binaryNumTriangle(int n) {
        /*
          To Print pattern
          1
          01
          101
          0101
          10101

          Even Rows start = 0;

         */

        int start = 1;

        for (int row = 0; row < n; row++) {
            if (row % 2 == 0) start = 0;
            else start = 1;
            for (int col = 0; col <= row; col++) {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }
    }

    public static void numberCrown(int n) {
        /*
        To Print Pattern
            1      1
            12    21
            123  321
            12344321

        NO. OF. SPACES = 2*(n-1) and they decrease by 2 in each row
         */

        int spaces = 2 * (n - 1);
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }


            for (int i = 0; i <= spaces; i++) {
                System.out.print(" ");
            }


            for (int col = row; col > 0; col--) {
                System.out.print(col);
            }
            System.out.println();

            spaces -= 2;
        }
    }

    public static void seqNumTriangle(int n) {
        /*
          To Print pattern
          1
          2 3
          4 5 6
          7 8 9 10
          11 12 13 14 15
         */
        int start = 1;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(start++ + " ");
            }
            System.out.println();
        }
    }

    public static void alphaTriangle(int n) {
        /*
          To Print pattern
           A
           AB
           ABC
           ABCD
           ABCDE
         *
         */
        for (int row = 0; row < n; row++) {
            for (char ch = 'A'; ch <= 'A' + row; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }


    public static void revAlphaTriangle(int n) {
        /*
          To Print pattern
           ABCDE
           ABCD
           ABC
           AB
           A
         *
         */
        for (int row = n - 1; row >= 0; row--) {
            for (char ch = 'A'; ch <= 'A' + row; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void alphaTriangleRow(int n) {
        /*
          To Print pattern
          A
          BB
          CCC
          DDDD
          EEEEE
         */
        int start = 'A';
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print((char) start + ' ');
            }
            start++;
            System.out.println();
        }

//        Alternative Approach
        for (int row = 0; row < n; row++) {
            char ch = (char) ('A' + row);

            for (int col = 0; col <= row; col++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void alphaPyramid(int n) {
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }

            char ch = 'A';
            int breakpoint = (2 * row + 1) / 2;
            for (int j = 0; j < 2 * row + 1; j++) {
                System.out.print(ch);
                if (j < breakpoint) ch++;
                else ch--;
            }

            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
