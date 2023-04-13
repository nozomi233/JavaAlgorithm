package com.offer.zl;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhulang
 * @Date 2023-03-05
 **/
public class Offer07 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        Map<Integer,Integer> indexMap = new HashMap<>();

        public TreeNode build(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
            if(preorder_left > preorder_right){
                return null;
            }
            int preorder_root = preorder_left;
            int inorder_root = indexMap.get(preorder[preorder_root]);
            int sub_left_length = inorder_root - inorder_left;

            TreeNode root = new TreeNode(preorder[preorder_root]);
            root.left = build(preorder, inorder, preorder_left + 1, preorder_left + sub_left_length, inorder_left, inorder_root - 1);
            root.right = build(preorder, inorder, preorder_left + sub_left_length + 1, preorder_right, inorder_root + 1, inorder_right);
            return root;

        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            for(int i = 0; i < n; i++){
                indexMap.put(inorder[i], i);
            }
            return build(preorder, inorder, 0, n-1, 0, n-1);
        }
    }
}
