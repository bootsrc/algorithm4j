package com.appjishu.algorithm4j.search;

import java.util.Arrays;

/*
 *----- 斐波那契查找------
 * 1.斐波那契实在二分查找基础上，用斐波那契数列来进行分割
 * 2.在斐波那契数列上找一个略大于查找元素表个数的值f(n)
 * 3.将查找元素表个数扩充到f(n) 如果要补充元素用最后一个元素补充
 * 4.完成后对f(n)个元素进行斐波那契分割,即分割成 前面f(n-1)个元素,后面f(n-2)个元素
 * 5.对要查找元素的那个部分进行递归
 * 6.就平均性能而言 优于折半查找 但是若一直在左边长半区查找则低于折半查找
 *
 * 参考文章https://blog.csdn.net/qq_41056506/article/details/81874439
 *
 * 避免递归（子函数嵌套多，导致栈溢出, 改成用迭代-for循环
 * 采用https://www.jb51.net/article/45596.htm
 * 里面的方法三
 * */
public class FibonacciSearch {
    private static int maxsize = 20;

    //生成斐波那契数列
    public static int[] fibonacci() {
        int[] f = new int[maxsize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxsize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //查找
    public static int search(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0; //斐波那契分割数值下标
        int mid = 0;
        int f[] = fibonacci(); //获得斐波那契数列
        //获得斐波那契分割数值下标
        while (high > f[k] - 1) {
            k++;
        }

        //利用Java工具类Arrays 构造新数组并指向 数组 a[]
        int[] temp = Arrays.copyOf(a, f[k]);

        //对新构造的数组进行 元素补充
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        while (low <= high) {
            //由于前面部分有f[k-1]个元素
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {//关键字小于切割位置元素 继续在前部分查找
                high = mid - 1;
                /*全部元素=前部元素+后部元素
                 * f[k]=f[k-1]+f[k-2]
                 * 因为前部有f[k-1]个元素,所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
                 * 即在f[k-1]的前部继续查找 所以k--
                 * 即下次循环 mid=f[k-1-1]-1
                 * */
                k--;
            } else if (key > temp[mid]) {//关键字大于切个位置元素 则查找后半部分
                low = mid + 1;
                /*全部元素=前部元素+后部元素
                 * f[k]=f[k-1]+f[k-2]
                 * 因为后部有f[k-2]个元素,所以可以继续拆分f[k-2]=f[k-3]+f[k-4]
                 * 即在f[k-2]的前部继续查找 所以k-=2
                 * 即下次循环 mid=f[k-1-2]-1
                 * */
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

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11, 12};
        int i = search(a, 5);
        System.out.println("5在：" + (i + 1));
        int j = search(a, 12);
        System.out.println("12在：" + (j + 1));
    }

}
