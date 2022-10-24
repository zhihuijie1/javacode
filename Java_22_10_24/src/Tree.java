import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.Stack;

public class Tree {
    /**
     * 不同的二叉搜索树的个数
     */
    public int numTrees(int n) {
        if(n == 1 || n == 0) {
            return 1;
        }
        int[] elem = new int[n];
        for (int i = 1; i <= n; i++) {
            elem[i-1] = i;
        }
        int size = 0;
        for (int i = 0; i < n; i++) {
            int begI = 0;
            int endI = elem.length - 1;
            size = size + find(elem, i ,begI,endI);
        }
        return size;
    }
    public int find(int[] elem, int index, int begI, int endI) {
        int left = -1;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = begI; i < index; i++) {
            left = i;
            leftCount += find(elem,left,begI,index-1);
        }
        int right = -1;
        for (int i = index+1; i <= endI; i++) {
            right = i;
            rightCount += find(elem,right,index+1,endI);
        }
        if(leftCount == 0 && rightCount != 0) {
            return rightCount;
        }
        if(rightCount == 0 && leftCount != 0) {
            return leftCount;
        }
        if(rightCount != 0 && leftCount != 0) {
            return rightCount * leftCount;
        }
        return 0;
    }


    int[][] elem;
    public int numTrees2(int n) {
        if(n == 0) {
            return 1;
        }
        elem = new int[n+1][n+1];
        return count(1,n);
    }
    public int count(int begI,int endI) {
        if(begI > endI) {
            return 1;
        }
        //查找备忘录
        if(elem[begI][endI] != 0) {
            return elem[begI][endI];
        }
        int size = 0;
        for (int i = begI; i <= endI; i++) {
            int left = count(begI,i-1);
            int right = count(i+1,endI);
            size += left * right;
        }
        // 将结果存入备忘录
        elem[begI][endI] = size;

        return size;
    }

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
    /**
     * 求二叉树的坡度
     */
    int size = 0;
    public int findTilt(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftCount = sum(root.left);
        int rightCount = sum(root.right);
        int count = Math.abs(leftCount - rightCount);
        size+=count;
        findTilt(root.left);
        findTilt(root.right);
        return size;

    }
    public int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum+rightSum+root.val;
    }

    /**
     * 叶子相似的树
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        putLeaives(root1,stack1);
        putLeaives(root2,stack2);
        if(stack1.size() != stack2.size()) {
            return false;
        }else{
            while(!stack1.isEmpty()) {
                int nub1 = stack1.pop();
                int nub2 = stack2.pop();
                if(nub1 != nub2) {
                    return false;
                }
            }
            return true;
        }
    }
    public boolean putLeaives(TreeNode root, Stack<Integer> stack) {
        if(root ==null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            stack.push(root.val);
            return true;
        }
        putLeaives(root.left,stack);
        putLeaives(root.right,stack);
        return true;
    }


}









