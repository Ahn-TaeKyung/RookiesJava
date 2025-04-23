package lab.student.control;

import lab.student.entity.Student;

public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student("20517045", "안태경", "컴퓨터SW", 4);
		
		System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");
		System.out.println("5학년으로 변경");
		student.setGrade(5);
	}
}
