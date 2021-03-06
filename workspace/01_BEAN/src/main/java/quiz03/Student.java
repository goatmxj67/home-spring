package quiz03;

import java.util.Map;

public class Student {

	private String name;
	private int age;
	private Map<String, String> home;  // 주소, 전화번호
	private Exam exam;
	
	public void info() {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		for (Map.Entry<String, String> entry : home.entrySet()) {
			System.out.println("home's " + entry.getKey() + ": " + entry.getValue());
		}
		exam.info();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Map<String, String> getHome() {
		return home;
	}
	public void setHome(Map<String, String> home) {
		this.home = home;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
}
