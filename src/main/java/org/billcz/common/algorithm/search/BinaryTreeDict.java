package org.billcz.common.algorithm.search;

import org.billcz.common.algorithm.util.Set;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/26
 */
public class BinaryTreeDict<K extends Comparable<? super K>, V> implements SortDict<K, V> {
    private Node root;

    public void put(K k, V v) {
        if (v == null) {
            remove(k);
            return;
        }

        root = add(root, k, v);
    }

    public V get(K k) {
        return get(root, k);
    }

    public K getFirst() {
        Node min = min(root);
        return min == null ? null : min.k;
    }

    public K getLast() {
        Node max = max(root);
        return max == null ? null : max.k;
    }

    public void remove(K k) {
        root = remove(root, k);
    }

    public boolean containsKey(K k) {
        return get(k) != null;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null ||  root.size == 0;
    }

    public Set<K> Keys() {
        return null;
    }

    private class Node {
        private K k;
        private V v;
        private int size;
        private Node left;
        private Node right;

        public Node(K k, V v, int size, Node left, Node right) {
            this.k = k;
            this.v = v;
            this.size = size;
            this.left = left;
            this.right = right;
        }
    }

    private Node add(Node node, K k, V v) {
        if (node == null) return new Node(k, v, 1, null, null);
        int cmp = k.compareTo(node.k);
        if (cmp > 0) node.right = add(node.right, k, v);
        else if (cmp < 0) node.left = add(node.left, k, v);
        else node.v = v;
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private V get(Node node , K k) {
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
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

}
