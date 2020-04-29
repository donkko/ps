package p124;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Dfs {
    int max;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        int maxIncludingRoot = getMaxSumFrom(root);

        return Math.max(this.max, maxIncludingRoot);
    }

    private int getMaxSumFrom(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val;
        }

        int maxIncludingMe = node.val;

        Integer leftMaxExcludingMe = null;
        if (node.left != null) {
            leftMaxExcludingMe = getMaxSumFrom(node.left);
            this.max = Math.max(this.max, leftMaxExcludingMe);
            maxIncludingMe = Math.max(maxIncludingMe, leftMaxExcludingMe + node.val);
        }

        Integer rightMaxExcludingMe = null;
        if (node.right != null) {
            rightMaxExcludingMe = getMaxSumFrom(node.right);
            this.max = Math.max(this.max, rightMaxExcludingMe);
            maxIncludingMe = Math.max(maxIncludingMe, rightMaxExcludingMe + node.val);
        }

        if (node.left != null && node.right != null) {
            this.max = Math.max(this.max, Math.max(maxIncludingMe, leftMaxExcludingMe + rightMaxExcludingMe + node.val));
        }
        return maxIncludingMe;
    }
}
