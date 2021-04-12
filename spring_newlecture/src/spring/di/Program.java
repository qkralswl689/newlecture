package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코드를 변경
		 * // 인터페이스용으로 
		 * Exam exam = new NelecExam();
		 * 
		 * // exam 출력하는 console
		 * ExamConsole console = new GridExamConsole(); 
		 * 
		 * // setter를통해 생성
		 * console.setExam(exam);
		 */
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		ExamConsole console =(ExamConsole) context.getBean("console"); // 이름으로 꺼내기
		//ExamConsole console =context.getBean(ExamConsole.class); // 자료형 명으로 꺼내기 : 선호 방식
		
		console.print();

	}

}
