package StriverSDESheet.Arrays1;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,4,3,0,0};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, n);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverse(nums, index, n);
    }

    static void reverse(int[] arr, int start, int end) {
        int n = end - start;

        for (int i = start; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
}
