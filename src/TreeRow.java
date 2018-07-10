//import javax.swing.tree.TreeNode;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TreeRow {
//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        largestValues(root, 0, result);
//        return result;
//    }
//
//    private void largestValues(TreeNode root, int level, List<Integer> L){
//        if (root == null) return;
//        if(L.size() <= level)
//            L.add(root.val);
//        else
//            L.set(level, Math.max(root.val, L.get(level)));
//
//        largestValues(root.left, level+1, L);
//        largestValues(root.right, level+1, L);
//    }
//}
