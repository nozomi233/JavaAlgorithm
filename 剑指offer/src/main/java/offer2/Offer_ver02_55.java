package offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer_ver02_55 {
    static class BSTIterator {

        private int i = 0;
        private List<Integer> list = new ArrayList<>();

        public BSTIterator(TreeNode root) {

            inorder(root, list);

        }

        public int next() {
            return list.get(i++);
        }

        public boolean hasNext() {
            if (i < list.size()){
                return true;
            }
            return false;
        }

        private void inorder(TreeNode node, List<Integer> list){
            if (node == null){
                return;
            }
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }
    }


}
