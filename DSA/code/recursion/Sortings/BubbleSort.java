package recursion.Sortings;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 6, 5, 4, 7, 2, 1, 9, 10 };
        sort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int size, int index) {
        if (size == 0) {
            return;
        }

        if (index < size) {
            if (arr[index] > arr[index + 1]) {
                // Swap
                int temp = arr[index];
                arr[index] = arr[index + 1];
                arr[index + 1] = temp;
            }
            sort(arr, size, index + 1);
        } else {
            sort(arr, size - 1, 0);
        }
    }
}
