package BinaryTree;

public class CountLeave {
    int countLeaves(Node node) 
    {
         if(node == null) return 0;
         if(node.left == null && node.right == null){
             return 1;
         }
         int ll = countLeaves(node.left);
         int rl = countLeaves(node.right);
         return ll + rl;
    }
}
