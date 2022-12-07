// From the educative.io course "Grokking the Coding Interview".
// Pattern: Tree Depth First Search
// Problem: Binary Tree Path Sum (easy)
// Related LeetCode Problem: https://leetcode.com/problems/path-sum/

// Problem Statement:
// Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf 
// such that the sum of all the node values of that path equals ‘S’.

// Solution Description:
// For the recursive solution, we can avoid using a second method by subtracting the value
// of each node from the sum as we recurse the tree. If we end up on a leaf node with a sum of 0
// then we know we found a valid path to sum. Otherwise, we can return false as we did not find
// a valid path.
// The iterative solution uses a Stack.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

// Recursive Solution
// Time: O(n) in the worst-case to visit every node in the tree.
// Space: O(h) where h is the maximum height of the tree. 
// This is the maximum number of recursive calls that will exist on the stack at any one time.
// In the worst case, this will be O(n) if the tree is a LinkedList (a pure vertical tree).
public static boolean hasPath(TreeNode root, int sum) {
    // If the node is null, we did not find a valid path to sum.
    if (root == null) {
        return false;
    }

    // If we are on a leaf node and our remaining sum equals the value of the node, 
    // then we found a valid path to sum.
    if (root.left == null && root.right == null && sum - root.val == 0) {
        return true;
    }

    // Otherwise, continue to recursively traverse the tree.
    return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
}
