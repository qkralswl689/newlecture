package com.newlecture.web.controller.admin.notice;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@MultipartConfig(
		fileSizeThreshold=1024*1024, // �޸𸮰� 1mb�϶��� ������ �������Ѵ�
		maxFileSize=1024*1024*50, // 50mb�� ������ �ϳ��� �ִ� ũ��
		maxRequestSize=1024*1024*50*5 // ���� ��ü �뷮�� 50mb 5�� -> 250mb ���� ����
)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// forward
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		
		Collection<Part> parts = request.getParts();
		
		StringBuilder builder = new StringBuilder();
		
		for(Part p : parts) {
			if(!p.getName().equals("file")) continue;
			if(p.getSize() == 0) continue;
			
		Part filePart = p;
		
		String fileName = filePart.getSubmittedFileName();
		builder.append(fileName);
		builder.append(",");
		
		
		InputStream fis = filePart.getInputStream();
		
		String realPath = request.getServletContext().getRealPath("/member/upload");
		System.out.println(realPath);
		
		File path = new File(realPath);
		if(!path.exists())
			path.mkdirs();
		
		
		String filePath = realPath +File.separator +  fileName;
		FileOutputStream fos = new FileOutputStream(filePath);
		
		// read() : 1byte���� ��´�
		// 1024byte : 1Ű�ι���Ʈ
		byte[] buf = new byte[1024]; 
		int size = 0;
		while((size = fis.read(buf)) !=-1)
			fos.write(buf,0,size ); // size�� ���̸�ŭ �ݺ��ؼ� �����Ѵ�
		
		fos.close();
		fis.close();
		}	
		
		builder.delete(builder.length()-1,builder.length());
		
		boolean pub = false;
		  
		if(isOpen != null)
			pub = true;
		 

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub); 
		notice.setWriterId("newlec");
		notice.setFiles(builder.toString()); 

		  NoticeService service = new NoticeService(); 
		  int result = service.insertNotice(notice);
		 
		 response.sendRedirect("list"); 
	}
}
