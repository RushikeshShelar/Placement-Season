package CodeVita;

import java.util.*;

public class FaultySegment {
    // Map to store patterns for each character
    private static final Map<String, String> PATTERNS = new HashMap<String, String>() {{
        put("   ", "0");
        put("  *  |  |", "1");
        put(" * _||_ ", "2");
        put(" * _| _|", "3");
        put("   |_|  |", "4");
        put(" *|_  _|", "5");
        put(" *|_ |_|", "6");
        put(" *   |  |", "7");
        put(" *|_||_|", "8");
        put(" *|_| _|", "9");
        put("   |_|   ", "+");
        put("    _    ", "-");
        put("   |_|  |", "*");
        put("    _    ", "=");
        put("   | |   ", "/");
    }};

    // Parse the display into individual character matrices
    private static List<char[][]> parseSegmentDisplay(String[] lines, int n) {
        List<char[][]> chars = new ArrayList<>();
        for (int i = 0; i < lines[0].length(); i += 4) {
            char[][] matrix = new char[3][3];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    matrix[row][col] = lines[row].charAt(i + col);
                }
            }
            chars.add(matrix);
            if (chars.size() == n) break;
        }
        return chars;
    }

    // Convert matrix to string pattern
    private static String matrixToString(char[][] matrix) {
        StringBuilder pattern = new StringBuilder();
        for (char[] row : matrix) {
            pattern.append(row);
        }
        return pattern.toString();
    }

    // Get character from matrix pattern
    private static String getCharacter(char[][] matrix) {
        String pattern = matrixToString(matrix);
        return PATTERNS.getOrDefault(pattern, "?");
    }

    // Evaluate the expression
    private static boolean evaluateExpression(String expression) {
        try {
            String[] parts = expression.split("=");
            if (parts.length != 2) return false;

            String left = parts[0];
            String right = parts[1];

            // Evaluate left side
            int result = Character.getNumericValue(left.charAt(0));
            for (int i = 1; i < left.length(); i += 2) {
                char op = left.charAt(i);
                int num = Character.getNumericValue(left.charAt(i + 1));

                switch (op) {
                    case '+': result += num; break;
                    case '-': result -= num; break;
                    case '*': result *= num; break;
                    case '/': result /= num; break;
                }
            }

            return result == Integer.parseInt(right);
        } catch (Exception e) {
            return false;
        }
    }

    // Toggle LED at given position
    private static char[][] toggleLed(char[][] matrix, int pos) {
        char[][] newMatrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            newMatrix[i] = matrix[i].clone();
        }
        int row = pos / 3;
        int col = pos % 3;
        newMatrix[row][col] = newMatrix[row][col] == ' ' ? '*' : ' ';
        return newMatrix;
    }

    // Find the faulty LED position
    private static int findFaultyLed(int n, String[] displayLines) {
        List<char[][]> chars = parseSegmentDisplay(displayLines, n);

        // Try toggling each LED in each character
        for (int charPos = 0; charPos < n - 1; charPos++) {
            char[][] originalMatrix = chars.get(charPos);

            // Try each position in the 3x3 matrix
            for (int ledPos = 0; ledPos < 9; ledPos++) {
                // Create a copy of all characters
                List<char[][]> newChars = new ArrayList<>(chars);
                // Toggle the LED
                newChars.set(charPos, toggleLed(originalMatrix, ledPos));

                // Convert to equation string
                StringBuilder equation = new StringBuilder();
                for (char[][] matrix : newChars) {
                    equation.append(getCharacter(matrix));
                }

                // Check if equation is valid
                if (evaluateExpression(equation.toString())) {
                    return charPos + 1; // 1-based position
                }
            }
        }
        return -1; // No solution found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int n = Integer.parseInt(scanner.nextLine());
        String[] displayLines = new String[3];
        for (int i = 0; i < 3; i++) {
            displayLines[i] = scanner.nextLine();
        }

        // Find and print result
        int result = findFaultyLed(n, displayLines);
        System.out.println(result);

        scanner.close();
    }
}