import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树非递归的后序遍历
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

public class Tree {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null ) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            cur = top.right;
            if(cur == null) {
                list.add(stack.pop().val);
                cur = stack.peek().right;
            }
        }
    }

}
















