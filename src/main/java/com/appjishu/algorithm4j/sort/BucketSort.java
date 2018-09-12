package com.appjishu.algorithm4j.sort;

import java.util.LinkedList;

/**
 * 桶排序
 * 桶排序假设输入元素均匀而独立的分布在区间[0，1）上；
 * 桶排序的核心思想是，将[0，1）分为n个大小相同的子区间，
 * 上一个区间里的元素都比下一个区间里的元素小，然后对
 * 所有区间里的元素排序，最后顺序输出所有区间里的元素，
 * 达到对所有元素排序的目的。
 *
 * @author liushaoming
 */
public class BucketSort {
    public void sort(Double[] a) {
        int n = a.length;

        /**
         * 创建链表（桶）集合并初始化，集合中的链表用于存放相应的元素
         */
        int bucketNum = 10; // 桶数
        LinkedList<LinkedList<Double>> buckets = new LinkedList<LinkedList<Double>>();
        for (int i = 0; i < bucketNum; i++) {
            LinkedList<Double> bucket = new LinkedList<Double>();
            buckets.add(bucket);
        }
        // 把元素放进相应的桶中
        for (int i = 0; i < n; i++) {
            int index = (int) (a[i] * bucketNum);
            buckets.get(index).add(a[i]);
        }
        // 对每个桶中的元素排序，并放进a中
        int index = 0;
        for (LinkedList<Double> linkedList : buckets) {
            int size = linkedList.size();
            if (size == 0) {
                continue;
            }
            /**
             * 把LinkedList<Double>转化为Double[]的原因是，之前已经实现了
             * 对数组进行排序的算法
             */
            Double[] temp = new Double[size];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = linkedList.get(i);
            }
            // 利用插入排序对temp排序
            // TODO 这里忽略掉插入排序， 使用任何一种比较排序的实现都可以
//            new InsertSort().sort(temp);
            for (int i = 0; i < temp.length; i++) {
                a[index] = temp[i];
                index++;
            }
        }

    }

    public static void main(String[] args) {
        Double[] a = new Double[]{0.3, 0.6, 0.5};
        new BucketSort().sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
