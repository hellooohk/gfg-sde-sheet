package BinaryTree;

public class Height{

    private final int height(Node node) {
        if (node == null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }
    public static void main(String[] args) {
        
    }
}