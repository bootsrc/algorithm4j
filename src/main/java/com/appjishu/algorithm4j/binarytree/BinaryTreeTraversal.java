package com.appjishu.algorithm4j.binarytree;

/**
 * 二叉树的先序遍历，中序遍历，后序遍历的递归实现
 * 对于左，根，右
 * 先序遍历： 根最先， 根->左->右
 * 中序遍历： 跟在中间,  左->根 -> 右
 * 后序遍历:  根在最后,   左->右->根
 */
public class BinaryTreeTraversal {
    /**
     * @author yaobo
     * 二叉树的先序中序后序排序
     */
    public Node init() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;   //返回根节点
    }

    public void printNode(Node node) {
        System.out.print(node.getData());
    }

    public void thePreTraversal(Node root) {  //先序遍历
        printNode(root);
        if (root.getLeftNode() != null) {  //使用递归进行遍历左孩子
            thePreTraversal(root.getLeftNode());
        }
        if (root.getRightNode() != null) {  //递归遍历右孩子
            thePreTraversal(root.getRightNode());
        }
    }

    public void theMidOrderTraversal(Node root) {  //中序遍历
        if (root.getLeftNode() != null) {
            theMidOrderTraversal(root.getLeftNode());
        }
        printNode(root);
        if (root.getRightNode() != null) {
            theMidOrderTraversal(root.getRightNode());
        }
    }


    public void thePostOrderTraversal(Node root) {  //后序遍历
        if (root.getLeftNode() != null) {
            thePostOrderTraversal(root.getLeftNode());
        }
        if (root.getRightNode() != null) {
            thePostOrderTraversal(root.getRightNode());
        }
        printNode(root);
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        Node root = tree.init();
        System.out.println("先序遍历");
        tree.thePreTraversal(root);
        System.out.println("");
        System.out.println("中序遍历");
        tree.theMidOrderTraversal(root);
        System.out.println("");
        System.out.println("后序遍历");
        tree.thePostOrderTraversal(root);
        System.out.println("");
    }
}
