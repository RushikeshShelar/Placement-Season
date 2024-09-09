package recursion.Strings;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {

        permutations("", "abcde");

        ArrayList<String> ans = permutationsArr("", "abcde");
        System.out.println(ans);

        System.out.println(permutationsCount("","abcde"));



    }

    static void permutations(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char ch = unProcessed.charAt(0);

        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);

            permutations(first + ch + second, unProcessed.substring(1));
        }
    }

    static ArrayList<String> permutationsArr(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unProcessed.charAt(0);

        ArrayList<String> ans = new ArrayList<>();


        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);

            ans.addAll(permutationsArr(first + ch + second, unProcessed.substring(1)));
        }

        return ans;
    }

    static int permutationsCount(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            return 1;
        }

        char ch = unProcessed.charAt(0);
        int count = 0;

        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);

            count += permutationsCount(first + ch + second, unProcessed.substring(1));
        }

        return count;
    }

}
