package recursion.Searching;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 5, 7, 8, 9, 13 };

        System.out.println(search(arr, 5, 0)); //Return Boolean
        System.out.println(searchIndex(arr, 5, 0)); // Return Index
        System.out.println(searchIndexLast(arr, 5, arr.length - 1)); // Return index from Last

        searchAllIndex(arr, 5, 0);
        System.out.println(ans); //Return All Possible Indexes by making a Global ArrayList

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(searchAllIndex2(arr, 5, 0, list)); //Return All Possible Indexes by Passing Arraylist as Parameter

        System.out.println(searchAllIndex3(arr, 5, 0)); //Return All Possible Indexes by not passing Arraylist as Parameter or Creating a Global Arraylist
    }

    // Boolean Search
    static boolean search(int[] arr, int target, int index) {
        if (index == arr.length)
            return false;

        return arr[index] == target || search(arr, target, index + 1);
    }

    // Index Search
    static int searchIndex(int[] arr, int target, int index) {
        if (index == arr.length)
            return -1;

        if (arr[index] == target)
            return index;

        return searchIndex(arr, target, index + 1);
    }

    // Index Search from Last
    static int searchIndexLast(int[] arr, int target, int index) {
        if (index == -1)
            return -1;

        if (arr[index] == target)
            return index;

        return searchIndexLast(arr, target, index - 1);
    }

    // Make Arrayslist Globally and Update it to find all Indexes of Target Element
    static ArrayList<Integer> ans = new ArrayList<>();

    static void searchAllIndex(int[] arr, int target, int index) {
        if (index == arr.length)
            return;

        if (arr[index] == target)
            ans.add(index);

        searchAllIndex(arr, target, index + 1);
    }

    // Use Arrayslist as parameter and Not Globally
    static ArrayList<Integer> searchAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length)
            return list;

        if (arr[index] == target)
            list.add(index);

        return searchAllIndex2(arr, target, index + 1, list);
    }

    // Return the List/ArrayList Without passing it as Argument
    static ArrayList<Integer> searchAllIndex3(int[] arr, int target, int index) {

        ArrayList<Integer> list = new ArrayList<>();

        if (index == arr.length)
            return list;

        // List Will Contain the answer for the Current Function Call only
        if (arr[index] == target)
            list.add(index);

        ArrayList<Integer> ansFromBelowCalls = searchAllIndex3(arr, target, index + 1);

        list.addAll(ansFromBelowCalls);

        return list;
    }
}
