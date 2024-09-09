package recursion.Questions;

import java.util.ArrayList;

public class NumberOfDiceRolls {
    public static void main(String[] args) {

//        diceRolls("", 6);

        diceFaces("", 4, 3);

//        System.out.println(diceRollsArr("", 12));

//        System.out.println(dieRollsCount("", 12));
    }

    static void diceRolls(String processed, int target) {
        if (target == 0) {
            System.out.println(processed);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            diceRolls(processed + i, target - i);
        }
    }

    static ArrayList<String> diceRollsArr(String processed, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= target; i++) {
            ans.addAll(diceRollsArr(processed + i, target - i));
        }

        return ans;
    }

    static void diceFaces(String processed, int target, int face) {
        if (target == 0) {
            System.out.println(processed);
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            diceFaces(processed + i, target - i, face);
        }
    }


    static int dieRollsCount(String processed, int target) {
        if (target == 0) {
            return 1;
        }

        int count = 0;

        for (int i = 1; i <= 6 && i <= target; i++) {
            count += dieRollsCount(processed + i, target - i);
        }

        return count;
    }
}
