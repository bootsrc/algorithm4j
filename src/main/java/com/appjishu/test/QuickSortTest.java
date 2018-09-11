package com.appjishu.test;

public class QuickSortTest {
	public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        int start = 0;
        int end = a.length - 1;
        sort(a, start, end);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
	
	private static void sort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];
		
		while (end > start) {
			while(end > start && a[end] >= key) 
				end--;
			if (a[end] <= a[start]) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			
			while (end > start && a[start] <= key) 
				start++;
			
		}
	}
}
