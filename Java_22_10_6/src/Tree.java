public class Tree {
    /**
     * 获取二叉树的高度
     * @param root
     * @return
     */
    //子问题方法：求出左子树的高度和右子树的高度，算出最大值，然后加1。
    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftCount = getHeight(root.left);
        int rightCount = getHeight(root.right);
        int max = leftCount > rightCount ? leftCount : rightCount;
        return max + 1;
    }
    //遍历的方法
    static int size = 0;
    int max = 0;
    int getHeight2(TreeNode root){
        if(root == null){
            return 0;
        }
        size++;
        getHeight2(root.left);
        getHeight2(root.right);
        if(root.left == null && root.right == null){
            if(size > max){
                max = size;
            }
        }
        size--;
        return max;

    }

    /**
     * 检测值为value的元素是否存在
     * @param root
     * @param val
     * @return
     */
    TreeNode ret = null;
    TreeNode find(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode ret = find(root.left , val);
        if(ret != null){
            return ret;
        }
        TreeNode ret2 = find(root.left , val);
        if(ret2 != null){
            return ret2;
        }
        return null;
    }


    /**
     * 另一棵树的子树
     * 思路：
     * 先找value，
     * 找到value之后然后分析结构是不是一样，
     * 再分析val是不是一样
     * 先找左子树，左子树如果找到了就不用找右子树了。
     */
    /*
    * public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }

    }
    * */
}






















