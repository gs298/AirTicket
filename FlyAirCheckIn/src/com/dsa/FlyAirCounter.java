package com.dsa;

import java.util.Scanner;

import com.dsa.FirstClassQueue;
import com.dsa.CoachClassQueue;;

public class FlyAirCounter {

	//private
	
	FirstClassQueue firstClassQueue = new FirstClassQueue(); 
	CoachClassQueue coachClassQueue = new CoachClassQueue(); 
	
	int  totalFirstClassNodes;
	int  totalCoachClassNodes;
	
	int  firstClassMaxServTime;
	int	 couchClassMaxServTime;
	int  totalTimeServed;
	int  timeForFirstClass;
	int  timeForCoachClass;
	
	
    private void passengerEntering() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n\t\t FLY-AIR CHECK IN SERVICES\n\n");
		System.out.print("\tARRIVAL TIME OF FIRST CLASS PASSENGER:\t");  
		this.firstClassQueue.arrivalRate = input.nextInt();

		System.out.print("\tARRIVAL TIME OF COACH CLASS PASSENGER:\t"); 
		this.coachClassQueue.arrRate = input.nextInt();
		
		System.out.print("\tMAX SERVICE TIME FOR FIRST CLASS PASSENGER IN MINUTES:\t");
		this.firstClassMaxServTime = input.nextInt();
		
		
		System.out.print("\tMAX SERVICE TIME FOR COACH CLASS PASSENGER IN MINUTES:\t");
		this.couchClassMaxServTime = input.nextInt();
		
		System.out.print("\tTOTAL TIME IN MINUTES:\t");
		this.totalTimeServed = input.nextInt(); 
		}
    
    private void servingFirstClass()
	{
	for (this.timeForFirstClass = 0; this.timeForFirstClass < this.totalTimeServed; this.timeForFirstClass ++) {
			this.firstClassQueue.checkNewEntry(this.timeForFirstClass);
			
			
			if (this.timeForFirstClass >= this.totalFirstClassNodes){
				firstClassStation();   // there are total two stations
				firstClassStation(); 
				}
			} 
	}
	
	private void servingCoachClass() {
	for (this.timeForCoachClass = 0; this.timeForCoachClass < this.totalTimeServed; this.timeForCoachClass ++) {
		
		this.coachClassQueue.checkNewEntry(this.timeForCoachClass); 
		if (this.timeForCoachClass >= this.totalCoachClassNodes){
			coachClassStation();	// there are total three stations
			coachClassStation();
			coachClassStation();
			} 
		}
	}
		
	private void firstClassStation() {
		if (!this.firstClassQueue.isEmpty()) {
		this.totalFirstClassNodes = this.firstClassQueue.update(this.timeForFirstClass);
		} 
		else if (!this.coachClassQueue.isEmpty()) {
		this.totalFirstClassNodes = this.coachClassQueue.update(this.timeForFirstClass);
		} 
	}
	
		private void coachClassStation() {
		if (!this.coachClassQueue.isEmpty()) {
		this.totalCoachClassNodes = this.coachClassQueue.update(this.timeForCoachClass);
		} 
		else if (!this.firstClassQueue.isEmpty()) {
			this.totalCoachClassNodes = this.firstClassQueue.update(this.timeForCoachClass);
			} 
	}
		
		private void statistics() {
			System.out.println("\n\n\t\t STATISTICS\t\n");
			System.out.println("\t PASSENGERS SERVED");
			System.out.println(" \t\tCOACH CLASS :\t" + this.coachClassQueue.getPassengersServed());
			System.out.println(" \t\t FIRST CLASS :\t" + this.firstClassQueue.getPassengersServed());
			
			
			System.out.println("\n\t AVERAGE SERVICE TIME");
			float avgSerTimeC = this.coachClassQueue.getPassengerLine() / this.coachClassQueue.getPassengersServed(); 
			float avgSerTimeF = this.firstClassQueue.getPassengerLine() / this.firstClassQueue.getPassengersServed(); 
			System.out.println(" \t\t COACH CLASS :\t " + avgSerTimeC);
			System.out.println(" \t\t FIRST CLASS :\t " + avgSerTimeF);
			
			System.out.println("\n\t MAXIMUM SERVICE TIME");
			System.out.println(" \t\tCOACH CLASS :\t" + this.couchClassMaxServTime);
			System.out.println(" \t\t FIRST CLASS :\t" + this.firstClassMaxServTime);
			
			System.out.println("\n\t PASSENGERS IN QUEUE");
			System.out.println(" \t\tCOACH CLASS :\t" + this.coachClassQueue.totalLength());
			System.out.println(" \t\t FIRST CLASS :\t" + this.firstClassQueue.totalLength());
			
			
			System.out.println("\n\t MAXIMUM QUEUE LENGTH");
			System.out.println(" \t\tCOACH CLASS :\t" + this.coachClassQueue.getMSize());
			System.out.println(" \t\t FIRST CLASS :\t" + this.firstClassQueue.getMSize());
			
 
		}
		
		public static void main(String[] args) {
			FlyAirCounter counters = new FlyAirCounter(); 
			
			counters.passengerEntering();
			counters.servingFirstClass();
			counters.servingCoachClass();
			
			counters.statistics();
		}

	
}
