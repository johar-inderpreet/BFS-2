//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: The idea is to check at the parent level, if both x and y are its children or not
//if they are, they are not cousins
//also, if they are not at the same depth, they cannot be cousins
public class CousinsInBinaryTree {

    private boolean flag;
    private int depthX, depthY;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.flag = true;
        dfs(root, 0, x, y);
        if (!this.flag) return false;
        return depthX == depthY;
    }

    private void dfs(TreeNode root, int depth, int x, int y) {
        if (root == null || !flag) return;

        if (root.val == x) depthX = depth;
        if (root.val == y) depthY = depth;

        if (root.left != null && root.right != null) {
            if (root.left.val == x && root.right.val == y) this.flag = false;
            if (root.left.val == y && root.right.val == x) this.flag = false;
        }

        dfs(root.left, depth + 1, x, y);
        dfs(root.right, depth + 1, x, y);
    }

    public static void main(String[] args) {
        final CousinsInBinaryTree cousins = new CousinsInBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        System.out.println(cousins.isCousins(root, 4, 3)); //return false

        root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), null));
        System.out.println(cousins.isCousins(root, 5, 4)); //return true

        root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        System.out.println(cousins.isCousins(root, 2, 3)); //return false
    }
}
