package com.appjishu.algorithm4j.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int source[] = new int[]{53, 27, 36, 15, 69, 42};
        System.out.print("初始关键字：");
        printArray(source);
        System.out.println("");
        doBubbleSort(source);
        System.out.print("\n\n排序后结果：");
        printArray(source);
    }

    private static void printArray(int[] source) {
        for (int i = 0; i < source.length; i++) {
            System.out.print("\t" + source[i]);
        }
        System.out.println();
    }

    private static void doBubbleSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length - i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    int tmp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = tmp;
                }
            }

            if (i < source.length - 1) {
                System.out.print("第" + (i + 1) + "趟排序：");
                printArray(source);
            }
        }

    }
}
