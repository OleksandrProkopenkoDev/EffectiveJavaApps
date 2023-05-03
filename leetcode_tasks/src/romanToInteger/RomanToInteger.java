package romanToInteger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RomanToInteger {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("III", "LVIII", "MCMXCIV");
		List<Integer>output = input.stream()
									.map(str->romanToInt(str))
									.collect(Collectors.toList());
		System.out.print("input: ");
		System.out.println(input);
		
		System.out.print("output: ");
		System.out.println(output);
		
	}
	
    private static int romanToInt(String s) {
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);
        symbols.put('O', 0);
        
//        iterate for each symbol of entry string
        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	char currentChar = s.charAt(i);
        	char nextChar = 'O';
        	if(i<s.length()-1)nextChar = s.charAt(i+1);
        	
        	int currentNum = symbols.get(currentChar); 
        	int nextNum = symbols.get(nextChar);
        	
        	if( currentNum>=nextNum) {
        		result = result + currentNum;
        	}else {
        		result = result - currentNum + nextNum;       		
        		i++;      		
        	}      	       	        	
        }       
        return result;
    }

}
