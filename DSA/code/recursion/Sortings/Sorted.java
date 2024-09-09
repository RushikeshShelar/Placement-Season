package recursion.Sortings;

public class Sorted {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 5, 7, 8, 9, 13 };
        System.out.println(isSorted(arr, 0));
    }

    static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1)
            return true;

        return arr[index] <= arr[index + 1] && isSorted(arr, index + 1);
    }
}
