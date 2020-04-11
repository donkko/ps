package p543;

public class DFS {
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);

        return result;
    }

    private int traverse(TreeNode node) {
        if (node == null) return 0;

        int edgeCountOfLeft = traverse(node.left);
        int edgeCountOfRight = traverse(node.right);

        if (edgeCountOfLeft + edgeCountOfRight > result) {
            result = edgeCountOfLeft + edgeCountOfRight;
        }

        return Math.max(edgeCountOfLeft, edgeCountOfRight) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
