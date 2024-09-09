package recursion.Maths;

class Fibo {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(fiboFormula(i));
        }
    }

    static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
    static long fiboFormula(int n) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        
        long ans = (long)((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n))
                / Math.sqrt(5));
        return ans;
    }
}