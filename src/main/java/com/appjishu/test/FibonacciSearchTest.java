package com.appjishu.test;

import java.util.Arrays;

public class FibonacciSearchTest {
    private static int maxsize = 20;


    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11, 12};
        int i = search(a, 5);
        System.out.println("5在：" + (i + 1));
        int j = search(a, 12);
        System.out.println("12在：" + (j + 1));
    }


    private static int search(int[] a, int key) {
        int f[] = fibonacci();
        int low = 0;
        int high = a.length - 1;
        int k = 0;
        while (high > f[k] - 1) {
            k++;
        }

        int[] temp = Arrays.copyOf(a, f[k]);

        //填充
        for (int j = high+1; j < temp.length; j++) {
            temp[j] = a[high];
        }

        while (low <= high) {
            // 前面部分有f[k-1] 个元素
            int mid = low + f[k-1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;
    }

    private static int[] fibonacci() {
        int[] f = new int[maxsize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxsize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }


}
