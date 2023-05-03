package methodsPart2;

import java.util.HashSet;
import java.util.Set;

public class Match {

	public static void main(String[] args) {
		//returns true or false
		
		Set<String> fruits = new HashSet<>();
		fruits.add("One apple");
		fruits.add("One mango");
		fruits.add("Two apples");
		fruits.add("More grapes");
		fruits.add("Two guavas");
		
		//any match
		boolean anyMatch = fruits.stream()
			  .anyMatch(value-> value.startsWith("One")); //at least one value should start with 'one'
		System.out.println("any match with 'One': "+anyMatch);	  
		//all match
		boolean allMatch = fruits.stream()
				  .allMatch(value-> value.startsWith("One")); //all values should start with 'one'
		System.out.println("all match with 'One': "+allMatch);	  
		//none match	
		boolean noneMatch = fruits.stream()
				  .noneMatch(value-> value.startsWith("One")); //none values should start with 'one'
		System.out.println("none match with 'One': "+noneMatch);	  
		
		
		
	}

}
