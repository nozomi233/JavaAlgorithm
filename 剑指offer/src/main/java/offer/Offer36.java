package offer;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Offer36 {
    Node pre = null;
    Node head = null;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }

        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur){
        if (cur == null){
            return;
        }

        dfs(cur.left);
        // 中序
        if (pre == null){
            head = cur;
        } else {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;
        dfs(cur.right);
    }
}
