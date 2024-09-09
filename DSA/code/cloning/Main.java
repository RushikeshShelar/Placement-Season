package cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Humans rushi = new Humans(21,"Rushi");
//        Humans twin = new Humans(rushi);

        Humans twin = (Humans)rushi.clone();
        System.out.println(twin.age + " " + twin.name);

        twin.arr[0] = 100;
        System.out.println(Arrays.toString(rushi.arr));
        System.out.println(Arrays.toString(twin.arr));

    }

}
