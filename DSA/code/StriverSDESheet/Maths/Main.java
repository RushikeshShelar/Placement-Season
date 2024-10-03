package StriverSDESheet.Maths;

public class Main {

    //  1. https://www.geeksforgeeks.org/problems/count-digits5716/1
    static int evenlyDivides(int N) {
        // code here
        int count = 0;
        int num = N;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) {
                num /= 10;
                continue;
            }

            if (N % digit == 0) count++;
            num /= 10;
        }
        return count;
    }

    //    2. https://www.geeksforgeeks.org/problems/lcm-and-gcd4516/1
    static Long[] lcmAndGcd(Long A, Long B) {
        // code here
        Long X = A;
        Long Y = B;
        while (Y != 0) {
            Long temp = Y;
            Y = X % Y;
            X = temp;
        }

        Long gcd = X;
        Long lcm = (A * B) / gcd;

        return new Long[]{lcm, gcd};
    }

    //    3. https://leetcode.com/problems/palindrome-number/
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;

        int original = x;
        int reversed = 0;

        while (x > 0) {
            int lastDigit = x % 10;
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }

        if (original == reversed) return true;

        return false;
    }

    //    4. https://leetcode.com/problems/reverse-integer/description/
    public static int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

//    5. Armstrong Number https://leetcode.com/problems/armstrong-number/description/ (premium)

    public static boolean isArmstrong(int n) {

        if (n == 0) return true;

        int digits = (int) Math.log10(n) + 1;

        int original = n;

        int sum = 0;
        while (n != 0) {
            int remainder = n % 10;
            sum = (int) (sum + Math.pow(remainder, digits));
            n /= 10;
        }

        return original == sum;
    }


    //    6. https://www.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n4738/1
    static long sumOfDivisors(int N) {
        // code here
        long totalSum = 0;

        // Iterate through each number from 1 to N
        for (int i = 1; i <= N; i++) {
            // For each i, add i to the sum of all its multiples
            for (int j = i; j <= N; j += i) {
                totalSum += i;
            }
        }

        return totalSum;
    }

    //    7. Is Prime
    static boolean isPrime(int n) {
        // Handle edge cases
        if (n <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        if (n <= 3) {
            return true; // 2 and 3 are prime numbers
        }

        if (n % 2 == 0) {
            return false; // Exclude even numbers
        }

        // Check for odd divisors from 3 to sqrt(n)
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) { // Increment by 2 to check only odd numbers
            if (n % i == 0) {
                return false; // Found a divisor, n is not prime
            }
        }
        return true; // No divisors found, n is prime
    }

}

