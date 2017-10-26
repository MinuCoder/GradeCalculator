import java.text.DecimalFormat;
import java.util.HashMap;

public class GradeCalculator {
	static HashMap<String, Double> Last_grade = new HashMap();	// �л��� �����б���� ���� ����
	static HashMap<String, Integer> Last_credit = new HashMap();	// �л����� �����б���� �̼����� ����
	static HashMap<String, Double> Subject_grade = new HashMap();	// ����� ����
	static HashMap<String, Integer> Subject_credit = new HashMap();	// ����� ũ����
	
	double last_grade;
	int last_credit;
	
	double subject_sum;	// �� ���� �հ�
	double credit_sum;	// ũ���� �հ�
	double subject_grade;	// ����� ����
	double subject;	// �� ����
	double average;	// �̹��б� ���

	public GradeCalculator(String name, double grade, int credit) {
		last_grade=grade;
		last_credit=credit;
		GradeCalculator.Last_grade.put(name, grade);
		GradeCalculator.Last_credit.put(name, credit);
	}

	public void addCourse(Course course) {
		
		switch(course.grade) {
			case "A+": subject_grade = 4.5; break;
			case "A": subject_grade = 4.0; break;
			case "B+": subject_grade = 3.5; break;
			case "B": subject_grade = 3.0; break;
			case "C+": subject_grade = 2.5; break;
			case "C": subject_grade = 2.0; break;
			case "D+": subject_grade = 1.5; break;
			case "D": subject_grade = 1.0; break;
			case "F": subject_grade = 0.0; break;
		}
		GradeCalculator.Subject_grade.put(course.subject, subject_grade);
		GradeCalculator.Subject_credit.put(course.subject, course.credit);
		
		// �̹� �б� ���� ���
		subject=course.credit*subject_grade;
		credit_sum+=course.credit;
		subject_sum+=subject;
		average=subject_sum/credit_sum;
	}

	public void print() {
		DecimalFormat format = new DecimalFormat(".##########");

		System.out.println("���� �б� ����: " + last_grade + " (�� " + last_credit + "����)");
		System.out.println("�̹� �б� ����: " + format.format(average) + " (�� " + (int)credit_sum + "����)");
		System.out.println("��ü ���� ����: " + format.format((subject_sum+last_grade*last_credit)/(credit_sum+last_credit)) + " (�� " + (int)(credit_sum+last_credit) + "����)");
	}

}
