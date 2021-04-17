package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program {

	public static void main(String[] args) {
		
		Exam exam = new NewlecExam(1,1,1,1);
		
		// NewlecExam에서 하던거 가져옴
		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(),
											new Class[] {Exam.class},
											new InvocationHandler() {
												
												@Override
												public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
													
													long start = System.currentTimeMillis(); // 시작시간 구하는것
													
													Object result = method.invoke(exam, args);
													
													long end = System.currentTimeMillis(); // 작업 마치는 시간 구하는것
													
													String message = (end-start) + "ms 시간이 걸렸습니다.";
													
													System.out.println(message);
													
													return result;
												}
											}); // 가상으로 exam과 같은 내용을 가진 객체를 만든다
		
		System.out.printf("total is %d ",proxy.total());
	}

}
