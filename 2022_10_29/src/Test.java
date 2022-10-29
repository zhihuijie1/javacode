import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一棵二叉搜索树的root，请你 按中序遍历
 * 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
 * 并且每个节点没有左子节点，只有一个右子节点。
 *
 * 来源：力扣（LeetCode）
 */
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
public class Test {
    public TreeNode increasingBST4(TreeNode root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNode> arr = increasingBST2(root);
        TreeNode res = arr.peek();
        while(!arr.isEmpty()) {
            TreeNode cur = arr.poll();
            cur.right = arr.peek();
            cur.left = null;
        }
        return res;
    }

    public Queue<TreeNode> increasingBST2(TreeNode root) {
        //对二叉树进行中序遍历
        if(root == null) {
            return null;
        }
        Queue<TreeNode> list = new LinkedList<>();
        increasingBST2(root.left);
        list.add(root);
        increasingBST2(root.right);
        return list;
    }

    // 输入一棵 BST，返回一个有序「链表」
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 先把左右子树拉平
        TreeNode left = increasingBST(root.left);
        root.left = null;
        TreeNode right = increasingBST(root.right);
        root.right = right;
        // 左子树为空的话，就不用处理了
        if (left == null) {
            return root;
        }
        // 左子树非空，需要把根节点和右子树接到左子树末尾
        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        p.right = root;
        return left;
    }



    public TreeNode increasingBST(TreeNode root) {

        Queue<TreeNode> arr = increasingBST2(root);
        TreeNode res = arr.peek();
        while(!arr.isEmpty()) {
            TreeNode cur = arr.poll();
            cur.right = arr.peek();
            cur.left = null;
        }
        return res;
    }

    public Queue<TreeNode> increasingBST2(TreeNode root) {
        //对二叉树进行中序遍历
        if(root == null) {
            return null;
        }
        Queue<TreeNode> list = new LinkedList<>();
        increasingBST2(root.left);
        list.add(root);
        increasingBST2(root.right);
        return list;
    }




    //题解正确的解答
    
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            tincrease(list,root);
            TreeNode cur1 = new TreeNode(-1);
            TreeNode cur2 = cur1;
            for(int value : list) {
                cur2.right = new TreeNode(value);
                cur2 = cur2.right;
            }
            return cur1.right;
        }
        void tincrease(List<Integer> list, TreeNode root) {
            if(root == null) {
                return;
            }
            tincrease(list,root.left);
            list.add(root.val);
            tincrease(list,root.right);
        }
    }
}













