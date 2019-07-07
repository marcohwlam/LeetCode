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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retList = new LinkedList<List<Integer>>();
        if(root == null) return retList;
        final Queue<TreeNode> queue = new LinkedList<>(Collections.singleton(root));
        TreeNode cur;
        boolean isOdd = true;
        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<Integer>();
            int width = queue.size();
            for(int i = 0; i < width; i++){
                cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if(isOdd) {
                    subList.add(cur.val);
                }else
                    subList.add(0, cur.val);
            }
            isOdd = isOdd ? false : true;
            retList.add(subList);
        }
        return retList;
    }
}
