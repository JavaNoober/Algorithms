package com.xiaoqi.stackqueuebag;

/**
 * 背包
 * @author xiaoqi
 *
 * @param <Item>
 */
public class Bag<Item> {
	private Node node;
	
	private class Node{
		Item item;
		Node next;
	}
	
	//和Stuck的push一样
	public void add(Item item){
		Node oldFirst = node;
		node = new Node();
		node.item = item;
		node.next = oldFirst;
	}
	
}
