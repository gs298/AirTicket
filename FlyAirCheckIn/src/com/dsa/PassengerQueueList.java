package com.dsa;
public class PassengerQueueList{
	
	private PassengerQueueList.Node front; 
	private PassengerQueueList.Node back;
	private int queueSize;
	
	private static class Node {
		private Object data; 
		private Node next;
		private Node(Object data) {
			this.data = data;
			this.next = null; 
			}
		
		private Node(Object data, Node node) {
			this.data = data;
			this.next = node; 
			}
	}
	
	public Object insertInQueue(Object item) {		// inserts a node in the queue
		if (this.front == null) {
			this.back = new PassengerQueueList.Node(item, null);
			this.front = this.back; 
			}
		else {
			this.back.next = new PassengerQueueList.Node(item, null);
			this.back = this.back.next; 
			}
		this.queueSize+=1;
		return item; 
	}
	
	public Object removeFromQueue() {           //remove from the queue
		
		if (isEmpty()) { 
			System.out.println("The Queue is empty!");
		}
		
		Object item = this.front.data;
		this.front = this.front.next; 
		this.queueSize-=1;
		return item;
	}
		
	public int totalLength() { 	// gives the length of the queue 
		return this.queueSize; 
	}
	
	public boolean isEmpty() {	// to check if the queue is empty
		return this.queueSize==0; 
		}
}
