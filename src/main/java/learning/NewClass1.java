package learning;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class NewClass1 {

	public static void main(String[] args) {

		List<Student> list = new ArrayList();

		Function<String, Integer> fun = x -> x.length();

		System.out.println("fun===" + fun.apply("umbrella"));

		Function<String, String> fun1 = x -> x.substring(0, 3).toString();

		System.out.println("fun1===" + fun1.apply("APPLE"));

		Function<List<Student>, List<Student>> fun3 = li -> {

			for (Student s : li) {

				if (fun1.apply(s.getName()).equals("vip")) {
					list.add(s);
				}

			}
			return list;

		};
		
		
		List<Student> ss=new ArrayList<>();
		ss.add(new Student(1,"vipul"));
		ss.add(new Student(2,"vipddd"));
		ss.add(new Student(1,"mohit"));
		System.out.println("fun3==="+fun3.apply(ss));
		
		
		
	}
}

class Student {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	

}