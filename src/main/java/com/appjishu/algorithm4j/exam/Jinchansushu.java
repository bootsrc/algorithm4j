package com.appjishu.algorithm4j.exam;


/**
 * 金蝉素数-找出所有的5位数的金蝉素数
 * <p>
 * 专家研究发现：这些数是由1，3，5，7，9 这5 个奇数字排列组成的5 位素数，且同时去掉它的最高位与最低位数字后
 * 的三位数还是素数，同时去掉它
 * 的高二位与低二位数字后的一位数还是素数。因此，人们把这些神秘的素数称为金蝉素数，喻意金蝉脱壳之后仍为美丽的金蝉。
 */
public class Jinchansushu {

    public static void main(String[] Args) {

        int[] a = new int[6];
        for (int i = 13579; i <= 97531; i += 2) {   //设置范围
            int t = 0;        //标志，0代表素数，1代表不是素数
            for (int j = 3; j <= Math.sqrt(i); j += 2) {    //判断是不是素数
                if (i % j == 0) {
                    t = 1;    //修改标志
                    break;
                }
            }


            a[1] = i / 10000;        //万分位
            a[2] = (i / 1000) % 10;    //千分位
            a[3] = (i / 100) % 10;    //百分位
            a[4] = (i / 10) % 10;    //十分位
            a[5] = i % 10;        //个位

            if (t == 0) {
                for (int x = 1; x <= 5; x++) {        //筛选调是偶数的数字
                    if (a[x] % 2 == 0) {
                        t = 1;
                        break;
                    }
                }
            }

            if (t == 0) {
                for (int x = 1; x <= 4; x++) {        //比较 ，确保没有相同的数字
                    for (int y = x + 1; y <= 5; y++) {
                        if (a[x] == a[y]) {
                            t = 1;
                            break;
                        }
                    }
                }
            }


            if (t == 0) {        //确保中间的数字不是1或9  因为不是素数
                if (a[3] == 1 || a[3] == 9) {
                    t = 1;
                }
            }
            if (t == 0) {
                int num = a[2] * 100 + a[3] * 10 + a[4];
                for (int j = 3; j <= Math.sqrt(num); j++) {        //确保去掉最高位和最低位还是素数
                    if (num % j == 0) {
                        t = 1;
                        break;
                    }
                }
            }

            if (t == 0) {
                System.out.println(i);        //如果是素数  输出该数字
            }
        }

    }
}