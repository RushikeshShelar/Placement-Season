package CodeVita;

import java.util.*;

public class Potions {
    public static Map<String, List<List<String>>> recipe = new HashMap<>();

    public static Map<String, Integer> dpTable = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < l; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("=");

            String potionName = parts[0];
            String[] items = parts[1].split("\\+");

            if (recipe.get(potionName) == null) {
                recipe.put(potionName, new ArrayList<>());
            }
            recipe.get(potionName).add(Arrays.asList(items));

        }
        String target = sc.nextLine().trim();
        int ans = minOrbs(target);
        System.out.println(ans);
    }

    public static int minOrbs(String targetPotion) {
        if (!recipe.containsKey(targetPotion)) {
            return 0;
        }

        if (dpTable.containsKey(targetPotion)) {
            return dpTable.get(targetPotion);
        }

        int ans = Integer.MAX_VALUE;

        for (List<String> arr : recipe.get(targetPotion)) {
            int orbs = arr.size() - 1;

            for (String item : arr) {
                orbs += minOrbs(item);
            }

            ans = Math.min(ans, orbs);
            dpTable.put(targetPotion, ans);

        }
        return ans;
    }
}