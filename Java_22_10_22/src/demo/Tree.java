package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
public class Tree {
    /**
     * 另一棵树的子树
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }
        if(isSameTree(root, subRoot)) {
            return true;
        }
        boolean leftB = isSubtree( root.left,  subRoot);
        if(leftB) {
            return true;
        }
        boolean rightB = isSubtree( root.right,  subRoot);
        return rightB;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree( p.left,  q.left) && isSameTree( p.right,  q.right);
    }

    /**
     * 平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(getHeight(root.left)-getHeight(root.right)) >1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int lefH = getHeight(root.left);
        int rigH = getHeight(root.right);
        int max = lefH > rigH ? lefH : rigH;
        return max + 1;

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.isEmpty()) {
            List<Integer> list2 = new ArrayList<>();
            int size = queue.size();
            while(size>0) {
                TreeNode cur = queue.poll();
                size--;
                list2.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(0,list2);
        }
        return list;
    }
}
