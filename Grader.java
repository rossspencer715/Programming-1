import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

//Name: Ross Spencer
//UFL ID: 91091549
//Section: 11H6
//Project Number: 5
//Brief description of file contents: Grades file based off dictionary

public class Grader {
	private boolean available;
	private Student student;
	private Dictionary dict;
		
	public Grader(Dictionary dict){
		this.dict = dict;
	}
	
	public boolean gradeStudent(String fileName){
	fileName = fileName + ".txt";
		try{
			File fileGraded = new File(fileName);
			if(fileGraded.exists()){
				Scanner fileScanner = new Scanner(fileGraded);
				String studentType = fileScanner.nextLine();
				if(studentType.equals("HighSchool Student")){
					String name = fileScanner.nextLine();
					String id = fileScanner.nextLine();
					String schoolName = fileScanner.nextLine();
					ArrayList<String> essay = new ArrayList<String>();
					ArrayList<String> errorList = new ArrayList<String>();
					//dict = new Dictionary();
					while(fileScanner.hasNext()){
						essay.add(fileScanner.next());
					}
					for(int i = 0; i < essay.size(); i++){
						String word = essay.get(i);
						word = word.replace(".", "");
						word = word.replace(",", "");
						word = word.replace("!", "");
						word = word.replace("?", "");
						word = word.replace(":", "");
						word = word.replace(";", "");
						word = word.replace(" ", "");
						if(!(word.equals("I"))){
							word = word.toLowerCase();
						}
						if(dict.isWord(word) == false){
							errorList.add(word);
						}
					}
					student = new HighSchoolStudent(name,id,essay.toString(),errorList,schoolName);
					fileScanner.close();
					available = false;
					return true;
				}
				if(studentType.equals("Graduate Student")){
					String name = fileScanner.nextLine();
					String id = fileScanner.nextLine();
					String major = fileScanner.nextLine();
					String advisor = fileScanner.nextLine();
					ArrayList<String> essay = new ArrayList<String>();
					ArrayList<String> errorList = new ArrayList<String>();
					//Dictionary dict = new Dictionary();
					while(fileScanner.hasNext()){
						essay.add(fileScanner.next());
					}
					for(int i = 0; i < essay.size(); i++){
						String word = essay.get(i);
						word = word.replace(".", "");
						word = word.replace(",", "");
						word = word.replace("!", "");
						word = word.replace("?", "");
						word = word.replace(":", "");
						word = word.replace(";", "");
						word = word.replace(" ", "");
						if(!(word.equals("I"))){
							word = word.toLowerCase();
						}
						if(dict.isWord(word) == false){
							errorList.add(word);
						}
					}
					student = new GraduateStudent(name,id,essay.toString(),errorList,major,advisor);
					fileScanner.close();
					available = false;
					return true;
				}
				if(studentType.equals("Undergraduate Student")){
					String name = fileScanner.nextLine();
					String id = fileScanner.nextLine();
					String major = fileScanner.nextLine();
					ArrayList<String> essay = new ArrayList<String>();
					ArrayList<String> errorList = new ArrayList<String>();
					//Dictionary dict = new Dictionary();
					while(fileScanner.hasNext()){
						essay.add(fileScanner.next());
					}
					for(int i = 0; i < essay.size(); i++){
						String word = essay.get(i);
						word = word.replace(".", "");
						word = word.replace(",", "");
						word = word.replace("!", "");
						word = word.replace("?", "");
						word = word.replace(":", "");
						word = word.replace(";", "");
						word = word.replace(" ", "");
						if(!(word.equals("I"))){
							word = word.toLowerCase();
						}
						if(dict.isWord(word) == false){
							errorList.add(word);
						}
					}
					student = new UndergraduateStudent(name,id,essay.toString(),errorList,major);
					fileScanner.close();
					available = false;
					return true;
				}
				
				
				fileScanner.close();
				//return true;
				
			}
			else{
				throw new FileNotFoundException();
			}
			
			
		}
		catch(FileNotFoundException ex){
			student = null;
			return false;
		}
	
		return false;
		
	}
	
	public boolean isAvailable(){
		return available;
	}
	
	public Student getStudent(){
		return student;
	}
	
	public void reset(){
		student = null;
		available = true;
	}
	
}
