package com.xiaoqi.stackqueuebag;

import java.util.Iterator;

/**
 * 栈 动态调整数组大小的实现
 * @author xiaoqi
 *
 * @param <Item>
 */
public class ResizingArrayStack<Item>{
	private Item[] a= (Item[]) new Object[1];//通过强转，让数组泛型
	private int N;//元素个数
	
	//通过元素个数判断栈是否为空
	public boolean isEmpty(){
		return N==0;
	}
	
	//返回栈中元素个数
	public int size(){
		return N;
	}
	
	//动态调整数组大小
	private void resize(int max){
		Item[] temp = (Item[]) new Object[max];
		//将所有数据复制到新的数组
		for(int i=0;i<N;i++){
			temp[i] = a[i];
		}
		//指向新的引用
		a = temp;
	}
	
	//添加元素到栈顶
	public void push(Item item){
		if(N == a.length){
			//当数组大小充满时，扩大数组大小为两倍
			resize(2*a.length);
		}
		a[N++] = item;
	}
	
	//从栈顶删除元素
	public Item pop(){
		Item item = a[--N];
		a[N] = null;//避免对象游离(无引用对象)
		if(N > 0 && N == a.length/4){
			//当数组大小为总长度4分之1时，调整数组大小为原长度一半
			resize(a.length/2);
		}
		return item;
	}
	
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i=N;
		
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
		
	}

}
