//Name: Ross Spencer
//UFL ID: 91091549
//Section: 11H6
//Project Number: 1
//Brief description of file contents: Evaluates likelihood of user catching the monster using user input

import java.util.Scanner;
import java.lang.Math;
public class CaptureCalculator {
public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.println("Hello and welcome to the Monster Capture Possibility Calculator.");
	System.out.println("Please enter the latitude of the monster (1-10): ");
	int mlatitude = input.nextInt();
	System.out.println("Please enter the longitude of the monster (1-10): ");
	int mlongitude = input.nextInt();
	System.out.println("Please enter the time of the monster appear (1-1440): ");
	int timeAppeared = input.nextInt();
	System.out.println("Please enter the possible time of the monster will exist (10-59): ");
	int timeExists = input.nextInt();
	System.out.println("Please enter the player’s ID (8 digits): ");
	int id = input.nextInt();
	System.out.println("Please enter the time of the player noticing monster (1-1440 and greater than the time the monster appears): ");
	int timeNoticed = input.nextInt();
	System.out.println("Please enter the latitude of the player (1-10): ");
	int platitude = input.nextInt();
	System.out.println("Please enter the longitude of the player (1-10): ");
	int plongitude = input.nextInt();
	System.out.println("Please enter the player's walking speed (10-200): ");
	int speed = input.nextInt();
	System.out.println("");
	
	//using variable named status as a binary value where 0 is normal and 1 is lucky since I'm using the user's lucky status as cases in my switch statement
	String listStatus = "";
	int status = 0;
	if(id%100>=0&&id%100<=49){ listStatus = "lucky list"; status = 1; };
	if(id%100>49&&id%100<=99){ listStatus = "normal list"; status = 0; };
	
	
	double distance = 0.0;
	double ptime = 0.0; //will be time it takes player to get to monster's location
	int dtime = timeAppeared + timeExists;
	String possibility = "";
	
	double templat = Math.pow((mlatitude-platitude), 2); //net difference of latitudes of player and monster squared
	double templong = Math.pow((mlongitude-plongitude), 2); //net difference of longitudes of player and monster squared
	distance = 1000*Math.sqrt(templat+templong); //uses distance formula multiplied by 1000m/1km to find distance from monster
	ptime = timeNoticed + ((double) distance/speed); //time it takes player to get to monster's location is time noticed + distance/rate
	distance = Math.round(distance*10)/10.0;
	ptime = Math.round(ptime*10)/10.0;
	double likelihood = 0;
	likelihood = 100*((ptime - (timeAppeared+timeExists))/(timeExists)); //likelihood is probability of capture
	
	if (ptime <= timeAppeared+timeExists){
	possibility = "definitely";
	}
	else {
		switch (status){ //case 0 if user is on lucky list, case 1 if player is on normal list
		case 0: if(likelihood>=0&&likelihood<=5) { possibility="highly likely"; }
				if(likelihood>5&&likelihood<=20) { possibility="likely"; }
				if(likelihood>20&&likelihood<=35) { possibility="unsure"; }
				if(likelihood>35&&likelihood<=40) { possibility="unlikely"; }
				if(likelihood>40) { possibility="highly unlikely"; }  
			break;
		case 1: if(likelihood>=0&&likelihood<=10) { possibility="highly likely"; }
				if(likelihood>10&&likelihood<=30) { possibility="likely"; }
				if(likelihood>30&&likelihood<=40) { possibility="unsure"; }
				if(likelihood>40&&likelihood<=50) { possibility="unlikely"; }
				if(likelihood>50) { possibility="highly unlikely"; }
			break;
		}
		
	}
	
	System.out.println("Player "+id+" who is on the "+listStatus+",");
	System.out.println("noticed the monster at time "+timeNoticed+",");
	System.out.println("is "+distance+" m away from the monster,");
	System.out.println("and will arrive at time "+ptime+".");
	System.out.println("The monster's disappear time is about "+dtime+".");
	System.out.println("So the player will capture this monster with "+possibility+" possibility.");
	
}
}
