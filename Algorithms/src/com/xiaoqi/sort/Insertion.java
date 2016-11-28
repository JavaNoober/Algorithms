package com.xiaoqi.sort;

/**
 * 插入排序 如同打牌一样，将剩下数组的第一个插入到前面已经排好序的数组中，然后后移插入位置到原位置的数组一位 特别适合有一定顺序的数组
 * 
 * @author xiaoqi
 *
 */
public class Insertion {
	/**
	 * 时间复杂度为n三次方
	 * 
	 * 思路是将a[i]取出，然后从前半部分已经排序的第一个位置开始比对大小，再去右移
	 * 
	 * @param a
	 */
	public static void sort1(int[] a) {
		for (int i = 1; i < a.length; i++) {
			// j是已经排序好的前半部分数组的长度
			// 将a[i]与i到j之间的数组进行比较，将小的放第一个位置，然后右移ji之间的数组
			for (int j = 0; j < i; j++) {
				if (a[j] > a[i]) {
					int temp = a[j];
					a[j] = a[i];
					// 右移
					for (int k = i; k > j; k--) {
						a[k] = a[k - 1];
					}
				}
			}
		}
		SortTest.isSorted(a);
	}

	/**
	 * 将a[i]取出，然后从a[i-1]的位置开始从已经排序好的数组的最后一个位置开始向左（依次到第0个位置）比较，大于就交换位置
	 * 
	 * 通过交换位置的方式向右移动
	 * @param a
	 */
	public static void sort2(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j-1]) {
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
		SortTest.isSorted(a);
	}
}
