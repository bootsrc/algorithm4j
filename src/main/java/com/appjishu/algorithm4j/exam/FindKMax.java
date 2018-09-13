package com.appjishu.algorithm4j.exam;

/**
 * 快速排序的实现
 * 寻找第K大的数
 */
public class FindKMax {

    public static void main(String[] args) {
        // 排序后顺序:下标   0, 1, 2, 3, 4,  5,   6,   7
        //                 0, 2, 6, 7, 8 , 12, 35,   90
        int[] array = {12, 8, 90, 35, 0, 7, 2, 6};
        int findK = 8;
        int index = findKMaxInteger(array, 0, array.length - 1, findK);
        System.out.println("maxK index:" + index + ",array[" + index + "]=" + array[index]);
    }

    public static int findKMaxInteger(int[] a, int low, int high, int k) {
//        int start = low;
////        int end = high;
////        int key = a[low];
////
////        while (end > start) {
////            //从后往前比较
////            while (end > start && a[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
////                end--;
////            if (a[end] <= key) {
////                int temp = a[end];
////                a[end] = a[start];
////                a[start] = temp;
////            }
////            //从前往后比较
////            while (end > start && a[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
////                start++;
////            if (a[start] >= key) {
////                int temp = a[start];
////                a[start] = a[end];
////                a[end] = temp;
////            }
////        }
////        //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
////
////        if (a.length - start - 1 < k) {
////            return findKMaxInteger(a, low, start - 1, k + start - a.length);
////        } else if (a.length - start - 1 > k) {
////            return findKMaxInteger(a, start + 1, high, k);
////        } else {
////            return start;
////        }

        int n = a.length;
        if(low >= high || k > n)//边界条件和特殊输入的处理
            return 0;
        int pos = partition(a,low,high);
        while(pos != n  - k)
        {
            if(pos > n - k)
            {
                high = pos - 1;
                pos = partition(a,low,high);
            }
            if(pos < n - k)
            {
                low = pos + 1;
                pos = partition(a,low,high);
            }
        }
        return pos;
    }

    private static int partition(int[] a, int low, int high) {
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
        return i;
    }
}

