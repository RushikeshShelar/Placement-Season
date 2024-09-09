package lambdaExpression;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctions {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i + 1);
        }

        arr.forEach((item) -> System.out.println(item * 2));

        Consumer<Integer> print2 = item -> System.out.println(item * 2);

        arr.forEach(print2);

        // Storing lambda Expression in reference Variables of Types Interfaces
        Operation sum = (a, b) -> a + b;
        Operation prod = (a, b) -> a * b;
        Operation sub = (a, b) -> a - b;


        LambdaFunctions fun = new LambdaFunctions();

        System.out.println(fun.operate(5,6,sub));
        System.out.println(fun.operate(5,6,prod));
        System.out.println(fun.operate(5,6,sum));

    }

    private int operate(int a, int b, Operation op) {
        return op.operation(a, b);
    }

}

interface Operation {
    int operation(int a, int b);
}
