package demo;

/**
 *  如何打印出每个节点的左右子树各有多少节点？
 */
public class Tree6 {
    public int count(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        System.out.println("左子树有"+leftCount+"右子树有"+rightCount);
        return leftCount + rightCount + 1;
    }
}
