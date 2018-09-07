package com.appjishu.algorithm4j.datastructure;

/**
 * 基于HashTable 哈希表简历的HashMap
 * Hash 拉链法解决哈希冲突
 */
public class MyHashMap {
    Node[] nodes;
    int intsize;

    private MyHashMap(int intsize) {
        this.intsize = intsize;
        nodes = new Node[intsize];
    }

    /**
     * 初始化大小，需要优化
     */
    public MyHashMap() {
        this(1024 * 1024);
    }

    public boolean isEmpty() {
        return intsize == 0;
    }

    public void put(Object key, Object value) {
        int index = hash(key);
        Node newNode = new Node(index, key, value);
        if (nodes[index] == null) {
            nodes[index] = newNode;
        } else {
            Node lastNode = nodes[index].getLastNode();
            lastNode.setNext(newNode);
        }
    }

    public Object get(Object key) {
        int index = hash(key);
        Node startNode = nodes[index];
        if (startNode == null) {
            return null;
        } else if (startNode.getKey() == key) {
            return startNode.getValue();
        } else {
            Node node = startNode.getNode(key);
            if (node == null) {
                return null;
            }
            return node.getValue();
        }
    }

    /**
     * 计算hash值，即在数组中的索引，以后进行优化
     *
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

class Node {
    Object key;
    Object value;
    int index;
    Node next;

    public Node(int index, Object key, Object value) {
        this.key = key;
        this.value = value;
        this.index = index;
    }

    public boolean isLast() {
        return this.next == null;
    }

    /**
     * 获取链表中与key相同的节点
     *
     * @param key
     * @return
     */
    public Node getNode(Object key) {
        if (key == this.key) {
            return this;
        }
        if (next != null) {
            return next.getNode(key);
        }
        return null;
    }

    public Node getLastNode() {
        if (this.next == null) {
            return this;
        }
        return this.next.getLastNode();
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

}