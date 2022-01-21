package io.github.spafka.leetcode.binarytree;

import io.github.spafka.leetcode.BTreePrinter;
import io.github.spafka.leetcode.TreeNode;

import java.io.IOException;
import java.util.Scanner;

/***
 * @see {https://www.javadevjournal.com/data-structure/avl-tree/}
 */
//AVL Tree Node
class AVLNode extends TreeNode<AVLNode> {
    int height;

    public AVLNode() {
        left = null;
        right = null;
        val = 0;
        height = 0;
    }

    public AVLNode(int n) {
        left = null;
        right = null;
        val = n;
        height = 0;
    }
}


class AVLTree {
    AVLNode root;

    public AVLTree() {
        root = null;
    }


    /**
     * @param avlNode
     * @return
     */
    private int height(AVLNode avlNode) {
        return avlNode == null ? -1 : avlNode.height;
    }

    /**
     * @param lHeight
     * @param rHeight
     * @return
     */
    private int max(int lHeight, int rHeight) {
        return lHeight > rHeight ? lHeight : rHeight;
    }

    /**
     * @param val
     */
    public void insert(int val) {
        root = insert(val, root);
    }


    /**
     * @param val
     * @param avlNode
     * @return
     */
    private AVLNode insert(int val, AVLNode avlNode) {
        if (avlNode == null) {
            avlNode = new AVLNode(val);
        } else if (val < avlNode.val) {
            avlNode.left = insert(val, avlNode.left);
            if (height(avlNode.left) - height(avlNode.right) == 2)
                if (val < avlNode.left.val)
                    // 递归的上层节点会触发此，本层不会触发
                    avlNode = righrRotation(avlNode);
                else
                    avlNode = leftRightRotation(avlNode);
        } else if (val > avlNode.val) {
            avlNode.right = insert(val, avlNode.right);
            if (height(avlNode.right) - height(avlNode.left) == 2)
                if (val > avlNode.right.val)
                    avlNode = leftRotation(avlNode);
                else
                    avlNode = rightLeftRotation(avlNode);
        } else
            ; // Duplicate; do nothing
        avlNode.height = max(height(avlNode.left), height(avlNode.right)) + 1;
        return avlNode;
    }


    /**
     * @param avlNode
     * @return
     */
    private AVLNode righrRotation(AVLNode avlNode) {
        AVLNode k1 = avlNode.left;
        avlNode.left = k1.right;
        k1.right = avlNode;
        avlNode.height = max(height(avlNode.left), height(avlNode.right)) + 1;
        k1.height = max(height(k1.left), avlNode.height) + 1;
        return k1;
    }


    /**
     * @param avlNode
     * @return
     */
    private AVLNode leftRotation(AVLNode avlNode) {
        AVLNode node = avlNode.right;
        avlNode.right = node.left;
        node.left = avlNode;
        avlNode.height = max(height(avlNode.left), height(avlNode.right)) + 1;
        node.height = max(height(node.right), avlNode.height) + 1;
        return node;
    }

    /**
     * left-right rotation
     *
     * @param avlNode
     * @return
     */
    private AVLNode leftRightRotation(AVLNode avlNode) {
        avlNode.left = leftRotation(avlNode.left);
        return righrRotation(avlNode);
    }

    /**
     * right-left rotation
     *
     * @param avlNode
     * @return
     */
    private AVLNode rightLeftRotation(AVLNode avlNode) {
        avlNode.right = righrRotation(avlNode.right);
        return leftRotation(avlNode);
    }

    /**
     * @return
     */
    public int countNodes() {
        return countNodes(root);
    }

    /**
     * @param avlNode
     * @return
     */
    private int countNodes(AVLNode avlNode) {
        if (avlNode == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(avlNode.left);
            l += countNodes(avlNode.right);
            return l;
        }
    }

    /**
     * @param val
     * @return
     */
    public boolean search(int val) {
        return search(root, val);
    }

    /**
     * @param avlNode
     * @param val
     * @return
     */
    private boolean search(AVLNode avlNode, int val) {
        boolean found = false;
        while ((avlNode != null) && !found) {
            int rval = avlNode.val;
            if (val < rval)
                avlNode = avlNode.left;
            else if (val > rval)
                avlNode = avlNode.right;
            else {
                found = true;
                break;
            }
            found = search(avlNode, val);
        }
        return found;
    }

    /**
     *
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * @param avlNode
     */
    private void inorder(AVLNode avlNode) {
        if (avlNode != null) {
            inorder(avlNode.left);
            System.out.print(avlNode.val + " ");
            inorder(avlNode.right);
        }
    }
}


public class AVLTreeHelper {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        AVLTree avlTree = new AVLTree();

        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(1);

        AVLNode root = avlTree.root;
        BTreePrinter.printNode(root);


        int a[]=new int[]{1,2,3,4,5};
         avlTree = new AVLTree();
        for (int i : a) {
            avlTree.insert(i);
            BTreePrinter.printNode(avlTree.root);
        }

        a=new int[]{7,8,9,10,1,2,3,4,5};
        avlTree = new AVLTree();
        for (int i : a) {
            avlTree.insert(i);
            BTreePrinter.printNode(avlTree.root);
        }

        char ch;
//        do {
//            System.out.println("\nAVLTree Operations\n");
//            System.out.println("1. insert ");
//            System.out.println("2. search");
//            System.out.println("3. count nodes");
//            System.out.println("4. print nodes");
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.println("Enter integer element to insert");
//                    avlTree.insert(scanner.nextInt());
//                    break;
//                case 2:
//                    System.out.println("Enter integer element to search");
//                    System.out.println("Search result : " + avlTree.search(scanner.nextInt()));
//                    break;
//                case 3:
//                    System.out.println("Nodes = " + avlTree.countNodes());
//                    break;
//                case 4:
//                    System.out.println("Nodes = ");
//                    BTreePrinter.printNode(avlTree);
//                    break;
//                default:
//                    System.out.println("Wrong Entry \n ");
//                    break;
//            }
//
//            System.out.print("\nIn order : ");
//            avlTree.inorder();
//
//            System.out.println("\nDo you want to continue (Type y or n) \n");
//            ch = scanner.next().charAt(0);
//        } while (ch == 'Y' || ch == 'y');
    }
}