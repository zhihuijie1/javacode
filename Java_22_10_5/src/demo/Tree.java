package demo;

public class Tree {

    /**
     *           获取叶子节点的个数
     */
    //遍历的方法
    int size = 0;
    int getLeafNodeCount(TreeNode root){
        if(root == null){
            return 0;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        if(root.left == null && root.right == null){
            size++;
        }
        return size;
    }
    //子问题的方法

    /**
     * 思路：刚上来：头节点叶子的个数：是左子树叶子的个数 + 右子树叶子的个数
     * 递归
     */
    int getLeafNodeCount2(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftCont = getLeafNodeCount2(root.left);
        int rightCount = getLeafNodeCount2(root.right);

        /**
         * 不是叶子节点的话，就返回左子树的叶子数与右子树叶子数的和
         */
        return leftCont + rightCount;
    }

    /**
     * 获取第K层节点的个数
     * @param root
     * @return
     */
    //遍历的方法
    public static int depth = 0;
    public static int sizes = 0;
    int getKLevelNodeCount(TreeNode root, int k){
        if(root == null){
            //     楼梯往上走
            return 0;
        }
        depth++;
        if(depth == k){
            sizes++;
            depth--;
            return sizes;
        }
        //     楼梯往下走
        getKLevelNodeCount(root.left, k);
        getKLevelNodeCount(root.right, k);
        depth--;
        //     楼梯往上走
        return sizes;
    }

    //子问题的方法

    /**
     * 左子树当中K节点的个数 + 右子树当中K节点的个数
     */
    public static int dep = 0;
    int getKLevelNodeCount2(TreeNode root, int k){
        if(root == null){
            return 0;
        }
        dep++;
        if(dep == k){
            dep--;
            return 1;
        }
        //     楼梯往下走
        int leftCount = getKLevelNodeCount2(root.left, k);
        int rightCount = getKLevelNodeCount2(root.right, k);
        dep--;
        return leftCount + rightCount;
    }

    //子问题的方法  方法二
    public static int s = 0;
    int getKLevelNodeCount3(TreeNode root, int k){
        if(root == null ){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        int leftCount = getKLevelNodeCount3(root.left , k-1); //注意K-1
        int rightCount = getKLevelNodeCount3(root.right , k-1);
        return leftCount + rightCount;
    }
}
