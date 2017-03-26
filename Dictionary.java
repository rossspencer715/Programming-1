//Name: Ross Spencer
//UFL ID: 91091549
//Section: 11H6
//Project Number: 5
//Brief description of file contents: Reads a file and saves it as a dictionary ArrayList

import java.util.ArrayList; 
import java.io.*;
import java.util.Scanner;

public class Dictionary {
	private ArrayList<String> dictionary = new ArrayList<>();
	
	public boolean loadDictionaryFromFile(String filePath){
		File dict = null;
		try {
			dict = new File(filePath);
			Scanner s = new Scanner(dict);
			while (s.hasNext()){
			    dictionary.add(s.next());
			}
			s.close();
		}
		catch(FileNotFoundException exception){
	        return false;
	    }
		return true;
		
	}
	
	
	public int getVocabularySize(){
		int size = 0;
		for(String i:dictionary){
			size++;
		}
		
		return size;
	}
	
	public boolean isWord(String word){
		
		for(int i = 0; i < dictionary.size(); i++){
			
			if(word.equals(dictionary.get(i))){
				return true;
			}
		}
		
		return false;
	}

}

