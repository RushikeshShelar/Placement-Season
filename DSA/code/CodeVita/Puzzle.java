package CodeVita;

import java.util.*;

public class Puzzle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input
        String equation1 = scanner.nextLine().trim();
        String equation2 = scanner.nextLine().trim();
        int R = Integer.parseInt(scanner.nextLine().trim());

        // Parse coefficients and constraints
        int[] coeffs1 = parseEquation(equation1);
        int[] coeffs2 = parseEquation(equation2);
        int N1 = Integer.parseInt(equation1.split("<=")[1].trim());
        int N2 = Integer.parseInt(equation2.split("<=")[1].trim());

        int lowLimit  = Math.min(N1,N2);

        // Maps to store results and their corresponding variable combinations
        Map<Integer, Set<List<Integer>>> results1 = new HashMap<>();
        Map<Integer, Set<List<Integer>>> results2 = new HashMap<>();

        // Generate all possible combinations for equation 1
        for (int x = 0; x <= R; x++) {
            for (int y = 0; y <= R - x; y++) {
                for (int z = 0; z <= R - x - y; z++) {
                    int remainingSum = R - x - y - z;
                    for (int w = 0; w <= remainingSum; w++) {
                        // Check if sum constraint is satisfied
                        if (x + y + z + w <= R) {
                            // Calculate result for equation 1
                            int result = coeffs1[0] * x + coeffs1[1] * y + coeffs1[2] * z + coeffs1[3] * w;
                            if (result <= lowLimit) {
                                results1.computeIfAbsent(result, k -> new HashSet<>())
                                        .add(Arrays.asList(x, y, z, w));
                            }
                        }
                    }
                }
            }
        }

        // Generate all possible combinations for equation 2
        for (int x = 0; x <= R; x++) {
            for (int y = 0; y <= R - x; y++) {
                for (int z = 0; z <= R - x - y; z++) {
                    int remainingSum = R - x - y - z;
                    for (int w = 0; w <= remainingSum; w++) {
                        // Check if sum constraint is satisfied
                        if (x + y + z + w <= R) {
                            // Calculate result for equation 2
                            int result = coeffs2[0] * x + coeffs2[1] * y + coeffs2[2] * z + coeffs2[3] * w;
                            if (result <= lowLimit) {
                                results2.computeIfAbsent(result, k -> new HashSet<>())
                                        .add(Arrays.asList(x, y, z, w));
                            }
                        }
                    }
                }
            }
        }

        // Find common results between both equations
        Set<Integer> commonResults = new HashSet<>(results1.keySet());
        commonResults.retainAll(results2.keySet());


        // Print the count of common results
        System.out.println(commonResults.size());

        scanner.close();
    }

    // Helper function to parse the coefficients from the equation
    public static int[] parseEquation(String equation) {
        int[] coeffs = new int[4];  // Coefficients for x, y, z, w
        String[] parts = equation.split("<=");
        String lhs = parts[0].trim();

        Arrays.fill(coeffs, 0);

        String[] terms = lhs.split("(?=[+-])");
        for (String term : terms) {
            term = term.trim();
            if (term.contains("x")) {
                coeffs[0] = extractCoefficient(term);
            } else if (term.contains("y")) {
                coeffs[1] = extractCoefficient(term);
            } else if (term.contains("z")) {
                coeffs[2] = extractCoefficient(term);
            } else if (term.contains("w")) {
                coeffs[3] = extractCoefficient(term);
            }
        }

        return coeffs;
    }


    // Helper function to extract coefficient from a term
    public static int extractCoefficient(String term) {
        if (term.equals("x") || term.equals("y") || term.equals("z") || term.equals("w")) {
            return 1;
        } else if (term.equals("-x") || term.equals("-y") || term.equals("-z") || term.equals("-w")) {
            return -1;
        } else {
            term = term.replaceAll("[a-zA-Z]", "").trim();
            return Integer.parseInt(term);
        }
    }
}