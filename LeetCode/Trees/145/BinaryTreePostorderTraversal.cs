// LeetCode #145
// https://leetcode.com/problems/binary-tree-postorder-traversal/
//
// Given the root of a binary tree, return the postorder traversal of its nodes' values.

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

 // The postorder traversal of a binary tree visits and processes the nodes in order of: Left, Right, Parent.
 // Because the Parent node is visited last, it is "post".

 // Time: O(n)
 // Space: O(h) where h is the height of the tree.
public class Solution {
    public IList<int> PostorderTraversal(TreeNode root) {
        List<int> valueList = new List<int>();
        if (root == null) return valueList;
        Traverse(root, valueList);
        return valueList;
    }

    public void Traverse(TreeNode node, List<int> valueList) {
        if (node.left != null) {
            Traverse(node.left, valueList);
        }
        
        if (node.right != null) {
            Traverse(node.right, valueList);
        }

        valueList.Add(node.val);
    }
}