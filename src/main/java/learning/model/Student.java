package learning.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Student {

	private String name;
	private int id;
	public static List<Student> studentList;
	
	static{
		studentRepository();
	}
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student() {}
	
	private static void studentRepository(){
		studentList = new ArrayList<>(asList(new Student("Guilherme", 0), new Student("Henrique", 1), new Student("Rebeca", 2)));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && this.getClass() == obj.getClass() && this.getId() == ((Student)obj).getId())
			return true;
		return false;
	}
}
