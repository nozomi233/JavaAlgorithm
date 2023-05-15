package offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author zhulang
 * @Date 2023-05-15
 **/
public class Offer56_2 {
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null){
            return false;
        }

        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        int left = 0;
        int right = inorderList.size() - 1;
        while (left < right){
            int sum = inorderList.get(left) + inorderList.get(right);
            if (k == sum){
                return true;
            } else if (k > sum){
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void inorder(TreeNode root, List<Integer> inorderList){
        if (root == null){
            return;
        }

        inorder(root.left, inorderList);

        inorderList.add(root.val);

        inorder(root.right, inorderList);
    }


    Set<Integer> set = new HashSet<Integer>();

    public boolean findTarget2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget2(root.left, k) || findTarget2(root.right, k);
    }



    public static void main(String[] args) {
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(6);
        head.right = new TreeNode(10);

        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(7);

        head.right.left = new TreeNode(9);
        head.right.right = new TreeNode(11);

        System.out.println(findTarget(head, 12));

    }
}
