package com.xiaoqi.sort;

/**
 * 归并排序 将两个有序的数组归并成一个有序的数组
 * 时间复杂度 NlogN
 * 在较小长度的时候和希尔排序的快慢无法证明，但是较长长度下且无序的情况下，是优于希尔排序的
 * 
 * @author xiaoqi
 *
 */
public class Merge {
	
	/**
	 * 归并方法
	 * @param a[] 一个有序的数组
	 * @param low 最低位下标
	 * @param mid 中间位下标
	 * @param height 最高位下标
	 */
	public static void merge(int[] a,int[] copyA, int low, int mid ,int height){

		//复制到一个新的数组
		for(int i=low;i<=height;i++){
			copyA[i] = a[i];
		}
		//归并操作
		//右边数组的第一个位置
		int j = mid + 1;
		for(int i=low;i<=height;i++){
			//左边已经完全归并完成,右边的是有序的，因此只要把右边未归并完第一个放到a
			// j++ 代表j当前位置被归并,然后处理下一个位置
			if(i > mid){
				a[i] = copyA[j++];
			}else if(j > height){//右边已经被归并完成
				a[i] = copyA[i++];
			}else if(copyA[i] < copyA [j]){
				a[i] = copyA[i];
			}else{
				a[i] = copyA[j];
			}
		}
	}
	
	/**
	 * 递归归并，自上而下的归并，从数组长度的一半开始，通过递归，当长度为2、4、8.。。。开始归并
	 * @param a
	 */
	public static void sort1(int[] a){
		int[] copyA = new int[a.length];
		sort(a,copyA,0,a.length-1);
		SortTest.isSorted(a);
	}
	
	/**
	 * 这里通过递归的方式，当长度间隔为1的时候开始归并，然后再是2，4、、、、
	 * @param a
	 * @param copyA
	 * @param low
	 * @param height
	 */
	public static void sort(int[] a,int[] copyA, int low,int height){
		if(low >= height){
			return ;
		}
		int mid = (low + height)/2;
		//归并前半部分
		sort(a,copyA,low,mid);
		//归并后半部分
		sort(a,copyA,mid+1,height);
		merge(a,copyA,low,mid,height);
	}
	
	/**
	 * 自下而上的归并，直接从长度间隔为1开始
	 * @param a
	 */
	public static void sort2(int[] a){
		int[] copyA = new int[a.length];
		//复制到一个新的数组
		for(int i=0;i<=a.length-1;i++){
			copyA[i] = a[i];
		}
		//i代表循环次数
		//e.g:0 1 2 3 4 5 6的循环过程是：
		//01 23 45 6 --> 0123 456 --> 0123456
		//次数为3次，因此i<=a.length/2
		for(int i =0;i<=a.length/2;i++){
			//j为具体归并的两个元素的下标
			for(int j=0;j<a.length -i;j++){
				merge(a,copyA,j,(j+j+i+1)/2,j+i+1-1);
			}
		}
		SortTest.isSorted(a);
	}
}
