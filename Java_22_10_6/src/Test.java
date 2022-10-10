public class Test {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.creatTree();
        Tree tree = new Tree();
        int count = tree.getHeight(treeNode);
        System.out.println(count);
        System.out.println(tree.getHeight2(treeNode));
        TreeNode ret = tree.find(treeNode,2);
        System.out.println(ret);
        System.out.println(tree.find(treeNode,0));
        System.out.println(tree.find(treeNode,1));
    }
}
