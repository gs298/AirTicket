package com.dsa;

import java.util.Random;

public class CoachClassPassenger {
	Random rand = new Random(); 
	
	private
	int x=0;
	 	int passengerID;
	 	int serviceTime;
	 	int arrivalTime;
	 	static int maxserviceTime = 10;
	 	static int idNum = 0;
	
	public CoachClassPassenger(int arrivalTime) {
		this.passengerID = (idNum++); 
		this.arrivalTime = arrivalTime;
		this.serviceTime = (1 + this.rand.nextInt(maxserviceTime));
		}
	
	public int getArrivalTime() {
		return this.arrivalTime;
		}
	
	public int getServiceTime() {
		return this.serviceTime; 
		}
	
	public int getId() {
		return this.passengerID; 
		}
	
	public static void setMaxserviceTime(int maxServiceTime) {
		maxserviceTime = maxServiceTime;
		}
}
