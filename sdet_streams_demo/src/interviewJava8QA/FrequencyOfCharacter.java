package interviewJava8QA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfCharacter {

	public static void main(String[] args) {
		String input = "Find frequency of characters in this string";
//		we need to display list of characters and the count of each character in the input string
//	1 transform string into list
		List<Character> inputCharacters = new ArrayList<>();
		for(int i = 0; i< input.length(); i++) {
			inputCharacters.add(input.charAt(i));
		}
		System.out.println("input string as List");
		System.out.println(inputCharacters);
		
//		2 create a list with unique symbols
		List<Character> uniqueChars = 
				inputCharacters.stream()
					.distinct()
					.collect(Collectors.toList());
		System.out.println("filtered to distinct characters");
		System.out.println(uniqueChars);
		
//	3 calculate number of each symbol
		List<Integer> charsFrequency =
				uniqueChars.stream()
					.map(c->{
						int count = 0;
						for(char ch: inputCharacters) {
							if(c == ch) count++;
						}
						return count;
						})
					.collect(Collectors.toList());
	
		System.out.println(charsFrequency);
		
//		----------------------------------other solution-------
		
		Map<String, Long> countMap = Arrays.stream(input.split("")) //input.split("") - converts String to array of chars, separeted by ""
				.collect(Collectors.groupingBy(
						Function.identity(), Collectors.counting()));		
		System.out.println(countMap);
	}
		
	
}
