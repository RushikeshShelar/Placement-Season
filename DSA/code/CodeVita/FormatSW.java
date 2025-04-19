package CodeVita;

import java.util.*;

public class FormatSW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        int n = Integer.parseInt(sc.nextLine().trim());  // Number of matrices
        String[] rc = sc.nextLine().trim().split(" ");
        int r = Integer.parseInt(rc[0]);  // Rows per matrix
        int c = Integer.parseInt(rc[1]);  // Columns per matrix

        // Step 2: Read the rows of all matrices
        List<List<Integer>> allRows = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            List<Integer> row = new ArrayList<>();
            String[] rowData = sc.nextLine().trim().split(" ");
            for (String val : rowData) {
                row.add(Integer.parseInt(val));
            }
            allRows.add(row);
        }

        // Step 3: Create matrices by splitting the allRows into n matrices
        List<List<List<Integer>>> matrices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> matrix = new ArrayList<>();
            for (List<Integer> row : allRows) {
                List<Integer> matrixRow = row.subList(i * c, (i + 1) * c);
                matrix.add(new ArrayList<>(matrixRow));
            }
            matrices.add(matrix);
        }

        // Step 4: Read instructions
        List<List<Integer>> instructions = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            String[] indices = line.split(" ");
            List<Integer> instruction = new ArrayList<>();
            for (String idx : indices) {
                instruction.add(Integer.parseInt(idx));
            }
            instructions.add(instruction);
        }

        // Step 5: Process instructions and print output
        List<String> result = new ArrayList<>();

        // For each instruction
        for (List<Integer> line : instructions) {
            // For each row (from 0 to r-1)
            for (int i = 0; i < r; i++) {
                List<Integer> rowResult = new ArrayList<>();
                for (int idx : line) {
                    List<List<Integer>> matrix = matrices.get(idx - 1);  // Accessing the matrix (1-based index)
                    rowResult.addAll(matrix.get(i));  // Add the ith row of the matrix
                }

                // Add the result for this row to the final output
                result.add(String.join(" ", rowResult.stream().map(String::valueOf).toArray(String[]::new)));
            }
        }

        // Print all results line by line
        System.out.println(String.join("\n", result));

        sc.close();
    }
}
