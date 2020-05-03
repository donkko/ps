package p1430;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Dfs {
    int[] arr;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        this.arr = arr;
        return dfs(root, 0);
    }

    private boolean dfs(TreeNode node, int currentPosition) {
        if (currentPosition >= this.arr.length) {
            return false;
        }

        if (node == null) {
            return false;
        }

        if (node.val != this.arr[currentPosition]) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return currentPosition == this.arr.length - 1;
        } else {
            return dfs(node.left, currentPosition + 1) || dfs(node.right, currentPosition + 1);
        }
    }
}
