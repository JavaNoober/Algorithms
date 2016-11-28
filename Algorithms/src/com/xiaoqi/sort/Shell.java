package com.xiaoqi.sort;

/**
 * 希尔排序 是插入排序的一种改进，它的空间复杂度取决于一个常数因子，但是小于插入排序。
 * 思想：把数组分为间隔为h的h个数组，然后分别插入排序，再把分为h/k（k>1）个数组，再插入排序，直到h为1。
 * @author xiaoqi
 *
 */
public class Shell {
	public static void sort(int[] a){
		int N = a.length;
		int h = 1;
		//假设这个常数因子是 d = 1/3
		//先得到一个h/d + 1大于 数组长度的最小值
		while(h < N/3){
			h = 3 * h + 1;
		}
		//进行插入排序直到h为1
		while(h >= 1){
			//每个数组间隔为h,进行插入排序
			for(int i=h;i< N;i++){
				for(int j = i;j >= h;j -= h){
					if(a[j] < a[j-h]){
						int temp = a[j];
						a[j] = a[j-h];
						a[j-h] = temp;
					}
				}
			}
			//缩小h
			h = h /3;
		}
		SortTest.show();
		SortTest.isSorted(a);
	}
}
