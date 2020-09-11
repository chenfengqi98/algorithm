package com.leetcode.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : TODO
 * @Author : chen qi
 * @Date: 2020-09-07 19:09
 */
public class NaryTreeNode {
    public int val;
    public List<NaryTreeNode> children = new ArrayList<>();

    public NaryTreeNode() {
    }

    public NaryTreeNode(int _val) {
        val = _val;
    }

    public NaryTreeNode(int _val, List<NaryTreeNode> _children) {
        val = _val;
        children = _children;
    }

    public void addLast(NaryTreeNode treeNode) {
        this.children.add(treeNode);
    }

    public static NaryTreeNode getNaryTreeNode() {
        NaryTreeNode naryTreeNode = new NaryTreeNode(1);
        NaryTreeNode naryTreeNode1 = new NaryTreeNode(2);
        NaryTreeNode naryTreeNode2 = new NaryTreeNode(3);
        NaryTreeNode naryTreeNode3 = new NaryTreeNode(4);
        NaryTreeNode naryTreeNode4 = new NaryTreeNode(5);
        NaryTreeNode naryTreeNode5 = new NaryTreeNode(6);

        naryTreeNode2.children.add(naryTreeNode4);
        naryTreeNode2.children.add(naryTreeNode5);

        naryTreeNode.children.add(naryTreeNode2);
        naryTreeNode.children.add(naryTreeNode1);
        naryTreeNode.children.add(naryTreeNode3);

        return naryTreeNode;
    }
}
