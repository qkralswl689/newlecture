package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	//@Autowired : 자동으로 객체 연결 => 셋터위,필드위(기본생성자를 호출한다),오버로드 생성자 위에 사용가능
	//@Autowired(required = false) : 객채가 없어도 설정되어있는 값으로 출력
	@Autowired
	// @Qualifier("exam1") : exam1 이름(id)를 가진 객체 연결, 오버로드 생성자에 사용할 경우 : 매개변수 앞에 Qualifier 붙힌다
	//@Qualifier("exam1")
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("constructor");
	}

	
	public InlineExamConsole(Exam exam) {
		System.out.println("overload");
		this.exam = exam;
	}


	@Override
	public void print() {
		if(exam==null)
			System.out.printf("total is %d, avg is %f\n", 0,0.0);
		else
			System.out.printf("total is %d, avg is %f\n", exam.total(),exam.avg());

	}
	
	
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}

}
