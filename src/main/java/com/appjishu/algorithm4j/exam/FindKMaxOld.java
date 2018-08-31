package com.appjishu.algorithm4j.exam;

/**
 * 在N个乱序元素的数组中找第K大的数
 * 思路：使用快速排序实现
 */
public class FindKMaxOld {
    public static int findKMaxInteger(int array[], int low, int high, int findK) {
        int i = low;
        int j = high;
        int key = array[i];

//        int delta = high - low;
//        if (delta == 0 || delta == 1 || delta == -1) {
//            if (findK == 1) {
//                return high;
//            }
//        }
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
//            return findKMaxInteger(array, low, i - 1, findK - (array.length - i));

            return findKMaxInteger(array, low, i - 1, findK);
            // 或者少使用一对小括号
            // return findKMaxInteger(array, low, i - 1, findK + i - array.length);
            // 参考 https://blog.csdn.net/u010412301/article/details/67704530
        } else if (array.length - i > findK) {
            return findKMaxInteger(array, i+1, high, findK);
        } else {
            return i;
        }
    }

    public static void main(String[] args) {

        // 排序后顺序:下标   0, 1, 2, 3, 4,  5,   6,   7
        //                 0, 2, 6, 7, 8 , 12, 35,   90
        int[] array = {90, 8, 35, 12, 0, 7, 2, 6};
        int findK =4;
        int index = findKMaxInteger(array, 0, array.length - 1, findK);
        System.out.println("maxK index:" + index + ",array[" + index + "]=" + array[index]);
    }
}
