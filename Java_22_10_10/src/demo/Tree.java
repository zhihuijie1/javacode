package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历
 */
public class Tree {
    public void func1(TreeNode root){
        if (root == null) {
            return;
        }
        //  创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        //  先把队列的头给放进去
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 通过一个中间变量cur从而实现层序的构建
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            // 加入判断条件
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(! queue.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int size = queue.size();

            while(size > 0){
                TreeNode cur = queue.poll();
                list1.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                size--;
            }
            list.add(list1);
        }
        return list;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(size > 0){
                TreeNode cur = queue.poll();
                size--;
                temp.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            list.add(temp);
        }
        return list;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(size > 0){
                TreeNode cur = queue.poll();
                size--;
                temp.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            list.add(temp);
        }
        return list;
    }


    /**
     * 判断一个树是不是完全二叉树
     */
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == null){
                break;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        while(!queue.isEmpty()){
            if(queue.poll() != null){
                return false;
            }
        }
        return true;
    }
}










