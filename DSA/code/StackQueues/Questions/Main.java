package StackQueues.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static StackQueues.Questions.GameOfTwoStacks.twoStacks;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        For Game of Two Stacks Driver Code
        int t = sc.nextInt();

        while(t >= 0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();

            List<Integer> a = new ArrayList<>(m);
            List<Integer> b = new ArrayList<>(n);


            for(int i = 0; i < m; i++){
                a.add(sc.nextInt());
            }

            for(int i = 0; i < n; i++){
                b.add(sc.nextInt());
            }
            t--;
            System.out.println(twoStacks(x,a,b));
        }
    }
}
