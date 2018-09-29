package org.billcz.common.algorithm.search;

import org.billcz.common.algorithm.util.Set;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/27
 */
public class BalanceBinaryTreeDict<K extends Comparable<? super K>, V> implements SortDict<K, V> {
    private Node root;

    public void put(K k, V v) {
        if (v == null) {
            remove(k);
            return;
        }

        root = put(root, k , v);
    }

    public V get(K k) {
        return get(root, k);
    }

    public void remove(K k) {
        root = remove(root, k);
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null || root.size == 0;
    }

    public Set<K> Keys() {
        return null;
    }

    public boolean containsKey(K k) {
        return get(k) != null;
    }

    public K getFirst() {
        Node min = min(root);
        return min == null ? null : min.k;
    }

    public K getLast() {
        Node max = max(root);
        return max == null ? null : max.k;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    private Node put(Node node , K k, V v) {
        if (node == null) return new Node(k, v, 1, 0, null, null);
        int cmp = k.compareTo(node.k);
        if (cmp > 0) node.right = put(node.right, k, v);
        else if (cmp < 0) node.left = put(node.left, k , v);
        else {
            node.v = v;
            return node;
        }

        node.size = 1 + size(node.left) + size(node.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private V get(Node node, K k) {
        if (node == null) return null;
        int cmp = k.compareTo(node.k);
        if (cmp > 0) return get(node.right, k);
        else if (cmp < 0) return get(node.left, k);
        else return node.v;
    }

    private Node remove(Node node, K k) {
        if (node == null) return null;
        int cmp = k.compareTo(node.k);
        if (cmp > 0) node.right = remove(node.right, k);
        else if (cmp < 0) node.left = remove(node.left, k);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }

        node.size = 1 + size(node.left) + size(node.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));

        return balance(node);
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.left) + size(node.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }


    private Node balance(Node node) {
        if (balanceFactor(node) < -1) {
            if (balanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        } else if (balanceFactor(node) > 1) {
            if (balanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        }

        return node;
    }

    private class Node {
        private K k;
        private V v;
        private int size;
        private int height;
        private Node left;
        private Node right;

        public Node(K k, V v, int size, int height, Node left, Node right) {
            this.k = k;
            this.v = v;
            this.size = size;
            this.height = height;
            this.left = left;
            this.right = right;
        }
    }

}
