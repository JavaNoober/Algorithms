package com.xiaoqi.first;

public class Simple {
	public static void main(String[] args) {
		
	}
	
	/**
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
