package com.appjishu.algorithm4j.datastructure.linkedlist;

public class LinkedNode {
    private int data;// 数据域
    private LinkedNode next;// 指针域

    public LinkedNode() {

    }

    public LinkedNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "data=" + data +
                '}';
    }
}