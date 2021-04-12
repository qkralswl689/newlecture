package newlecture;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// �Է°��� �Է� ���� ���
		// cnt : �Է°� -> ������ ���ڿ��� ���޵ȴ�  => Integer�� ����ȯ
//		int cnt = Integer.parseInt(req.getParameter("cnt"));
//		
//		for(int i=0; i<cnt; i++) {
//			out.println((i+1) + ": �ȳ� Servlet!!<br >");
		
		// �Է°��� �Է� �� ���� ���
		
		String cnt_ = req.getParameter("cnt"); // �ӽú��� ����
		
		int cnt = 10; // �⺻�� ����
		if(cnt_ != null && !cnt_.equals("")) { // cnt_�� ����  null�� �ƴϰų� ���ڿ��� �ƴҰ��
			cnt = Integer.parseInt(cnt_); // cnt_�� ���� cnt(�⺻��)���� �����Ѵ�
		}
		
		for(int i=0; i<cnt; i++) {
			out.println((i+1) + ": �ȳ� Servlet!!<br >");
		}
	
	}
}

