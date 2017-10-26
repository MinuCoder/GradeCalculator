
public class Course {
	static int CREDIT_GENERAL = 2;
	static int  CREDIT_MAJOR = 3;
	String subject;
	int  credit;
	String grade;
	
	public Course(String subject, int credit, String grade) {
		this.subject = subject;
		this.credit = credit;
		this.grade = grade;
	}
}
