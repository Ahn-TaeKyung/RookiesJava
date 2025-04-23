package lab.student.entity;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	public Student(String studentId, String name, String major, int grade) {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.grade = grade;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if(grade > 4) {
			System.out.println("�г��� 1~4 ���̿��� �մϴ�.");
		}
		else {
			this.grade = grade;	
		}
	}
	public String getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	
}
