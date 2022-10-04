package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最大深度
 */
public class Tree1 {
    int res = 0;//最大深度
    int depth = 0; //遍历到的节点的深度
    //主函数
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    //二叉树的遍历框架
    public void traverse (TreeNode root){
        if(root == null){
            return;
        }
        depth++;
        traverse(root.left);
        traverse(root.right);
        if(root.left == null && root.right == null){
            res = Math.max(res,depth);
        }
        depth--;
    }
}
