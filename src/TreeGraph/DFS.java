package TreeGraph;/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class DFS {
    public List<Integer> iterPreorder(final TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode current = stack.pop();
            list.add(current.val);
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        return list;
    }
    public  List<Integer> iterPostorder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode peekNode  = stack.peek();
            if (peekNode.right != null && pre != peekNode.right)
                root = peekNode.right;
            else{
                list.add(peekNode.val);
                pre = stack.pop();
            }

        }
        return list;
    }
    public List<Integer> iterInorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
    //Root L R
    public void preorder(TreeNode root){
        if (root == null)
            return;
        visit(root);
        preorder(root.left);
        preorder(root.right);
    }
    //L Root R
    public void inorder(TreeNode root){
        if (root == null)
            return;
        inorder(root.left);
        visit(root);
        inorder(root.right);
    }
    //L R Root
    public void postorder(TreeNode root){
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        visit(root);
    }

    private void visit(TreeNode root) {
        System.out.println(root.val);
    }

}
