package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * 问题分解的方法
 */
public class Tree4 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();//放在里面，否则自己没法给自己addAll
        //合理的使用类型
        if(root == null){
            return list;
        }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }
}
