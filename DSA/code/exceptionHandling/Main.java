package exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try{
            throw new MyCustomException("My Custom Exception");
        }catch (ArithmeticException | MyCustomException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.print("Always Runs Finally Block");
        }


    }

    static int divide(int a, int b){
        if(b == 0){
            throw new ArithmeticException("Please do not Divide by Zero");
        }
        return  a/b;
    }
}
