package com.dsa;
import com.dsa.CoachClassPassenger;
public class CoachClassQueue extends PassengerQueueList{
	private
	
	 	
	 	int maximumServed = 0; 
	 	int maximumWaiting = 0;
	 	int totalServed; 
	 	int totalNum;

	public double arrRate; 
	
	public CoachClassQueue() {
		this.totalNum = 0;
//		
		}
	
	
	public void checkNewEntry(int time) {
		if (Math.random() < this.arrRate) { 
			insertInQueue(new CoachClassPassenger(time));
		} 
	}
	
	public int update(int time) {
		
		CoachClassPassenger nextPass = (CoachClassPassenger)removeFromQueue(); 
		int timeStamp = nextPass.getArrivalTime(); 
		int wait = time - timeStamp;
		//this.totalWait += wait; 
		totalServed+=nextPass.getServiceTime();
		if (this.maximumWaiting < wait) { 
			this.maximumWaiting = wait;
		}
		
		this.totalNum += 1;
		if (this.maximumServed < this.totalNum) {
			this.maximumServed = this.totalNum;
		}
		
		return time + nextPass.getServiceTime();
	}
	public int getPassengerLine() {
		return this.totalServed; 
		}
	public int getPassengersServed() {
		return this.totalNum; 
		}
	public int getMSize() {
		return this.maximumServed;
		}


}
