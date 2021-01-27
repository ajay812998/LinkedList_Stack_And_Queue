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
	
	public int index(K item) {
		int index = 0;
		int count = 0;
		INode<K> tempNode = head;
		while(tempNode.getNext() != null) {
			if(tempNode.getKey().equals(item)) {
				index = count;
				break;
			}
			else {
				tempNode = tempNode.getNext();
			}
			count++;
		}
		if(tail.getKey().equals(item)) {
			count++;
			index = count;
		}
		return index;
	}
	public void printNodes() {
		INode<K> tempNode = head;
		while(tempNode.getNext() != null) {
			System.out.print(tempNode.getKey() + "->");
			tempNode = tempNode.getNext();
		}	
		System.out.print(tempNode.getKey());
	}
	public boolean isEmpty() {
		boolean empty = false;
		if(head == null ) {
			empty = true;
		}
		return empty;
	}
	public void remove(INode<K> node) {
		boolean removed = false;
		INode<K> currentNode = head.getNext();
		INode<K> previousNode = head;
		if(head.equals(node) && head != null) {
			this.pop();
		}
		else if(tail.equals(node)) {
			this.popLast();	
		}
		else {
			do {
				if(currentNode.getKey().equals(node.getKey())) {
					previousNode.setNext(currentNode.getNext());
					removed = true;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}while(!removed);
		}
	}
	
	public int size() {
		int count = 0;
		INode<K> node = head;
		while(node.getNext() != null) {
			count++;
			node = node.getNext();
		}
		if(node.equals(tail)) {
			count++;
		}
		return count;
	}
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		MyNode<Integer> firstNode = new MyNode<Integer>(56);
		MyNode<Integer> secondNode = new MyNode<Integer>(30);
		MyNode<Integer> thirdNode = new MyNode<Integer>(70);
		MyNode<Integer> fourthNode = new MyNode<Integer>(40);
		list.append(firstNode);
		list.append(thirdNode);
		list.insert(1, secondNode);
		list.insert(list.index(secondNode.getKey())+1, fourthNode);
		list.remove(fourthNode);
		list.printNodes();
	}
}
