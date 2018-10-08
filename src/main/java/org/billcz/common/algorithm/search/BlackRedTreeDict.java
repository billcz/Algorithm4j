package org.billcz.common.algorithm.search;


import org.billcz.common.algorithm.util.Set;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/8
 */
public class BlackRedTreeDict<K extends Comparable<? super K>, V> implements SortDict<K, V> {
    private static final boolean BLACK = false;
    private static final boolean RED = true;

    private Node root;

    private class Node {
        private K k;
        private V v;
        private int size;
        private Node left, right;
        private boolean color = BLACK;

        public Node(K k, V v, int size, boolean color) {
            this.k = k;
            this.v = v;
            this.size = size;
            this.color = color;
        }
    }

    public K getFirst() {
        Node min = min(root);
        return min == null ? null : min.k;
    }

    public K getLast() {
        Node max = max(root);
        return max == null ? null : max.k;
    }

    public void put(K k, V v) {
        if (v == null) {
            remove(k);
            return;
        }

        root = put(root, k, v);
        root.color = BLACK;
    }

    public V get(K k) {
        return get(root, k);
    }

    public void remove(K k) {

    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null || size() == 0;
    }

    public Set<K> Keys() {
        return null;
    }

    public boolean containsKey(K k) {
        return get(k) != null;
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
    }

    private V get(Node node, K k) {
        if (node == null) return null;
        int cmp = k.compareTo(node.k);
        if (cmp > 0) return get(node.right, k);
        else if (cmp < 0) return get(node.left, k);
        return node.v;
    }

    private Node put(Node node, K k, V v) {
        if (node == null) return new Node(k, v, 1, RED);

        int cmp = k.compareTo(node.k);
        if (cmp > 0) node.right = put(node.right, k, v);
        else if (cmp < 0) node.left = put(node.left, k, v);
        else {
            node.v = v;
        }

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) reverseColor(node);

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private Node rotateLeft(Node node) {
        Node y = node.right;
        node.right = y.left;
        y.left = node;

        y.color = node.color;
        y.left.color = RED;

        y.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);

        return y;
    }

    private Node rotateRight(Node node) {
        Node y = node.left;
        node.left = y.right;
        y.right = node;

        y.color = node.color;
        y.right.color = RED;

        y.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return y;
    }

    private void reverseColor(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }


    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }


    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

}
