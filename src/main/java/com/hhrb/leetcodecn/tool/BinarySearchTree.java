package com.hhrb.leetcodecn.tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * User: Z J Wu Date: 2020/1/28 Time: 19:33 Package: com.hhrb.leetcodecn.tool
 */
public class BinarySearchTree<T extends Comparable<T>> {

  public final BinaryTreeNode<T> root;

  public BinarySearchTree(BinaryTreeNode<T> root) {
    this.root = root;
  }

  public BinarySearchTree(T rootVal) {
    this(new BinaryTreeNode<>(rootVal));
  }

  public BinarySearchTree<T> addTreeNode(T val) {
    BinaryTreeNode<T> currentNode = root, childNode;
    while (currentNode != null) {
      T nodeVal = currentNode.val;
      // val > current
      if (val.compareTo(nodeVal) == 1) {
        childNode = currentNode.rightChild;
        if (childNode == null) {
          currentNode.addRight(val);
          break;
        } else {
          currentNode = childNode;
        }
      }
      // val < current
      else if (val.compareTo(nodeVal) == -1) {
        childNode = currentNode.leftChild;
        if (childNode == null) {
          currentNode.addLeft(val);
          break;
        } else {
          currentNode = childNode;
        }
      } else {
        return this;
      }
    }
    return this;
  }

  public static void main(String[] args) {
    Random random = new Random();
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(10);
    List<Integer> pool = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      pool.add(i);
    }
    for (int i = 0; i < 10; i++) {
      pool.add(11 + i);
    }
    Collections.shuffle(pool);
    for (int i = 0; i < 10; i++) {
      bst.addTreeNode(pool.get(i));
    }
    System.out.println(BinaryTreeNode.preOrderTraverse(bst.root));
    BinaryTreeNode.preOrderPrintTree(bst.root);
  }

}
