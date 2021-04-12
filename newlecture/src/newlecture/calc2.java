package newlecture;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class add
 */
@WebServlet("/calc2")
public class calc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calc2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		
		// Session ��ü ����
		HttpSession session = request.getSession();
				
		//��Ű ���� ����
		Cookie[] cookies = request.getCookies();	
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		// �Է°��� ������� ���
		int v = 0;
		
		// ����ȯ
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		// ���
		if(op.equals("=")) {
			
				//int x = (Integer)application.getAttribute("value");
				//int x = (Integer)session.getAttribute("value");
				
				// ��Ű ã��
				int x = 0;
				for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x =Integer.parseInt(c.getValue());
					break;
					}
				}
					
					
				int y = v;
				//String operator = (String)application.getAttribute("op");
				//String operator = (String)session.getAttribute("op");
				
				String operator="";
				for(Cookie c : cookies) {
					if(c.getName().equals("op")) {
						operator =c.getValue();
						break;
						}
					}
				
				
				int result = 0;
						
			if(operator.equals("+")) {
				 result = x + y;
			}else {
				 result = x - y;
			}response.getWriter().printf("result : %d\n" , result);
			
		// ���� ����
		}else {
		// ServletContext : applicaiont �����
		
		//application.setAttribute("value", v);
		//application.setAttribute("op", op);
			
//		session.setAttribute("value", v);
//		session.setAttribute("op", op);
		
		// ��Ű ����
		// cookie : ���ڿ��� ���尡��
		Cookie valueCookie = new Cookie("value",String.valueOf(v));
		Cookie opCookie = new Cookie("op",op);
		
		// ��Ű�� � ��쿡 Ŭ���̾�Ʈ�� ���޵Ǿ�� �ϴ��� ����
		//valueCookie.setPath("/"); // ("/") : ����������� ��û�� �� ���� valueCookie�� ��������� ����
		//opCookie.setPath("/");
		valueCookie.setPath("/calc2"); // calc2������ ��Ű �����ϴ� ����
		valueCookie.setMaxAge(24*60*60); // ��Ű ����ð� ���� ,(24*60*60) : 24�ð� => �������ϸ� ������ ������ ��Ű�� �����ȴ�
		opCookie.setPath("/calc2");
		
		// ��Ű Ŭ���̾�Ʈ�� ������
		response.addCookie(valueCookie);
		response.addCookie(opCookie);
		
		// redirection ��� : ������ �̵���� => +,-����� �������� ���޹�������
		response.sendRedirect("calc2.html");
		}
	}

}
