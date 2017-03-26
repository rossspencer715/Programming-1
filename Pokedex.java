//Name: Ross Spencer
//UFL ID: 91091549
//Section: 11H6
//Project Number: 4
//Brief description of file contents: Allows field agents to keep track of the strange new Pokemon they encounter on their journies.

public class Pokedex {
	Pokemon[] pokeray;
	int addedPokemon;
	public Pokedex(int size){
		pokeray = new Pokemon[size];
		
		for (int i=0; i < size; i++){
		    pokeray[i]= new Pokemon(" ");  // create each actual Pokemon, need to not have null names for sort method to work :(
		}
		
		addedPokemon = 0;
	}
	
	public String[] listPokemon(){
		String[] names = new String[addedPokemon];
		if(addedPokemon == 0){
			return null;
		}
		if(addedPokemon > 0){
			for(int i = 0; i < addedPokemon; i++){
				names[i] = pokeray[i].getSpecies();
			}
		}
		/*String[] names = new String[pokeray.length]; //test sort by printing all 10 Pokemon names
		if(addedPokemon == 0){
			return null;
		}
		if(addedPokemon > 0){
			for(int i = 0; i < pokeray.length; i++){
				names[i] = pokeray[i].getSpecies();
			}
		}*/
		return names;
		
	}
	
	public boolean addPokemon(String species){
		
		if(addedPokemon < pokeray.length){
			
			boolean containsSpecies = false;
			for(int i = 0; i < pokeray.length; i++){
				if(species.equalsIgnoreCase(pokeray[i].getSpecies())){
					containsSpecies = true;
				}
			}
			if(containsSpecies == true){
				System.out.println("Duplicate");
				return false;
				
			}		
		
			else{
				
				pokeray[addedPokemon].setSpecies(species);
				pokeray[addedPokemon].setAttack((species.length()*4) + 2);//I'd rather do this since I already created Pokemon of species " " and don't want to waste resources to make all new ones
				pokeray[addedPokemon].setDefense((species.length()*2) + 7);
				pokeray[addedPokemon].setSpeed((species.length()*3) + 5);
				addedPokemon += 1;
				return true;
			}
		}
		
		else {
			System.out.println("Max");
			return false;
		}
	}
	public int[] checkStats(String species){
		int[] stats = new int[3];
		boolean containsSpecies = false;
		int location = 0;
		for(int i = 0; i < pokeray.length; i++){
			if(species.equalsIgnoreCase(pokeray[i].getSpecies())){
				containsSpecies = true;
				location = i;
			}
		}
		if(containsSpecies == true){
			stats[0] = pokeray[location].getAttack();
			stats[1] = pokeray[location].getDefense();
			stats[2] = pokeray[location].getSpeed();
			return stats;
		}
		else{
			return null;
		}
		
		
	}
	
	public void sortPokemon(){
		for (int i = 0; i < addedPokemon - 1; ++i) {
			int minIndex = i;
		    for (int j = i + 1; j < addedPokemon; ++j) {
		    	String pokemonSpecies1 = pokeray[minIndex].getSpecies();
		    	String pokemonSpecies2 = pokeray[j].getSpecies();
		    	if (pokemonSpecies2.compareToIgnoreCase(pokemonSpecies1) < 0) {
		    		minIndex = j;
		    	}
		     }
		      // int changed to String
		     Pokemon temp = pokeray[i];
		     pokeray[i] = pokeray[minIndex];
		     pokeray[minIndex] = temp;
		    }
	}
	
	
}
