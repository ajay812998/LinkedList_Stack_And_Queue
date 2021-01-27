package com.bridgelabz;

public class LinkedList<K> {
	public INode<K> head;
	public INode<K> tail;
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void add(INode<K> node) {
		if(head == null) {
			head = node;
			tail = node;
		}
		else {
			INode<K> tempNode = head;
			tempNode = head;
			head = node;
			head.setNext(tempNode);	
		}
	}
	
	public void append(INode<K> node) {
		if(head == null) {
			head = node;
			tail = node;
		}
		else {
			INode<K> tempNode = tail;
			tempNode.setNext(node);
			tail = node;
		}
	}
	
	public void insert(int position, INode<K> node) {
		int count = 0;
		INode<K> previousNode = null;
		INode<K> currentNode = head;
		while(count != position) {
			count++;
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		previousNode.setNext(node);
		node.setNext(currentNode);
	}
	
	public K pop() {
		INode<K> tempNode = head.getNext();
		K key = head.getKey();
		head = tempNode;
		return key;
	}
	
	public K popLast() {
		INode<K> currentNode = head;
		INode<K> previousNode = null;
		while(currentNode.getNext() != null) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();	
		}
		K key = currentNode.getKey();
		currentNode = null;
		previousNode.setNext(null);
		tail = previousNode;
		return key;	
	}
	
	public boolean search(K item) {
		boolean isPresent = false;
		INode<K> tempNode = head;
		while(tempNode.getNext() != null) {
			if(tempNode.getKey().equals(item)) {
				isPresent = true;
			}
			else {
				tempNode = tempNode.getNext();
			}	
		}
		if(tail.getKey().equals(item)) {
			isPresent = true;
		}
		return isPresent;	
	}
	public void printNodes() {
		INode<K> tempNode = head;
		while(tempNode.getNext() != null) {
			System.out.print(tempNode.getKey() + "->");
			tempNode = tempNode.getNext();
		}	
		System.out.print(tempNode.getKey());
	}
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		MyNode<Integer> firstNode = new MyNode<Integer>(56);
		MyNode<Integer> secondNode = new MyNode<Integer>(30);
		MyNode<Integer> thirdNode = new MyNode<Integer>(70);
		list.append(firstNode);
		list.append(thirdNode);
		list.insert(1, secondNode);
		list.popLast();
		list.printNodes();
	}
}
