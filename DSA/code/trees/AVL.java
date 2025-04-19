package trees;

public class AVL {
    static class Node {
        private int height;
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
            this.height = 1;
        }

    }

    AVL() {

    }

    private Node root;

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    //    Insert Function with balancing
    public void insert(int value) {
        this.root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (node.value < value) {
            node.right = insert(value, node.right);
        } else {
            throw new IllegalArgumentException("Duplicate value: " + value + " is not allowed in the AVL Tree.");
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        int balance = getHeight(node.left) - getHeight(node.right);
//        System.out.println("Node value: " + node.value + ", Balance: " + balance);


// Left heavy case (balance > 1)
        if (balance > 1) {
            // Determine if it's left-left or left-right case
            if (getHeight(node.left.left) >= getHeight(node.left.right)) {
                // Left-left case
                return rightRotate(node);
            }
            // Left-right case
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right heavy case (balance < -1)
        if (balance < -1) {
            // Determine if it's right-right or right-left case
            if (getHeight(node.right.right) >= getHeight(node.right.left)) {
                // Right-right case
                return leftRotate(node);
            }
            // Right-left case
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    //    Rotation Functions
    private Node leftRotate(Node c) {
//        System.out.println("Performing left rotation on node: " + c.value);
        Node p = c.right;
        Node t2 = p.left;

        p.left = c;
        c.right = t2;

        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;

        return p;
    }

    private Node rightRotate(Node p) {
//        System.out.println("Performing right rotation on node: " + p.value);
        Node c = p.left;
        Node t2 = c.right;

        c.right = p;
        p.left = t2;

        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;

        return c;
    }

    //    Display Function
    public void display() {
        if (this.isEmpty()) {
            System.out.println("Tree is Empty");
            return;
        }
        display(this.root, "Root node: ");

    }

    private void display(Node node, String details) {
        if (node == null) return;

        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + ": ");
        display(node.right, "Right child of " + node.value + ": ");

    }

    //    Populate Function to insert an Array of Data in tree
    public void populate(int[] arr) {
        for (int value : arr) {
            this.insert(value);
        }
    }

    public boolean isBalanced() {
        return isBalanced(this.root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) return true;

        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }
}