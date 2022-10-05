package demo;

public class Test {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.creatTree();
        Tree tree = new Tree();
        int temp = tree.getLeafNodeCount2(treeNode);
        System.out.println(temp);
    }
}
