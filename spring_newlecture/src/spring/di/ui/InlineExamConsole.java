package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	//@Autowired : �ڵ����� ��ü ���� => ������,�ʵ���(�⺻�����ڸ� ȣ���Ѵ�),�����ε� ������ ���� ��밡��
	//@Autowired(required = false) : ��ä�� ��� �����Ǿ��ִ� ������ ���
	@Autowired
	// @Qualifier("exam1") : exam1 �̸�(id)�� ���� ��ü ����, �����ε� �����ڿ� ����� ��� : �Ű����� �տ� Qualifier ������
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
