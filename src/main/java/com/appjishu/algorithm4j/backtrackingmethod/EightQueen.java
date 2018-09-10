package com.appjishu.algorithm4j.backtrackingmethod;

/**
 * 回溯法解决八皇后问题
 * 一位数组实现，参考https://www.2cto.com/kf/201603/494773.html
 * 思路是按行来规定皇后，第一行放第一个皇后，第二行放第二个，然后通过遍历所有列，来判断下一个皇后能否放在该列。直到所有皇后都放完，或者放哪都不行。
 * 详细一点说，第一个皇后先放第一行第一列，然后第二个皇后放在第二行第一列、然后判断是否OK，
 * 然后第二列、第三列、依次把所有列都放完，找到一个合适，继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解。
 * 然后回头继续第一个皇后放第二列，后面继续循环……
 */
public class EightQueen {
    /**
     * 一共有多少个皇后（此时设置为8皇后在8X8棋盘，可以修改此值来设置N皇后问题）
     */
    int max = 8;
    /**
     * 该数组保存结果，第一个皇后摆在array[0]列，第二个摆在array[1]列
     */
    int[] array = new int[max];
 
    public static void main(String[] args) {
        new EightQueen().check(0);
    }
 
    /**
     * n代表当前是第几个皇后
     * @param n
     * 皇后n在array[n]列
     */
    private void check(int n) {
        //终止条件是最后一行已经摆完，由于每摆一步都会校验是否有冲突，所以只要最后一行摆完，说明已经得到了一个正确解
        if (n == max) {
            print();
            return;
        }
        //从第一列开始放值，然后判断是否和本行本列本斜线有冲突，如果OK，就进入下一行的逻辑
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }
 
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }
 
    private void print()  {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + 1 + " ");
        }
        System.out.println();
    }
}
