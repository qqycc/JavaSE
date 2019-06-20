package com.qqy.tree;

/**
 * Author:qqy
 */
public class IsBalance {
    public boolean isBalance(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isBalance(root.left)){
            return false;
        }
        if(!isBalance(root.right)){
            return false;
        }
        return height(root.left)-height(root.right)<=1||height(root.left)-height(root.right)>=-1;
    }

    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return java.lang.Math.max(height(root.left),height(root.right))+1;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
