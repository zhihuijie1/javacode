package demo;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * 遍历的方法
 */
public class Tree3 {
    LinkedList<Integer> list = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
