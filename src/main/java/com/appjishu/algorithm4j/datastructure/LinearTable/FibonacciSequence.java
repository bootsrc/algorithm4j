package com.appjishu.algorithm4j.datastructure.LinearTable;

/**
 * https://www.jb51.net/article/45596.htm
 * 算法复杂度分析，参考网页文章
 * https://blog.csdn.net/a1456123a/article/details/48849923
 * https://bbs.pediy.com/thread-123051.htm
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        // 0, 1, 1, 2, 3, 5, 8
        int result = f(6);
        System.out.println("f(6)=" + result);
    }

    private static int f(int n) {
        int result = -1;
        int temp1 = 0;
        int temp2 = 1;
        for (int index = 0; index <= n; index++) {
            if (index == 0) {
                result = temp1;
            } else if (index == 1) {
                result = temp2;
            } else {
                result = temp1 + temp2;
                if (result < 0) {
                    result = -2;
                    break;
                }
                temp1 = temp2;
                temp2 = result;
            }
        }

        return result;
    }

}
