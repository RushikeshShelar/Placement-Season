package trees;

import javax.swing.plaf.basic.BasicScrollBarUI;
import java.io.PrintStream;
import java.util.Scanner;

public class BinaryTree {

    public BinaryTree() {

    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    //   Insert Elements
    public void populate(Scanner scanner) {
        System.out.println("Enter the Root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do You want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the Value to the Left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do You want to enter right of " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the Value to the Right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        if (root == null) {
            System.out.println("Tree is Empty:");
            return;
        }
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay() {
        if (root == null) {
            System.out.println("Tree is Empty:");
            return;
        }
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) return;

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("\t\t");
            }
            System.out.println("|----->" + node.value);

        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }
}
