import java.text.DecimalFormat;
import java.util.HashMap;

public class GradeCalculator {
	static HashMap<String, Double> Last_grade = new HashMap();	// 학생의 이전학기들의 성적 저장
	static HashMap<String, Integer> Last_credit = new HashMap();	// 학생들의 이전학기들의 이수학점 저장
	static HashMap<String, Double> Subject_grade = new HashMap();	// 과목당 성적
	static HashMap<String, Integer> Subject_credit = new HashMap();	// 과목당 크레딧
	
	double last_grade;
	int last_credit;
	
	double subject_sum;	// 총 점수 합계
	double credit_sum;	// 크레딧 합계
	double subject_grade;	// 과목당 학점
	double subject;	// 총 점수
	double average;	// 이번학기 평균

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
		
		// 이번 학기 학점 계산
		subject=course.credit*subject_grade;
		credit_sum+=course.credit;
		subject_sum+=subject;
		average=subject_sum/credit_sum;
	}

	public void print() {
		DecimalFormat format = new DecimalFormat(".##########");

		System.out.println("직전 학기 성적: " + last_grade + " (총 " + last_credit + "학점)");
		System.out.println("이번 학기 성적: " + format.format(average) + " (총 " + (int)credit_sum + "학점)");
		System.out.println("전체 예상 학점: " + format.format((subject_sum+last_grade*last_credit)/(credit_sum+last_credit)) + " (총 " + (int)(credit_sum+last_credit) + "학점)");
	}

}
