package CodeVita;

import java.util.*;

public class DanceRev {
    static String[] tiles = {"up", "down", "left", "right"};
    static Map<String, Integer> tileMap = new HashMap<>();

    static {
        for (int i = 0; i < tiles.length; i++) {
            tileMap.put(tiles[i], i);
        }
    }

    private static int solve(String[] instructions, int index, int leftFoot, int rightFoot, Integer[][][] dp) {
        if (index >= instructions.length) {
            return 0;
        }

        if (dp[index][leftFoot][rightFoot] != null) {
            return dp[index][leftFoot][rightFoot];
        }

        int target = tileMap.get(instructions[index]);

        if (leftFoot == target || rightFoot == target) {
            return dp[index][leftFoot][rightFoot] = solve(instructions, index + 1, leftFoot, rightFoot, dp);
        }

        int moveLeft = 1 + solve(instructions, index + 1, target, rightFoot, dp);
        int moveRight = 1 + solve(instructions, index + 1, leftFoot, target, dp);

        return dp[index][leftFoot][rightFoot] = Math.min(moveLeft, moveRight);
    }

    public static int minimumMoves(String[] instructions) {
        int n = instructions.length;
        int minMoves = Integer.MAX_VALUE;

        Integer[][][] dp = new Integer[n][4][4];

        for (int left = 0; left < 4; left++) {
            for (int right = 0; right < 4; right++) {
                if (left != right) {  // Feet can't be on same tile
                    minMoves = Math.min(minMoves,
                            solve(instructions, 0, left, right, dp));
                }
            }
        }
        return minMoves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        String[] instructions = new String[n];
        for (int i = 0; i < n; i++) {
            instructions[i] = sc.nextLine().trim();
        }

        int finalAns = minimumMoves(instructions);
        System.out.println(finalAns);
    }
}