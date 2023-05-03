package flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student{
	String name;
	int id;
	char grade;

	public Student(String name, int id, char grade) {
		this.name = name;
		this.id = id;
		this.grade = grade;
	}
	
	
}

public class FlatmapDemo3 {

	public static void main(String[] args) {

		List<Student> students1 = new ArrayList<>();
		students1.add(new Student("Smith", 1, 'B'));
		students1.add(new Student("John", 2, 'A'));
		students1.add(new Student("Kenedy", 3, 'C'));
		
		List<Student> students2 = new ArrayList<>();
		students2.add(new Student("Scott", 4, 'B'));
		students2.add(new Student("Mary", 5, 'A'));
		students2.add(new Student("Kitty", 6, 'C'));
		
		List<List<Student>> groups = Arrays.asList(students1, students2);
		//need retrieve students names
		//before java 8
		for(List<Student> s:groups) {
			for(Student stu :s) {
				System.out.println(stu.name);
			}
		}
		//using flatmap
		List<String> names = groups.stream()
			  .flatMap(list->list.stream().map(s->s.name))
			  .collect(Collectors.toList());
		System.out.println(names);
	}

}
