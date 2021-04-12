package newlecture;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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
@WebServlet("/calc3")
public class calc3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calc3() {
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
		//��Ű �迭���� ����
		Cookie[] cookies = request.getCookies();	
		
		// ����ڰ� �Է��� ���� ������
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		// ��Ű�� ����� exp�� �����Ѵ�
		String exp ="";
		// ��Ű �о���¿����
		if(cookies !=null) { // ��Ű�� null�� �ƴҰ��
			for(Cookie c : cookies) { // ����� ����
				if(c.getName().equals("exp")) {
					exp =c.getValue();
					break;
					}
				}
		}
		if(operator !=null && operator.equals("=")) {
			
			// ���
			// javaScript ���� ���� ��ü ����
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(operator !=null && operator.equals("C")) { // ��Ű ���� : C��ưŬ�� �� �ʱ�ȭ
			exp = "";
		}
		else {
			// �Է°� ����
			exp += (value == null) ? "" : value;
			exp += (operator == null) ? "" : operator;
			exp += (dot == null) ? "" : dot;
		}

		
		
		// ��Ű����
		Cookie expCookie = new Cookie("exp",exp);
		if(operator !=null && operator.equals("C")) { // ���ǿ� �ش� �� ����
			expCookie.setMaxAge(0); // ��Ű����(����������)
		}
		
		//expCookie.setPath("/");
		
		// ��Ű�� ����
		response.addCookie(expCookie);
		
		// redirection ��� : ������ �̵���� => +,-����� �������� ���޹�������
		response.sendRedirect("calcpage");
		}
	}


