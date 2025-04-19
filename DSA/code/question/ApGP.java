package question;

import static java.lang.Math.abs;

public class ApGP {
    // Given an array of N integers, check whether the array is in AP or GP.
    public static String findProgression(int[] arr) {
        if (arr.length < 2) {
            return "NOTHING"; // Not enough elements to determine progression
        }

        boolean isAp = true;
        boolean isGp = true;

        int apR = arr[1] - arr[0]; // Common difference for AP
        int gpR = (arr[0] != 0) ? arr[1] / arr[0] : 0; // Common ratio for GP (avoid division by zero)

        for (int i = 1; i < arr.length - 1; i++) {
            int currentDiff = arr[i + 1] - arr[i];
            // Check for division by zero before calculating the ratio
            int currentRatio = (arr[i] != 0) ? arr[i + 1] / arr[i] : 0;

            if (currentDiff != apR) {
                isAp = false;
            }
            if (currentRatio != gpR) {
                isGp = false;
            }
        }

        // Determine the result based on flags
        if (isAp && isGp) return "AP/GP"; // In case it's both (like 1, 1, 1)
        if (isAp) return "AP";
        if (isGp) return "GP";
        return "NOTHING";
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5}; // AP
        int[] arr2 = {2, 4, 8, 16}; // GP
        int[] arr3 = {1, 3, 2}; // NOT AP or GP
        int[] arr4 = {1, 1, 1}; // Both AP and GP

        System.out.println(findProgression(arr1)); // Output: AP
        System.out.println(findProgression(arr2)); // Output: GP
        System.out.println(findProgression(arr3)); // Output: NOTHING
        System.out.println(findProgression(arr4)); // Output: AP/GP
    }
}
