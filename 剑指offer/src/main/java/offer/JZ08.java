package offer;

public class JZ08 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null){
            return null;
        }

        if (pNode.right != null) {
            return rightChildMostLeft(pNode.right);
        } else {
            TreeLinkNode parent = pNode.next;
            while (parent != null && parent.left != null){
                pNode = parent;
                parent = pNode.next;
            }
            return parent;
        }
    }

    private TreeLinkNode rightChildMostLeft(TreeLinkNode node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
