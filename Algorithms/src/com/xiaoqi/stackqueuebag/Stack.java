package com.xiaoqi.stackqueuebag;

/**
 * 栈 通过链表实现
 * @author xiaoqi
 *
 * @param <Item>
 */
public class Stack<Item> {
	private Node first;//栈顶元素（最近添加的元素）
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	
	//通过元素个数判断栈是否为空
	public boolean isEmpty(){
		return first==null;
	}
	
	//返回栈中元素个数
	public int size(){
		return N;
	}
	
	//压入栈顶
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	//删除栈顶元素
	public Item pop(){
		Item item = null;
		if(!isEmpty()){
			item = first.item;
			first = first.next;
			N--;
		}
		return item;
	}
}
