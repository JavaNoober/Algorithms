package com.xiaoqi.stackqueuebag;
/**
 * 先进先出的队列
 * @author xiaoqi
 *
 * @param <Item>
 */
public class Queue<Item> {
	private Node first;//最早添加节点的链接
	private Node last;//最近添加的节点
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	private boolean isEmpty(){
		return first==null;
	}
	
	private int size(){
		return N;
	}
	
	//加入队列
	public void enqueue(Item item){
		Node oldFirst = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()){
			first = last;
		}else{
			oldFirst.next = last;
		}
		N++;
	}
	
	//删除
	public Item dequeue(){
		if(isEmpty()){
			return null;
		}else{
			Item item = first.item;
			first = first.next;
			N--;
			return item;
		}
	}
}
