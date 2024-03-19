package offer;

import java.util.HashMap;
import java.util.Map;

public class JZ07 {

    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param preOrder int整型一维数组
     * @param vinOrder int整型一维数组
     * @return TreeNode类
     */
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
        int n = preOrder.length;

        for (int i = 0; i < n; i++){
            map.put(vinOrder[i], i);
        }

        return buildMyTree(preOrder, vinOrder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildMyTree(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight){
        if (preLeft > preRight){
            return null;
        }

        int rootVal = preOrder[preLeft];

        int inRootIndex = map.get(rootVal);

        int subLeftLen = inRootIndex - inLeft;

        TreeNode root = new TreeNode(rootVal);

        root.left = buildMyTree(preOrder, inOrder, preLeft + 1, preLeft + subLeftLen, inLeft, inRootIndex - 1);

        root.right = buildMyTree(preOrder, inOrder, preLeft + subLeftLen + 1, preRight, inRootIndex + 1, inRight);


        return root;


    }
}
