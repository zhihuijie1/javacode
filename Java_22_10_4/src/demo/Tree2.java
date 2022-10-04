package demo;

/**
 * 二叉树的最大深度
 */
public class Tree2 {
    int res;
    int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        res = Math.max(leftMax,rightMax) + 1;
        return res;
    }
}
