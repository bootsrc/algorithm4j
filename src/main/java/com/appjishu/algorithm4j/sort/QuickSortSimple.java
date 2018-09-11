package com.appjishu.algorithm4j.sort;

import java.util.Arrays;

/**
 * 快速排序，java的最简单实现
 * https://blog.csdn.net/Yexiaofen/article/details/78018204
 */
public class QuickSortSimple {

    public static void main(String[] args) {
        int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        System.out.println(Arrays.toString(a));
        int start = 0;
        int end = a.length - 1;
        System.out.println("Start to sort...");
        sort(a, start, end);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if (low > high) {
            return;
        }

        //2, 初始化变量
        int i = low;
        int j = high;
        // 3. 保存key值
        int key = a[low];

        //4，完成一趟排序
        while (i < j) {
            //4.1 ，从右往左找到第一个小于key的数
            while (i < j && a[j] >= key) {
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while (i < j && a[i] <= key) {
                i++;
            }

            //4.3 交换
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        // 4.4，调整key的位置,  把a[i]与a[low](等于key)交换值
        int temp = a[i];
        a[i] = a[low];
        a[low] = temp;

        //5, 对key左边的数快排
        sort(a, low, i - 1);
        //5, 对key左边的数快排
        sort(a, i + 1, high);
    }
}
