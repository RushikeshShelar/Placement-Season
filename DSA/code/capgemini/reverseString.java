package capgemini;

import java.util.Arrays;

public class reverseString {
    public static void main(String[] args) {
//        System.out.println(reverse("cba"));
//        System.out.println(maxInArr(new int[]{1, 2, 3, 4, 5, 6, 78, 9, 100}));
//        System.out.println(isPalindrome(11));
        System.out.println(factorial(6));
    }


    static String reverse(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = str[i];
            str[i] = str[len - i - 1];
            str[len - i - 1] = temp;
        }

        return String.valueOf(str);
    }

    static int maxInArr(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    static boolean isPalindrome(int num) {
        int og = num;

        int sum = 0;

        while (num > 0) {
            int rem = num % 10;
            sum = sum * 10 + rem;
            num /= 10;
        }

        return og == sum;
    }

    static int factorial(int num){
        int fact = 1;
        if(num == 0){
            return 1;
        }
        for(int i = 1; i <= num; i++){
            fact *= i;
        }
        return fact;
    }
}
