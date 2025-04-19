package trees;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();

        BST tree = new BST();
        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        Arrays.sort(nums);
        tree.populate(nums);
        System.out.println(tree.isBalanced());


        AVL avl = new AVL();
        for(int i = 0; i < 1000; i++){
            avl.insert(i);
        }
        System.out.println(avl.getHeight());
        System.out.println(avl.isBalanced());
    }
}
