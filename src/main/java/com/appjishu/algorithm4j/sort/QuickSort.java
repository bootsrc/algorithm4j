package com.appjishu.algorithm4j.sort;

/**
 * 快速排序，顾名思义，是一种速度快，效率高的排序算法。
 * 快排原理：
 *         在要排的数（比如数组A）中选择一个中心值key（比如A[0]），通过一趟排序将数组A分成两部分，其中以key为中心，key右边都比key大，key左边的都key小，然后对这两部分分别重复这个过程，直到整个有序。
 *         整个快排的过程就简化为了一趟排序的过程，然后递归调用就行了。
 *         一趟排序的方法：
 * 1，定义i=0，j=A.lenght-1，i为第一个数的下标，j为最后一个数下标
 * 2，从数组的最后一个数Aj从右往左找，找到第一小于key的数，记为Aj；
 * 3，从数组的第一个数Ai 从左往右找，找到第一个大于key的数，记为Ai；
 * 4，交换Ai 和Aj 
 * 5，重复这个过程，直到 i=j
 * 6，调整key的位置，把A[i] 和key交换
 * 假设要排的数组为：A[8] ={ 5 2 8 9 2 3 4 9 }
 *            选择 key = 5， 开始时 i=0，j=7
 *   index       0    1    2    3    4    5    6    7
 *
 * 开始：       5    2    8    9    2    3    4    9
 *                   i                                         j  
 * 第一次找     5    2    8    9    2    3    4    9
 *                               i                       j
 * 交换：       5    2    4    9    2    3    8    9 
 *                               i                       j
 * 第二次找     5    2    4    9    2    3    8    9
 *                                     i           j
 * 交换：       5    2    4    3    2    9    8    9
 *                                     i            j
 * 第三次找     5    2    4    3    2    9    8    9
 *                                           ij   
 * 调整key：   2    5    4    3    5    9    8    9
 *                                            ij
 * ---------------------
 * 作者：Yexiaofen
 * 来源：CSDN
 * 原文：https://blog.csdn.net/Yexiaofen/article/details/78018204
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class QuickSort {

    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        int start = 0;
        int end = a.length - 1;
        sort(a, start, end);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];

        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }

        //递归
        if (start > low) sort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) sort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个
    }
}
