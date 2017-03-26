import java.util.ArrayList;
import java.io.*;

//Name: Ross Spencer
//UFL ID: 91091549
//Section: 11H6
//Project Number: 5
//Brief description of file contents: High school student (child of Student class)

public class HighSchoolStudent extends Student {
	
	public HighSchoolStudent(String name, String id, String essay, ArrayList<String> errorList, String nameOfSchool){
		super(name, id, essay, errorList);
		this.setSchoolName(nameOfSchool);
	}
	
	private String nameOfSchool;
	
	public String getSchoolName(){
		return nameOfSchool;
	}
	
	public void setSchoolName(String schoolName){
		nameOfSchool = schoolName;
	}
	public void writeToFile(){
		try{
			FileWriter filer = new FileWriter(this.getId() + "_graded.txt" , true);
		    PrintWriter writer = new PrintWriter(filer);
		    writer.println("High School Student "+this.getName());
		    writer.println("Student ID: "+this.getId());
		    writer.println("School Name: "+this.getSchoolName());
		    writer.println(this.getPrintableErrorList());
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}
	
	
}
