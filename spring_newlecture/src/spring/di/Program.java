package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코트를 변경
		 * // 인터페이스용으로 
		 * Exam exam = new NelecExam();
		 * 
		 * // exam 출력하는 console
		 * ExamConsole console = new GridExamConsole(); 
		 * 
		 * // setter를통해 생성
		 * console.setExam(exam);
		 */
		
		console.print();

	}

}
