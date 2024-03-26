package offer;

import java.util.HashMap;
import java.util.List;

public class JZ02 {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree (int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0){
            return null;
        }


        int n = preOrder.length;
        for (int i = 0; i < n; i++){
            map.put(inOrder[i], i);
        }

        return buildMyTree(preOrder, inOrder, 0, n - 1, 0, n - 1);

    }

    public TreeNode buildMyTree(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight){
        if (preLeft > preRight){
            return null;
        }

        int rooVal = preOrder[preLeft];
        int rootInOrderIndex = map.get(rooVal);
        int subTreeLeftLen = rootInOrderIndex - inLeft;
        TreeNode root = new TreeNode(rooVal);

        root.left = buildMyTree(preOrder, inOrder, preLeft + 1, preLeft + subTreeLeftLen, inLeft, rootInOrderIndex - 1);
        root.right = buildMyTree(preOrder, inOrder, preLeft + subTreeLeftLen + 1, preRight, rootInOrderIndex + 1, inRight);
        return root;
    }
}
