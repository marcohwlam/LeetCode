package TreeGraph;/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    //pre order
    public static void bfs(final TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>(Collections.singleton(root));
        int levelNum = queue.size();
        while (!queue.isEmpty()) {
            for(int i =0; i < levelNum; i++){
                final TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                System.out.println(current.val);
            }
        }
    }
}
