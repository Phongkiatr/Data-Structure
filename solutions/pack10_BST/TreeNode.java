package solutions.pack10_BST;

public class TreeNode {
    int data;
    TreeNode left, right, parent;
    public TreeNode(int d) {
    data = d;
    left = null;
    right = null;
    parent = null;
    }
    @Override
    public String toString() {
        String leftData = (left != null) ? String.valueOf(left.data) : "null";
        String rightData = (right != null) ? String.valueOf(right.data) : "null";
        return leftData + "<-" + data + "->" + rightData;
    }
}