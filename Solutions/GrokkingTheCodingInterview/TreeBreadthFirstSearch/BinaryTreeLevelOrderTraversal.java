// From the educative.io course "Grokking the Coding Interview".
// Pattern: Tree Breadth First Search
// Problem: Binary Tree Level Order Traversal (easy)
// Related LeetCode Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/

// Problem Statement:
// Given a binary tree, populate an array to represent its level-by-level traversal. 
// You should populate the values of all nodes of each level from left to right in separate sub-arrays.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// Time: O(n) where n is the number of nodes in the tree.
// Space: O(n) where n is the number of nodes in the tree.
public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    if (root == null) {
        return result;
    }

    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    nodeQueue.offer(root);

    while (!nodeQueue.isEmpty()) {
        int levelNodeCount = nodeQueue.size();
        List<Integer> levelList = new ArrayList<Integer>();
        
        // Process all the nodes in this level.
        for (int i = 0; i < levelNodeCount; i++) {
            TreeNode currentNode = nodeQueue.poll();
            levelList.add(currentNode.val);
            
            if (currentNode.left != null) {
                nodeQueue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                nodeQueue.offer(currentNode.right);
            }
        }
        
        result.add(levelList);
    }

    return result;
}
