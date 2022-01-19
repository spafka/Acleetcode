package io.github.spafka.leetcode;


public class TreeNode<N extends TreeNode>  {
    public int val;
    public N left;
    public N right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }




}
