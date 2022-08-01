package BinaryTree;

public class Node {
    public Node left;
    public Node right;
    private Node value;

    Node(Node left, Node right, Node value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public void setLeft(Node left) { this.left = left; } 
}
