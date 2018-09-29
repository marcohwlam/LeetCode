public class PreInnerBuildTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
//Pre Root L R
//Inner L Root R
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,preorder.length - 1, preorder,inorder );
    }
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length - 1 || inStart > inEnd )return null;
        TreeNode ret = new TreeNode(preorder[preStart]);
        int indexOfRootInIner = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == ret.val) {
                indexOfRootInIner = i;
            }
        }
        //base case
        ret.left = helper(preStart + 1, inStart, indexOfRootInIner - 1, preorder, inorder);
        ret.right = helper(preStart + indexOfRootInIner - inStart + 1, indexOfRootInIner + 1, inEnd, preorder, inorder );
        return ret;
    }

}
