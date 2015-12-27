package com.dsa;
public class FirstClassQueue extends PassengerQueueList {
	public double arrivalRate; 
	private int maximumServed;
	private int maximumWaiting;
	private int totalServed;
	private int totalNum;
	
	public FirstClassQueue() {
		this.totalNum = 0;
		}
	
	public void checkNewEntry(int clock) {
		double x = Math.random();
		
		if ( x < this.arrivalRate) { 
			insertInQueue(new FirstClassPassengers(clock));
			}
		}
	
	public int update(int time) {
		FirstClassPassengers nextPass = (FirstClassPassengers) removeFromQueue(); // remaining
		int timeStamp = nextPass.getarrTime(); 
		int wait = time - timeStamp;
		
		if (this.maximumWaiting < wait) {
			this.maximumWaiting = wait;
			}

		totalServed+=nextPass.getsertime(); // time served
		this.totalNum += 1;
		if (this.maximumServed < this.totalNum) {
			this.maximumServed = this.totalNum;
			}
		
		return time + nextPass.getsertime(); 
		}
	
	public int getMSize() {
		return this.maximumServed; 
		}
	
	public int getPassengerLine() {
		return this.totalServed; 
		}
	
	public int getPassengersServed() {
		return this.totalNum; 
		}
	

	
}
