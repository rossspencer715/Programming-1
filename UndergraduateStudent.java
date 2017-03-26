import java.util.ArrayList;
import java.io.*;

//Name: Ross Spencer
//UFL ID: 91091549
//Section: 11H6
//Project Number: 5
//Brief description of file contents: Undergrad student (child of Student class)

public class UndergraduateStudent extends Student {
	
	public UndergraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major){
		super(name, id, essay, errorList);
		this.setMajor(major);
	}
	
	private String major;
	
	public String getMajor(){
		return major;
	}
	
	public void setMajor(String major){
		this.major = major;
	}
	public void writeToFile(){
		try{
			FileWriter filer = new FileWriter(this.getId() + "_graded.txt" , true);
		    PrintWriter writer = new PrintWriter(filer);
			writer.println("Undergraduate Student "+this.getName());
		    writer.println("Student ID: "+this.getId());
		    writer.println("Major: "+this.getMajor());
		    writer.println(this.getPrintableErrorList());
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}
	
	
}
