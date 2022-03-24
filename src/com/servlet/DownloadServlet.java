package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 文件下载
 * @author Administrator
 *
 */
public class DownloadServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		response.setCharacterEncoding("UTF-8");
		
		String fileName = request.getParameter("fileName");
		fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
		
		System.out.println(fileName);	

        response.setHeader("content-disposition","attachment;fileName=" +fileName);  //打开文件保存窗口
        FileInputStream fileInputStream = new FileInputStream("D:\\test\\" + fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();
        outputStream.close();
        
//        response.sendRedirect("admin/submitInfo.jsp");
//        request.getRequestDispatcher("admin/submitInfo.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}














