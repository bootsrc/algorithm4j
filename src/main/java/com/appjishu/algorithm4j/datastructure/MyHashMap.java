package com.appjishu.algorithm4j.datastructure;

import java.util.HashMap;

/**
 * 基于HashTable 哈希表简历的HashMap
 * Hash 拉链法解决哈希冲突
 * 源码参考了文章https://blog.csdn.net/null_xv/article/details/79753450
 * <p>
 * 名词解释: 冲突解决技术可以分为两类：开散列方法( open hashing，也称为拉链法，separate chaining )
 * 和闭散列方法( closed hashing，也称为开地址方法，open addressing )。
 * 这两种方法的不同之处在于：开散列法把发生冲突的关键码存储在散列表主表之外，而闭散列法把发生冲突的关键码存储在表中另一个槽内。
 * 这里的源码，是采用了拉链法Separate Chaining method
 */
public class MyHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        String key = "test-key";
        map.put(key, "vvv1");
        String value = (String) map.get(key);
        System.out.println("map.get()=" + value);
    }

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
        int h = hash(key);
        int index = (nodes.length - 1) & h;
        Node newNode = new Node(index, key, value);
        if (nodes[index] == null) {
            nodes[index] = newNode;
        } else {
            Node lastNode = nodes[index].getLastNode();
            lastNode.setNext(newNode);
        }
    }

    public Object get(Object key) {
        int h = hash(key);
        int index = (nodes.length-1) & h;
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
    public static final int hash(Object key) {
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