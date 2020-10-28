package TreeGraph;
import java.util.Stack;

public class clostestVal {
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre == null && target < root.val)return root.val;
            if(pre != null && pre.val <= target && target <= root.val){
                //found
                return (Math.abs(pre.val - target) < Math.abs(root.val - target)) ?  pre.val : root.val;
            }
            pre = root;
            root = root.right;
        }
        return pre.val;
    }
}
