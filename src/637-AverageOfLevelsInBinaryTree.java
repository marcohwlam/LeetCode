/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> retList = new LinkedList<Double>();
        if(root == null) return retList;
        final Queue<TreeNode> queue = new LinkedList<>(Collections.singleton(root));
        TreeNode cur;
        while(!queue.isEmpty()){
            int width = queue.size();
            Double sum = 0.0;
            for(int i = 0; i < width; i++){
                cur = queue.poll();
                sum += cur.val;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }        
            retList.add(sum/width);
        }
        return retList;
    }
}
