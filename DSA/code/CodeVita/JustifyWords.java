package CodeVita;

import java.util.Scanner;

public class JustifyWords {
    static int result = 0;
    static int[] memo;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = input.nextInt();
        input.nextLine();

        String[] text = new String[total];
        int[] size = new int[total];

        for (int idx = 0; idx < total; idx++) {
            text[idx] = input.nextLine();
            size[idx] = text[idx].length();
        }

        sortTexts(text, size, total);

        int rows = input.nextInt();
        int cols = input.nextInt();

        memo = new int[1 << total];
        for (int i = 0; i < (1 << total); i++) {
            memo[i] = -1;
        }

        boolean[] used = new boolean[total];
        int available = total;

        int possible = calculateMax(rows, cols, total, size);
        processTexts(text, size, rows, cols, used, 0, 0, 0, available, possible);
        System.out.println(result);
    }

    private static void processTexts(String[] text, int[] size, int rows, int cols, boolean[] used, int row, int len, int count, int available, int possible) {
        result = Math.max(result, count);

        if (row >= rows || count + available <= result || count >= possible) {
            return;
        }

        int state = getState(used);
        if (memo[state] >= count) {
            return;
        }
        memo[state] = count;

        for (int idx = 0; idx < text.length; idx++) {
            if (used[idx]) continue;

            int newLen = len == 0 ? size[idx] : len + 1 + size[idx];
            if (newLen <= cols) {
                used[idx] = true;
                available--;

                processTexts(text, size, rows, cols, used, row, newLen, count + 1, available, possible);

                if (row < rows - 1) {
                    processTexts(text, size, rows, cols, used, row + 1, 0, count + 1, available, possible);
                }

                used[idx] = false;
                available++;
            }
        }

        if (len > 0 && row < rows - 1) {
            processTexts(text, size, rows, cols, used, row + 1, 0, count, available, possible);
        }
    }

    private static int getState(boolean[] used) {
        int state = 0;
        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                state |= (1 << i);
            }
        }
        return state;
    }

    private static void sortTexts(String[] text, int[] size, int total) {
        for (int i = 0; i < total; i++) {
            int minIdx = i;
            for (int j = i + 1; j < total; j++) {
                if (size[j] < size[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tempSize = size[i];
                size[i] = size[minIdx];
                size[minIdx] = tempSize;

                String tempText = text[i];
                text[i] = text[minIdx];
                text[minIdx] = tempText;
            }
        }
    }

    private static int calculateMax(int rows, int cols, int total, int[] size) {
        int minLen = Integer.MAX_VALUE;
        for (int s : size) {
            minLen = Math.min(minLen, s);
        }

        int space = rows * cols;
        int maxWords = space / (minLen + 1) + 1;
        return Math.min(maxWords, total);
    }
}