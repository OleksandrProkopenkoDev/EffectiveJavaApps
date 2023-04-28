package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Person> people = getPeople();
//		Imperative approach
		/*
		 * List<Person> females = new ArrayList<>(); for(Person person : people) {
		 * if(person.getGender().equals(Gender.FEMALE)) { females.add(person); } }
		 * 
		 * females.forEach(System.out::println);
		 */
//		Declerative approach
		List<Person> females = people.stream()
			.filter(person->person.getGender().equals(Gender.FEMALE))
			.collect(Collectors.toList());
//		filter
//		females.forEach(System.out::println);
//		sort
		List<Person> sorted = people.stream()
			.sorted(Comparator.comparing(Person::getGender)
					.thenComparing(Person::getAge)
					.reversed())
			.collect(Collectors.toList());
//		sorted.forEach(System.out::println);
		
		//		all match
		boolean allMatch =  people.stream()
			.allMatch(person -> person.getAge() > 5);
//		System.out.println("All match (age>5) "+allMatch);
//		any match
		boolean anyMatch =  people.stream()
				.anyMatch(person -> person.getAge() > 12);
//			System.out.println("Any match (age>12) "+anyMatch);
		
//		none match
		boolean noneMatch =  people.stream()
				.noneMatch(person -> person.getName().equals("Antonio"));
//			System.out.println("none match (name = Antonio) "+noneMatch);
		
		
		
		//		max
			
			people.stream()
			.max(Comparator.comparing(Person::getAge))
			.ifPresent(System.out::println);
			
//		min
			people.stream()
			.min(Comparator.comparing(Person::getAge))
			.ifPresent(System.out::println);
			
//		group
			Map<Gender, List<Person>> groupByGender = people.stream()
				.collect(Collectors.groupingBy(Person::getGender));
			groupByGender.forEach((gender, people1) -> {
				System.out.println(gender);
				people1.forEach(System.out::println);
				System.out.println();
			});
			
//			return String, where oldest Female first name is
			Optional<String> oldestFemale = people.stream()
				.filter(person -> person.getGender().equals(Gender.FEMALE))
				.max(Comparator.comparing(Person::getAge))
				.map(Person::getName);
			oldestFemale.ifPresent(System.out::println);
	}

	private static List<Person> getPeople(){
		return List.of(
				new Person("James Bond", 20, Gender.MALE),
				new Person("Alina Smith", 33, Gender.FEMALE),
				new Person("Helen White", 57, Gender.FEMALE),
				new Person("Alex Boz", 14, Gender.MALE),
				new Person("Jamie Goa", 99, Gender.MALE),
				new Person("Anna Cook", 7, Gender.FEMALE),
				new Person("Zelda Brown", 120, Gender.FEMALE)
				);
	}
}
