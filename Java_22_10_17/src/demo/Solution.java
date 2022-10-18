package demo;
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


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bulid(preorder, inorder, 0, inorder.length-1);
    }
    int preI = 0;
    public TreeNode bulid(int[] preorder, int[] inorder, int begI, int endI) {
        if(begI > endI){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preI]);
        preI++;
        int rootIdex = find(inorder, begI, endI, root.val);
        if(rootIdex == -1) {
            return null;
        }
        //注意下标会不会错开
        root.left = bulid(preorder, inorder, begI, rootIdex - 1);

        root.right = bulid(preorder, inorder, rootIdex + 1, endI);


        return root;
    }

    public int find(int[] inorder, int begI, int endI, int val) {
        for(int i = begI; i <= endI; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}


















