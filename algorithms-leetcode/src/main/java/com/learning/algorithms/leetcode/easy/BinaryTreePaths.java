package com.learning.algorithms.leetcode.easy;

import com.learning.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 16/6/6.
 * LeetCode 257
 * Question:https://leetcode.com/problems/binary-tree-paths/
 * 关键题设：return all root-to-leaf paths
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }

    /**
     * 深度优先遍历
     * 递归,先访问左子节点,再访问右子节点
     * 递归的终结条件:左右子节点均为空
     * 注意根节点为空的检查
     */
    public class BinaryTreePaths0 extends BinaryTreePaths {
        private List<String> result = new ArrayList<String>();

        @Override
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return result;
            searchPath(root, "");
            return result;
        }

        private void searchPath(TreeNode currentNode, String path) {
            //左右节点都为空,该节点为子节点
            if (currentNode.left == null && currentNode.right == null) {
                result.add(path + currentNode.val);
                return;
            }

            String current = currentNode.val + "->";

            if (currentNode.left != null) {
                searchPath(currentNode.left, path + current);
            }
            if (currentNode.right != null) {
                searchPath(currentNode.right, path + current);
            }

        }

    }

}
