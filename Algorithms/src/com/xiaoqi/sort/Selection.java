package com.xiaoqi.sort;

/**
 * 选择排序 每次选择剩下数组中最小的数，然后与剩下数组最前面的数交换位置，直到结束。
 * 
 * @author xiaoqi
 *
 */
public class Selection {

	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;// min为最小值的下标
			//找出剩余数组的最小值
			for (int j = i + 1; j < a.length; j++) {
				if(a[min] > a[j]){
					min = j;
				}
			}
			//交换位置
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		SortTest.isSorted(a);
	}

}
