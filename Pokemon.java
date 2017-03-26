//Name: Ross Spencer
//UFL ID: 91091549
//Section: 11H6
//Project Number: 4
//Brief description of file contents: Allows field agents to keep track of the strange new Pokemon they encounter on their journies.

public class Pokemon {
	String species; 
	int attack, defense, speed;
	
	public Pokemon(String species){
		this.species = species;
		attack = (species.length()*4) + 2;
		defense = (species.length()*2) + 7;
		speed = (species.length()*3) + 5;
	}
	
	public Pokemon(){
		
	}
	
	public void grow(int boost){
		attack += boost;
	}
	
	public void harden(int boost){
		defense += boost;
	}
	
	public void haste(int boost){
		speed += boost;
	}
	
	public String getSpecies(){
		return species;
	}
	
	public void setSpecies(String spc){
		species = spc;
	}
	
	public int getAttack(){
		return attack;
	}
	
	public void setAttack(int atk){
		attack = atk;
	}
	
	public int getDefense(){
		return defense;
	}
	
	public void setDefense(int def){
		defense = def;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void setSpeed(int spd){
		speed = spd;
	}

	
}
