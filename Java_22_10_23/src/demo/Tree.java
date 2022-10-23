package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */

/**
 * 方法一：
 */
public class Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        getPath(root,p,stack1);
        getPath(root,q,stack2);

        int size1 = stack1.size();
        int size2 = stack2.size();

        if(size1 - size2 > 0) {
            int size = size1 - size2;
            //把多余的部分弹出来
            while(size > 0) {
                stack1.pop();
                size--;
            }
            while(stack1.peek() != stack2.peek()) {
                stack1.pop();
                stack2.pop();
            }
            return stack1.peek();
        }else {
            int size = size2 - size1;
            while(size > 0) {
                stack2.pop();
                size--;
            }
            while(stack1.peek() != stack2.peek()) {
                stack1.pop();
                stack2.pop();
            }
            return stack1.peek();
        }
    }
    //寻找节点的路径并将其压入栈中
    public boolean getPath(TreeNode root, TreeNode cur, Stack<TreeNode> stack) {
        if(root == null) {
            return false;
        }
        stack.push(root);
        if(root.val == cur.val) {
            return true;
        }
        boolean leftBolean = getPath(root.left,cur,stack);
        if(leftBolean) {
            return true;
        }
        boolean rightBolean = getPath(root.right,cur,stack);
        if(rightBolean) {
            return true;
        }
        stack.pop();
        return false;
    }
    /**
     * 方法二：
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        //有两种情况：1：分居根节点的两侧 2：一个在根节点一个不在根节点或者都在根节点
        //注意：一个在根节点一个不在根节点 (一个在上边一个在下边) ，在子树找的时候会返回在上边的节点
        if(p == root || q == root) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor1(root.left , p ,q);
        TreeNode rightNode = lowestCommonAncestor1(root.right , p ,q);

        if(leftNode != null && rightNode != null) {
            return root;
        }
        //如果都在一侧的话，根据第二条if语句，可知会找到在上面的节点并返回
        if(leftNode == null && rightNode != null) {
            return rightNode;
        }
        if (rightNode == null && leftNode != null){
            return leftNode;
        }
        //输入的数据在本二叉树中没有
        if(leftNode == null && rightNode == null) {
            return null;
        }
        return null; //不起什么作用
    }

    /**
     * 二叉树的后序遍历  递归实现
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }
    /**
     * 二叉树的中序遍历  非递归实现
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            list.add(top.val);
            cur = top.right;
        }
        return list;
    }

    /**
     * 从中序与后序遍历构造二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    int valIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        valIndex = postorder.length-1;
        return build(inorder,0,inorder.length-1,postorder);
    }
    public TreeNode build(int[] inorder,int begI,int endI,int[] postorder) {
        if(begI > endI) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[valIndex]);

        //找到根节点在中序遍历中所对应的下标
        int index = -1;
        for (int i = begI; i <= endI; i++) {
            if(inorder[i] == postorder[valIndex]) {
                index = i;
                break;
            }
        }
        if(index < 0) {
            return null;
        }

        valIndex--;//后序遍历指向下一个节点
        root.right = build(inorder,index+1, endI,postorder);

        root.left = build(inorder,begI, index-1,postorder);

        return root;
    }

    /**
     * 二叉树的后序非递归
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right == null || cur.right == prev) {
                res.add(cur.val);
                prev = cur;
                cur = null;
            } else {
                stack.push(cur);
                cur = cur.right;
            }
        }
        return res;
    }

    /**
     * 二叉树的后序非递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right == null || cur.right == prev) {
                list.add(cur.val);
                prev = cur;
                cur = null;

            } else {
                stack.push(cur);
                cur = cur.right;
            }
        }
        return list;
    }

}













