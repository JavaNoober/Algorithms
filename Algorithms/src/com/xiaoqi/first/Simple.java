package com.xiaoqi.first;

public class Simple {
	public static void main(String[] args) {
		int[] numbers = new int[]{0,1,3,4,6,77,100,101};
		System.out.println(getIndex(1, numbers));
	}
	
	/**
	 * 二分法求下标 ，要求数组是有序的
	 * @param key
	 * @param numbers
	 * @return
	 */
	public static int getIndex(int key,int[] numbers){
		int startIndex = 0;
		int endIndex = numbers.length - 1;
		while(startIndex <= endIndex){
			int midIndex = (startIndex + endIndex)/2;
			if(key > numbers[midIndex]){
				startIndex = midIndex + 1;
			}else if(key < numbers[midIndex]){
				endIndex = midIndex - 1;
			}else{
				return midIndex;
			}
		}
		return -1;
	}
	
	/**
	 * 低效率的实现
	 * @param key
	 * @param numbers
	 * @return
	 */
	public int getIndexLow(int key,int[] numbers){
		for(int i = 0;i < numbers.length;i++){
			if(key == numbers[i]){
				return i;
			}
		}
		return -1;
	}
	
	
	/**欧几里得算法，求最大公约数
	 * 求两个非负整数的最大公约数
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int gcd(int num1,int num2){
		if(num2 == 0){
			return num1;
		}
		int r = num1 % num2;
		return gcd(num1, r);
	}
	
	
}
