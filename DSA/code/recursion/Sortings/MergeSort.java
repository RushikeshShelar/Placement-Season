package recursion.Sortings;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 6, 3, 4, 6, 8, 21, 10};

        System.out.println(Arrays.toString(mergeSort(arr)));

        System.out.println("BEFORE IN Place Sorting: " + Arrays.toString(arr));
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println("AFTER IN Place Sorting: " + Arrays.toString(arr));


    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length)); //It is Exclusive that why we Write Mid and not Mid + 1

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int firstPointer = 0;
        int secondPointer = 0;
        int mixPointer = 0;

        while (firstPointer < first.length && secondPointer < second.length) {
            if (first[firstPointer] < second[secondPointer]) {
                mix[mixPointer] = first[firstPointer];
                firstPointer++;
            } else {
                mix[mixPointer] = second[secondPointer];
                secondPointer++;
            }
            mixPointer++;
        }

        //        Only one of the following two loops will execute during a Problem
        //        Copy the Remaining Elements from first Array if any
        while (firstPointer < first.length) {
            mix[mixPointer] = first[firstPointer];
            firstPointer++;
            mixPointer++;
        }
        //        Copy the Remaining Elements from Second Array if any

        while (secondPointer < second.length) {
            mix[mixPointer] = second[secondPointer];
            secondPointer++;
            mixPointer++;
        }

        return mix;
    }


    static void mergeSortInPlace(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end); //It is Exclusive that why we Write Mid and not Mid + 1

        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];
        }
    }

}

