package newlecture.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// "/*" :  ��� URL�� ���͸� ����
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain)
			throws IOException, ServletException {
		
		// ��û�� ���� �Ǵ� ����
		//System.out.println("before filter");
		
		// ������ ��� ������ ���ڵ� ���Ͱ� ����
		req.setCharacterEncoding("UTF-8");
		
		// ����Ǹ� ���� �����̳� ���Ͱ� ����ȴ� => ���������� ��Ȱ�ϱ� ���Ѱ�
		chain.doFilter(req, rep);
		
		// ���� ����� ���Ŀ� ����
		//System.out.println("after filter");

	}

}
