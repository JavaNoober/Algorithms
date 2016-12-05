package com.xiaoqi.sort;

public class SortTest {
	static int[] a = new int[]{11,22,3,14,31,22,1,0};
	
	public static void main(String[] args) {
		//选择排序
//		Selection.sort(a);
//		show();
//		Insertion.sort2(a);
//		Shell.sort(a);
		Merge.sort2(a);
	}
	
	
	public static void show(){
		for(int i:a){
			System.out.println(i+"");
		}
	}
	
	public static void isSorted(int[] a){
		boolean result = true;
		if(a.length > 1){
			int index = 0;
			for(int i=1;i<a.length;i++){
				if(a[index++] > a[i]){
					result = false;
					break;
				}
			}
		}else{
			result = true;
		}
		System.out.println(result);
	}
}
