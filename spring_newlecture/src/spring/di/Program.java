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
		
		/* ���������� �����ϴ� ������� �ڵ带 ����
		 * // �������̽������� 
		 * Exam exam = new NelecExam();
		 * 
		 * // exam ����ϴ� console
		 * ExamConsole console = new GridExamConsole(); 
		 * 
		 * // setter������ ����
		 * console.setExam(exam);
		 */
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		ExamConsole console =(ExamConsole) context.getBean("console"); // �̸����� ������
		//ExamConsole console =context.getBean(ExamConsole.class); // �ڷ��� ������ ������ : ��ȣ ���
		
		console.print();

	}

}
