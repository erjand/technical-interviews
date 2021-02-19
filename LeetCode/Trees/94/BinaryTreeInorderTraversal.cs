// LeetCode #94
// https://leetcode.com/problems/binary-tree-inorder-traversal/
//
// Given the root of a binary tree, return the inorder traversal of its nodes' values.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // The inorder traversal of a binary tree visits and processes the nodes in order of: Left, Parent, Right
 // Because the nodes are visited in sequential order from left to right we call it "inorder".
 // An inorder traversal is often the most commonly used tree traversal and if used on a BST will result in a sorted output.

 // Time: O(n)
 // Space: O(h) where h is the height of the tree.
public class Solution {
    public IList<int> InorderTraversal(TreeNode root) {
        List<int> valueList = new List<int>();
        if (root == null) return valueList;
        Traverse(root, valueList);
        return valueList;
    }

    public void Traverse(TreeNode node, List<int> valueList) {
        if (node.left != null) {
            Traverse(node.left, valueList);
        }
        
        valueList.Add(node.val);

        if (node.right != null) {
            Traverse(node.right, valueList);
        }
    }
}