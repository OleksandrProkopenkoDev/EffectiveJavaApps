package methodsPart2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



class Student{
	String name;
	int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	int getScore() {
		return score;
	}
}

public class ParallelStream {

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(
				new Student("David", 82),
				new Student("Bob", 90),
				new Student("John", 65),
				new Student("Kenedy", 55),
				new Student("Eric", 85),
				new Student("Smith", 88),
				new Student("Scott", 88),
				new Student("Gos", 87)
				);
		
//		using stream - sequential
		students.stream()
				.filter(s->s.getScore()>=80)
				.sorted(Comparator.comparing(Student::getScore).reversed() )
				.limit(3)
				.forEach(s->System.out.println(s.getName()+" "+s.getScore()));
//		using stream parallel
		students.parallelStream()
		.sorted(Comparator.comparing(Student::getScore).reversed() )
		.filter(s->s.getScore()>=80)
		.limit(3)
		.forEach(s->System.out.println(s.getName()+" "+s.getScore()));
		
		
	}

}
