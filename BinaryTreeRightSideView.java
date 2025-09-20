//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: This problem is the same as the traditional level order traversal
//but from right to left, we will only put the first element on that level (right most) in the output
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        final List<Integer> output = new ArrayList<>();
        if (root == null) return output;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                final TreeNode current = queue.poll();
                if (i == 0) output.add(current.val);

                if (current.right != null) queue.offer(current.right);
                if (current.left != null) queue.offer(current.left);
            }
        }

        return output;
    }
}
