package com.hhrb.leetcodecn.tool;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Z J Wu Date: 2020/1/27 Time: 18:05 Package: com.hhrb.leetcodecn.tool
 */
public class BinaryTreeNode<T> {

  public static final String PRINT_CONNECTOR = "|-";

  public static final void preOrderPrintTree(BinaryTreeNode root) {
    Stack<BinaryTreeNode> stack = new Stack<>();
    stack.push(root);
    BinaryTreeNode currentNode;
    while (stack.isNotEmpty()) {
      currentNode = stack.popValue();
      if (currentNode == root) {
        System.out.println("Root(" + currentNode.val + ")");
      } else if (currentNode.isLeft()) {
        System.out.println(StringUtils.repeat(" ",
                                              currentNode.layer - 1) + PRINT_CONNECTOR + "L:" + currentNode.val);
      } else {
        System.out.println(StringUtils.repeat(" ",
                                              currentNode.layer - 1) + PRINT_CONNECTOR + "R:" + currentNode.val);

      }
      if (currentNode.hasRight()) {
        stack.push(currentNode.rightChild);
      }
      if (currentNode.hasLeft()) {
        stack.push(currentNode.leftChild);
      }
    }
  }

  public static final <T> List<T> preOrderTraverse(BinaryTreeNode<T> root) {
    List<T> result = new ArrayList<>();
    Stack<BinaryTreeNode> storage = new Stack<>();
    storage.push(root);

    BinaryTreeNode<T> currentNode;
    // 因为是stack是后入先出因此需要先压右孩子
    while (storage.isNotEmpty()) {
      currentNode = storage.popValue();
      result.add(currentNode.val);
      if (currentNode.hasRight()) {
        storage.push(currentNode.rightChild);
      }
      if (currentNode.hasLeft()) {
        storage.push(currentNode.leftChild);
      }
    }
    return result;
  }

  public static final <T> List<T> inOrderTraverse(BinaryTreeNode<T> root) {
    List<T> result = new ArrayList<>();
    Stack<BinaryTreeNode> storage = new Stack<>();

    BinaryTreeNode<T> currentNode = root;
    while (currentNode != null || storage.isNotEmpty()) {
      while (currentNode != null) {
        storage.push(currentNode);
        currentNode = currentNode.leftChild;
      }
      currentNode = storage.popValue();
      result.add(currentNode.val);
      currentNode = currentNode.rightChild;
    }
    return result;
  }

  // todo 还没理解
  public static final <T> List<T> postOrderTraverse(BinaryTreeNode<T> root) {
    List<T> result = new ArrayList<>();
    Stack<BinaryTreeNode> storage = new Stack<>();

    BinaryTreeNode<T> currentNode = root;
    // 因为是stack是后入先出因此需要先压右孩子
    while (currentNode != null || storage.isNotEmpty()) {

    }
    return result;
  }

  public BinaryTreeNode<T> parent;
  public BinaryTreeNode<T> leftChild;
  public BinaryTreeNode<T> rightChild;
  public T val;
  public int layer;

  public BinaryTreeNode(T val) {
    this.val = val;
  }

  public void addLeft(T val) {
    addLeftNode(new BinaryTreeNode<>(val));
  }

  public void addLeftNode(BinaryTreeNode<T> node) {
    this.leftChild = node;
    this.leftChild.parent = this;
    this.leftChild.layer = this.layer + 1;
  }

  public void addRight(T val) {
    addRightNode(new BinaryTreeNode<>(val));
  }

  public void addRightNode(BinaryTreeNode<T> node) {
    this.rightChild = node;
    this.rightChild.parent = this;
    this.rightChild.layer = this.layer + 1;
  }

  public boolean isLeft() {
    return this.parent.leftChild == this;
  }

  public boolean isRight() {
    return this.parent.rightChild == this;
  }

  public boolean hasLeft() {
    return this.leftChild != null;
  }

  public boolean hasRight() {
    return this.rightChild != null;
  }

  public static void main(String[] args) {
    BinaryTreeNode<Integer> _0 = new BinaryTreeNode<>(0);
    BinaryTreeNode<Integer> _1 = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> _2 = new BinaryTreeNode<>(2);
    BinaryTreeNode<Integer> _3 = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> _4 = new BinaryTreeNode<>(4);
    BinaryTreeNode<Integer> _5 = new BinaryTreeNode<>(5);

    _0.addLeftNode(_1);
    _0.addRightNode(_2);
    _1.addLeftNode(_3);
    _1.addRightNode(_4);
    _2.addRightNode(_5);
    System.out.println(preOrderTraverse(_0));
    System.out.println(inOrderTraverse(_0));
    preOrderPrintTree(_0);
  }

}
