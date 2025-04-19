package trees;

public class BST {
    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    BST() {
    }

    public int getHeight(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) return;

        System.out.println(details + node.getValue());

        display(node.left, "Left Child of " + node.getValue() + " : ");
        display(node.right, "Right Child of " + node.getValue() + " : ");
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (node.value < value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return node;
    }

    public void populate(int[] nums) {
        for (int value : nums) {
            this.insert(value);
        }
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        this.insert(nums[mid]);
        populateSorted(nums, 0, mid);
        populateSorted(nums, mid + 1, end);
    }

    public boolean isBalanced() {
        return balanced(root);
    }

    public boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void preOrder() {
        System.out.println("Pre Order: ");
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        System.out.println("\nIn Order: ");

        inOrder(this.root);
    }

    private void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        System.out.println("\nPost Order: ");

        postOrder(this.root);
    }

    private void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }


}
