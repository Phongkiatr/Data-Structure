package solutions.pack10_BST;

import java.util.ArrayList;
import java.util.List;

public class BST {
    TreeNode root;
    public BST() { root = null; }
    public TreeNode getRoot() {
        return root;
    }
    int anscount = 0;
    public void insert(int d){
        if(root == null){
            root = new TreeNode(d);
            return;
        }
        TreeNode current = root;
        while (current != null) {
            if(d < current.data){
                if(current.left != null){
                    current = current.left;
                }else{
                    current.left = new TreeNode(d);
                    current.left.parent = current;
                    return;
                }
            }else{
                if(current.right != null){
                    current = current.right;
                }else{
                    current.right = new TreeNode(d);
                    current.right.parent = current;
                    return;
                }
            }
        }
    }
    public TreeNode search(int d){
        TreeNode current = root;
        while (current != null) {
            if (d == current.data) {
                return current;
            } else if (d < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }
    public void delete(int d) {
        root = deleteNode(root, d);
    }
    
    public TreeNode deleteNode(TreeNode node, int d) {
        if (node == null) {
            return null;
        }
        if (d < node.data) {
            node.left = deleteNode(node.left, d);
        } else if (d > node.data) {
            node.right = deleteNode(node.right, d);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                TreeNode maxLeft = findMaxFrom(node.left);
                node.data = maxLeft.data;
                node.left = deleteNode(node.left, maxLeft.data);
            }
        }
        return node;
    }
    private TreeNode findMaxFrom(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    public TreeNode findMin() {
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public TreeNode findMax() {
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }
    private void printInOrderRecurse(TreeNode node) {
        if (node == null) return ;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }
    public void printPreOrder(){
        printPostOrder(root);
        System.out.println();
    }
    public void printPreOrder(TreeNode node){
        if(node == null) return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    public void printPostOrder(){
        printPostOrder(root);
        System.out.println();
    }
    public void printPostOrder(TreeNode node){
        if(node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }
    public int count() {
        return countNodes(root);
    }
    
    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    public int height() {
        return Height(getRoot());
    }

    public int Height(TreeNode node_660572) {
        int height = 1;
        if (node_660572 == null) {
            return 0;
        }
        while (node_660572 != null) {
            height++;
            node_660572 = node_660572.left;
        }
        return height;
    }
    public int findMedian() {
        return findMedian(getRoot());
    }

    public int findMedian(TreeNode node) {
        ArrayList<Integer> arr = new ArrayList<>();
        BSTtostring(getRoot(), arr);
        System.out.println(arr);
        if (arr.size() % 2 == 0) {
            return ((arr.get(arr.size() / 2) - 1) + arr.get((arr.size() / 2))) / 2;
        }
        return arr.get((arr.size() / 2));
    }
    public void BSTtostring(TreeNode node, List<Integer> tmp) {
        if (node != null) {
            BSTtostring(node.left, tmp);
            tmp.add(node.data);
            BSTtostring(node.right, tmp);
        }
    }
    public int findRank(int d) {
        ArrayList<Integer> arr = new ArrayList<>();
        BSTtostring(getRoot(), arr);
        int count = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (d == arr.get(i)) {
                return count;
            } else {
                count++;
            }
        }
        return -1;
    }
}