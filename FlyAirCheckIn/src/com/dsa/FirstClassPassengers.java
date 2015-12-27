package com.dsa;

import java.util.Random;

public class FirstClassPassengers {
	Random r = new Random(); 
	private
	 	int passengerID;
	 	int serviceTime;
	 	int arrivalTime;
	 	static int maxserviceTime = 3; 
	 	static int idNum = 0;
	
	public FirstClassPassengers(int arrTime) {
		this.arrivalTime = arrTime;
	
		this.serviceTime = (1 + this.r.nextInt(maxserviceTime));
		this.passengerID = (idNum++); 
		}
	
	public int getarrTime() {
		return this.arrivalTime; 
		}
	
	public int getsertime() {
		return this.serviceTime;
		}
	
	public int getId() {
		return this.passengerID; 
		}

	public static void setMaxsertime(int maxServiceTime) {
		maxserviceTime = maxServiceTime; 
		}
}
