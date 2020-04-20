package p1008;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Recursion {
    int[] preorder;
    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        this.preorder = preorder;

        return returnNodeIfPossible(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode returnNodeIfPossible(int lowerLimit, int upperLimit) {
        if (idx >= preorder.length) return null;
        if (preorder[idx] <= lowerLimit) return null;
        if (preorder[idx] >= upperLimit) return null;

        var node = new TreeNode(preorder[idx]);
        idx++;
        node.left = returnNodeIfPossible(lowerLimit, node.val);
        node.right = returnNodeIfPossible(node.val, upperLimit);

        return node;
    }
}
