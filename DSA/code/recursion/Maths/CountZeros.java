package recursion.Maths;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(count(300001910));
    }

    static int count(int n) {
        return helper(n, 0);
    }

    private static int helper(int n, int count) {
        if (n == 0) return count;

        if (n % 10 == 0) count++;

        return helper(n / 10, count);
    }
}
