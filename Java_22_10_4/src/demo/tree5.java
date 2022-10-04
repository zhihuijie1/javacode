package demo;

/**
 * 把根节点看做第 1 层，如何打印出每一个节点所在的层数？
 */
public class tree5 {
    public void print(TreeNode root){
        traverse(root, 1);
    }

    void traverse(TreeNode root, int level){
        if(root == null){
            return;
        }
        System.out.println(level);
        traverse(root.left,level+1);
        traverse(root.right,level+1);
    }
}
