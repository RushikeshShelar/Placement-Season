package question;

import java.util.ArrayList;

public class Question1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);

        list.add(null);

        list.add(null);


        list.add(null);

        list.add(10);
        list.add(50);
        list.add(15);
        list.add(5);
        list.add(null);
        list.add(-1);
        list.add(null);

        System.out.println(smallNum(list));
    }

    public static int smallNum(ArrayList<Integer> list){
        int small = Integer.MAX_VALUE;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == null)
                continue;

            small = list.get(i);
            break;

        }

        for(int i = 1; i < list.size(); i++){
            if(list.get(i) == null) continue;

            if(list.get(i) < small){
                small = list.get(i);
            }
        }

        return small;
    }
}
