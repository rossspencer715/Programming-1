import java.util.ArrayList;
import java.io.*;

//Name: Ross Spencer
//UFL ID: 91091549
//Section: 11H6
//Project Number: 5
//Brief description of file contents: Grad student (child of Student class)

public class GraduateStudent extends Student {
	
	public GraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major, String advisor){
		super(name, id, essay, errorList);
		this.setMajor(major);
		this.setAdvisor(advisor);
	}
	
	private String major;
	private String advisor;
	
	public String getMajor(){
		return major;
	}
	
	public void setMajor(String major){
		this.major = major;
	}
	public String getAdvisor(){
		return advisor;
	}
	
	public void setAdvisor(String advisor){
		this.advisor = advisor;
	}
	public void writeToFile(){
		try{
			FileWriter filer = new FileWriter(this.getId() + "_graded.txt" , true);
		    PrintWriter writer = new PrintWriter(filer);
		    writer.println("Graduate Student "+this.getName());
		    writer.println("Student ID: "+this.getId());
		    writer.println("Major: "+this.getMajor());
		    writer.println("Advisor: "+this.getAdvisor());
		    writer.println(this.getPrintableErrorList());
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}
	
	
}
