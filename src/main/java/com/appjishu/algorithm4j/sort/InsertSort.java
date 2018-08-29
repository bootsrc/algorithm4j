package com.appjishu.algorithm4j.sort;

/**
 * 插入排序
 * 所谓插入排序法，就是检查第i个数字，如果在它的左边的数字比它大，进行交换，这个动作一直继续下去，直到这个数字的左边数字比它还要小，就可以停止了。插入排序法主要的回圈有两个变数：i和j，每一次执行这个回圈，就会将第i个数字放到左边恰当的位置去。
 * 二、算法描述
 * <p>
 * 1、从第一个元素开始，该元素可以认为已经被排序。
 * 2、取出下一个元素，在已经排序的元素序列中从后向前扫描。
 * 3、如果该元素（已排序）大于新元素，则将该元素移到下一位置。
 * 4、重复步骤3，直到找到已排序的元素小于或者大于新元素的位置。
 * 5、将新元素插入到该位置。
 * 6、重复步骤2。
 * <p>
 * 三、效率分析
 * <p>
 * 如果目标是把n个元素的序列升序排列，那么采用插入排序存在最好情况和最坏情况如下。
 * 最好情况：序列已经是升序排列了，在这种情况下，需要进行的比较操作需(n-1)次即可。
 * 最坏情况：序列是降序排列，那么此时需要进行的比较共有n(n-1)/2次。
 * 直接插入排序属于稳定的排序，最坏时间复杂度为O(n^2)，最好时间复杂度为O(n)，空间复杂度为O(1)。
 * 插入排序的赋值操作是比较操作的次数加上(n-1)次。
 * 因此，插入排序不适合对于数据量比较大的排序应用。
 *
 */
public class InsertSort {
    public static void doInsertSort(int[] source) {
        int i, j;
        int insertNode;// 要插入的数据
        // 从数组的第二个元素开始循环将数组中的元素插入
        for (i = 1; i < source.length; i++) {
            // 设置数组中的第2个元素为第一次循环要插入的数据
            insertNode = source[i];
            j = i - 1;
            // 如果要插入的元素小于第j个元素，就将第j个元素向后移
            while ((j >= 0) && insertNode < source[j]) {
                source[j + 1] = source[j];
                j--;
            }
            // 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
            source[j + 1] = insertNode;
            System.out.print("第" + i + "趟排序：");
            printArray(source);
        }
    }

    private static void printArray(int[] source) {
        for (int i = 0; i < source.length; i++) {
            System.out.print("\t" + source[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int source[] = new int[]{53, 27, 36, 15, 69, 42};
        System.out.print("初始关键字：");
        printArray(source);
        System.out.println("");
        doInsertSort(source);

        System.out.print("\n\n排序后结果：");
        printArray(source);
    }
}
