package com.appjishu.algorithm4j.datastructure.linkedlist;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class LinkedlistUtil {
    /**
     * 思路：
     * 当前节点的next不为null，则需要进行反转
     * 反转即：需要将next节点的next字段设置为当前节点 （nextNode.setNext(currentNode) 也就是
     * <code>currentNode.getNext().setNext(currentNode); </code>
     * @param head
     * @return
     */
    public static LinkedNode cycleReverse(LinkedNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        //专门记录下一个节点（依次判断下个节点是否为空）
        LinkedNode nextNode = head.getNext();

        //记录next的next用于下次循环使用
        LinkedNode temp = nextNode.getNext();

        //准备好第一个节点（第一个节点不需要去反转）
        head.setNext(null);
        LinkedNode finalNode = head;//最终返回的链表


        //如果下一个几点不为空，说明还有节点，则进行反转
        while (nextNode != null) {
            //记录元素，为了指针下移
            temp = nextNode.getNext();

            //反转链表
            nextNode.setNext(finalNode);
            finalNode = nextNode;

            //指针下移
            nextNode = temp;
        }

        return finalNode;
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(0);
        LinkedNode next = head.getNext();
        for (int i =1; i < 6; i++) {
            LinkedNode node = new LinkedNode(i);
            if (i==1) {
                head.setNext(node);
                next = node;
            } else {
                next.setNext(node);
                next = node;
            }
        }

        LinkedNode x = head;
        System.out.println("--printCurrentLinkedLsit---");
        for (int i= 0; i < 6; i++) {
            System.out.println("node:" + x);
            x = x.getNext();
        }

        // 反转单链表
        head =  cycleReverse(head);

        LinkedNode x1 = head;
        System.out.println("--printCurrentLinkedLsit---");
        for (int i= 0; i < 6; i++) {
            System.out.println("node:" + x1);
            x1 = x1.getNext();
        }
    }
}
