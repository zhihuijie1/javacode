import javax.swing.tree.TreeNode;

public class BanarySearch {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode root = null;

    // 二叉树的查找
    public boolean search(int val) {
        TreeNode cur = root;
        while(cur != null) {
            if(val < cur.val) {
                cur = cur.left;
            }else if(val > cur.val) {
                cur = cur.right;
            }else {
                return true;
            }
        }
        return false;
    }
    public TreeNode search2(TreeNode root,int val) {
        if(root == null) {
            return null;
        }
        if(val < root.val) {
            return search2(root.left,val);
        }else if(val > root.val) {
            return search2(root.right,val);
        }else {
            return root;
        }
    }

    /**
     * 二叉树之插入一个元素
     * 不可以插入相同的元素
     */
    public boolean insert(int key) {
        if(root == null) {
            root = new TreeNode(key);
            return true;
        }
        TreeNode cur = root;
        while(true) {
            if(key < cur.val) {
                cur = cur.left;
                if(cur == null) {
                    TreeNode prev = new TreeNode(key);
                    cur = prev;
                    return true;
                }
        }else if(key > cur.val) {
                cur = cur.right;
                if(cur == null) {
                    TreeNode prev = new TreeNode(key);
                    cur = prev;
                    return true;
                }
            }else {
                return false;
            }
        }
    }
    public boolean insert2(int key) {
        if(root == null) {
            root = new TreeNode(key);
            return true;
        }
        TreeNode p = null;
        TreeNode cur = root;
        while(cur != null) {
            if(cur.val < key) {
                p = cur;
                cur = cur.right;
            }else if(cur.val > key) {
                p = cur;
                cur = cur.left;
            }else {
                return false;
            }
        }
        if(key > p.val) {
            p.right = new TreeNode(key);
        }else {
            p.left = new TreeNode(key);
        }
        return true;
    }
}
