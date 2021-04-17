package spring.aop.entity;

import org.springframework.stereotype.Controller;

@Controller
public class NewlecExam implements Exam {

	
	private int kor;
	private int eng;
	private int math;
	private int com;
	
	public NewlecExam() {
		// TODO Auto-generated constructor stub
	}
	
	
	public NewlecExam(int kor, int eng, int math, int com) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}


	@Override
	public String toString() {
		return "NewlecExam [kor=" + kor + ", eng=" + eng + ", math=" + math + ", com=" + com + "]";
	}


	@Override
	public int total() {
		//long start = System.currentTimeMillis(); // 시작시간 구하는것
		
		int result =  kor+eng+math+com;
		
		try { // 테스트 위해 고의로 스레드 생성
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//long end = System.currentTimeMillis(); // 작업 마치는 시간 구하는것
		
		//String message = (end-start) + "ms 시간이 걸렸습니다.";
		
		//System.out.println(message);
		return result;
	}

	@Override
	public float avg() {
		float result = total()/4.0f;
		return result;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

}