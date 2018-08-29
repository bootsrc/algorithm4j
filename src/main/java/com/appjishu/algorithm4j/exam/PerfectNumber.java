package com.appjishu.algorithm4j.exam;

public class PerfectNumber {

    /**
     * 1000以内的完数（完美数）完数：一个数恰好等于它的因子之和（因子：除去这个数本身的正约数）.
     例如：6=1+2+3.
     * @param args
     */
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.println(i);
            }
            sum = 0;
        }
    }
}
