package recursion.Sortings;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 6, 7, 8, 9, 99, 10, 22, 18 };
        sort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int size, int currentIndex, int maxIndex) {
        if (size == 0) {
            return;
        }

        if (currentIndex < size) {
            if (arr[currentIndex] > arr[maxIndex]) {
                sort(arr, size, currentIndex + 1, currentIndex);
            } else {
                sort(arr, size, currentIndex + 1, maxIndex);
            }
        } else {
            swap(arr, size - 1, maxIndex);
            sort(arr, size - 1, 0, 0);
        }

    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
