package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo2 {

	public static void main(String[] args) {
//		multiple conditions
		List<String> names = Arrays.asList("Melisandre", "Sansa", "Jon", "Dayenerys", "Joffery");
		List<String> longNames = new ArrayList<String>();
		/*
		 * longNames = names.stream() .filter(str-> str.length()>6 && str.length()<8)
		 * .collect(Collectors.toList()); System.out.println(longNames);
		 */
		names.stream()
			.filter(str-> str.length()>6 && str.length()<8)
			.forEach(str->System.out.println(str));

		names.stream()
			.filter(str-> str.length()>6 && str.length()<8)
			.forEach(System.out::println);
	}

}
