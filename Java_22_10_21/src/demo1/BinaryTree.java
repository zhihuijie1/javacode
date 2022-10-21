package demo1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现二叉树的基本操作
 */
public class BinaryTree {
 
    static class TreeNode {
        public char val;
        public TreeNode left;//左孩子的引用
        public TreeNode right;//右孩子的引用
 
        public TreeNode(char val) {
            this.val = val;
        }
    }
 
 
    /**
     * 创建一棵二叉树 返回这棵树的根节点
     *
     * @return
     */
    public TreeNode createTree() {
        TreeNode root = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        return root;
    }
 
    // 前序遍历
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
 
    // 中序遍历
    void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.val + " ");
        preOrder(root.right);
    }
 
    // 后序遍历
    void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + " ");
    }
 
    public static int nodeSize;
 
    /**
     * 获取树中节点的个数：遍历思路
     */
    void size(TreeNode root) {
        if(root == null) {
            return;
        }
        nodeSize++;
        size(root.left);
        size2(root.right);
    }
 
    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */
    int size2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int liftCount = size2(root.left);
        int rightCount = size2(root.right);
        return liftCount+rightCount+1;
    }
 
 
    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;
 
    void getLeafNodeCount1(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
    }
 
    /*
     获取叶子节点的个数：子问题
     */
    int getLeafNodeCount2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftCount = getLeafNodeCount2(root.left);
        int rightCount = getLeafNodeCount2(root.right);
        return leftCount+rightCount;
    }
 
    /*
    获取第K层节点的个数
     */
    int getKLevelNodeCount(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        int leftCount = getKLevelNodeCount(root.left, k-1);
        int rightCount = getKLevelNodeCount(root.right, k-1);
        return leftCount+rightCount;
    }
 
    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    int getHeight(TreeNode root) {
       if(root == null) {
           return 0;
       }
       if(root.left == null && root.right == null) {
           return 1;
       }
       int leftDepth = getHeight(root.left);
       int rightDepth = getHeight(root.right);
       int maxDepth = leftDepth>rightDepth? leftDepth: rightDepth;
       return maxDepth+1;
    }
 
 
    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, char val) {
        if(root == null) {
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode leftNode = find(root.left, val);
        if(leftNode != null) {
            return leftNode;
        }
        TreeNode rightNode = find(root.right, val);
        return rightNode;

    }
 
    //层序遍历
    void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val+" ");
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
 
 
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null){
                break;
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }
        while(!queue.isEmpty()) {
            if(queue.poll() !=  null){
                return false;
            }
        }
        return true;
    }
}