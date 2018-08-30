package com.appjishu.algorithm4j.exam;

/**
 * 在N个乱序元素的数组中找第K大的数
 * 思路：使用快速排序实现
 */
public class FindKMax {
    public static int findKMaxInteger(int array[], int low, int high, int findK) {
        int i = low;
        int j = high;
        int key = array[i];
        while (i < j) {
            while (i < j && array[j] >= key)
                j--;
            array[i] = array[j];

            while (i < j && array[i] <= key)
                i++;
            array[j] = array[i];

            array[i] = key;
        }
        if (array.length - i < findK) {
            return findKMaxInteger(array, low, i - 1, findK - (array.length - i));
            // 或者少使用一对小括号
            // return findKMaxInteger(array, low, i - 1, findK + i - array.length);

        } else if (array.length - i > findK) {
            return findKMaxInteger(array, i + 1, high, findK);
        } else {
            return i;
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 7, 8, 35, 12, 90, 2, 6};
        int findK = 3;
        int index = findKMaxInteger(array, 0, array.length - 1, findK);
        System.out.println("maxK index:" + index + ",array[" + index + "]=" + array[index]);
    }
}
