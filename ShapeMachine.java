//Name: Ross Spencer
//UFL ID: 91091549
//Section: 11H6
//Project Number: 2
//Brief description of file contents: Shape Machine, returns the area and perimeter/circumference of various shapes


//regrade notes: changes made: added header.


import java.util.Scanner; 
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShapeMachine {
	public static void main(String[] args){
		
		
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		//new Date();// - creates a new object with today's day
		//new SimpleDateFormat(“dd-MM-yyyy”).format(...)// - converts the date it is given (...) to the dd-MM-yyyy String representation
	
		Scanner scanSomethingImGivingUpOnYou = new Scanner(System.in);
		System.out.println("Shape Machine Login");
		System.out.println();
		for(int i = 1; i <= 3; i++){
			System.out.print("What is today's day? ");
			String day = scanSomethingImGivingUpOnYou.next();
			System.out.print("What is today's month? ");
			String month = scanSomethingImGivingUpOnYou.next();
			System.out.print("What is today's year? ");
			String year = scanSomethingImGivingUpOnYou.next();
			String password = day + "-" + month + "-" + year;
			if(password.equals(date)){
				System.out.println("Correct date. Welcome!");
				System.out.println();
				break;
			}
			else{
				if(i < 3){
					System.out.println("#ERROR Login attempt #"+i+" Invalid input. Please try again.");
					System.out.println();
				}
				if(i == 3){
					System.out.println("#ERROR 3rd invalid login attempt. Terminating program.");
					System.exit(0);
				}
			}
		}
		String shape = "";
		while(shape.equals("Exit") == false){   //entire menu is in a while loop that cycles thru menu until 'Exit' is entered
			System.out.println("---Welcome to the Shape Machine---");
			System.out.println("Available Options:");
			System.out.println("Circles");
			System.out.println("Rectangles");
			System.out.println("Triangles");
			System.out.println("Exit");
			System.out.println();
			shape = scanSomethingImGivingUpOnYou.next();
			if(shape.equals("Circles")){
				System.out.print("Circles selected. Please enter the radius: ");
				boolean radiusValid = false;
				while(radiusValid == false){	//loops until radius is greater than or equal to 0
					double radius = scanSomethingImGivingUpOnYou.nextDouble();
					if(radius > 0){
						radiusValid = true; //breaks loop
						double circumference = Math.PI * 2 * radius;
						double area = Math.PI * radius * radius;
						String circumferenceString = Double.toString(Math.abs(circumference));
						int circumferenceDigits = circumferenceString.length() - 1;//subtract 1 from string length to remove '.' from count
						String areaString = Double.toString(Math.abs(area));
						int areaDigits = areaString.length() - 1;
						System.out.println("The circumference is: "+circumference);
						System.out.println("The area is: "+area);
						System.out.println("Total number of digits in the circumference is: "+circumferenceDigits);
						System.out.println("Total number of digits in the area is: "+areaDigits);
						System.out.println();
					}
					else{
						System.out.print("#ERROR Negative input. Please input the radius again: ");
					}
				}
				
				
			}
			else if(shape.equals("Rectangles")){
				System.out.print("Rectangles selected. Please enter the 2 sides: ");
				boolean sidesValid = false;
				while(sidesValid == false){ //loops until sides are both non-negative
					double side1 =  scanSomethingImGivingUpOnYou.nextDouble();
					double side2 =  scanSomethingImGivingUpOnYou.nextDouble();
					if(side1 > 0 && side2 > 0){
						sidesValid = true; //breaks loop
						double area = side1 * side2;
						double perimeter = (2 * side1) + (2 * side2);
						String areaString = Double.toString(Math.abs(area));
						int areaDigits = areaString.length() - 1;//subtract 1 from string length to remove '.' from count
						String perimeterString = Double.toString(Math.abs(perimeter));
						int perimeterDigits = perimeterString.length() - 1;
						System.out.println("The area is: "+area);
						System.out.println("The perimeter is: "+perimeter);
						System.out.println("Total number of digits in the area is: "+areaDigits);
						System.out.println("Total number of digits in the perimeter is: "+perimeterDigits);
						System.out.println();
					}
					else{
						System.out.print("#ERROR Negative input. Please input the 2 sides again: ");
					}
				 }
			}
			else if(shape.equals("Triangles")){
				System.out.print("Triangles selected. Please enter the 3 sides: ");
				boolean sidesValid = false;
				while (sidesValid == false){ //loops until all three sides are non-negative
					double sideA = scanSomethingImGivingUpOnYou.nextDouble();
					double sideB = scanSomethingImGivingUpOnYou.nextDouble();
					double sideC = scanSomethingImGivingUpOnYou.nextDouble();
					if((sideA > 0) && (sideB > 0) && (sideC > 0)){ //checks that each side is non-negative
						sidesValid = true;//breaks loop
						String triangleType = "Scalene";
						if( ( (sideA + sideB) > sideC ) && ( (sideA + sideC) > sideB ) && ( (sideB + sideC) > sideA ) ){ //checks validity of triangle with the given sides
							if( (sideA==sideB) && (sideA==sideC) ){ //if all 3 sides are equal
								triangleType = "Equilateral";
							}
							else if( (sideA==sideB) || (sideA==sideC) || (sideB==sideC) ){ //if any 2 sides are equal
								triangleType = "Isosceles";
							}
							double perimeter = sideA + sideB + sideC;
							double heron = perimeter/2; //heron's formula for finding area of triangles uses half the perimeter in its computation
							double area = Math.sqrt(heron*(heron-sideA)*(heron-sideB)*(heron-sideC)); //heron's formula
							String perimeterString = Double.toString(Math.abs(perimeter)); //converts to string to count indices
							int perimeterDigits = perimeterString.length() - 1;
							String areaString = Double.toString(Math.abs(area));
							int areaDigits = areaString.length() - 1;//subtract 1 from string length to remove '.' from count
							System.out.println("The triangle is: "+triangleType);
							System.out.println("The perimeter is: "+perimeter);
							System.out.println("The area is: "+area);
							System.out.println("Total number of digits in the perimeter is: "+perimeterDigits);
							System.out.println("Total number of digits in the area is: "+areaDigits);
							System.out.println();
						
						}
						else{
							System.out.println("#ERROR Triangle is not valid. Returning to menu.");
							System.out.println();
							sidesValid = true;//breaks triangle while loop, creates a new loop to menu
						}
						
					}
					else{
						System.out.print("#ERROR Negative input. Please input the 3 sides again: ");
					}
				}
				
				
			}
			else if(shape.equals("Exit")){
				System.out.println("Terminating the program. Have a nice day!");
				System.exit(0); //closes program
			}
			else {
				System.out.println("#ERROR Invalid option. Please try again.");
				System.out.println();
			}
			
		}

	
	}
	
}