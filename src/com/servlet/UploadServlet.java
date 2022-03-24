package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.database.FileVoDBHelp;
import com.entity.FileVo;
import com.entity.LoginUser;

/***
 * �ļ��ϴ�
 * @author Administrator
 *
 */
public class UploadServlet extends HttpServlet {
	
	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
	    //����Apache�ṩ��һ�� Commons-fileUpload ������������� API��
        //������ ��ȡdiskFileItemFactory ---> fileItemFactory
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        servletFileUpload.setSizeMax(1024*1024*600);    //�����ļ���С����
        servletFileUpload.setFileSizeMax(1024*1024*100); //�����ļ���С����
        servletFileUpload.setHeaderEncoding("UTF-8");  //��������
        
         //�жϿͻ����ύ��enctype ������multipart/form-data
        if (ServletFileUpload.isMultipartContent(request)) { 

        	//������ǰ�ļ��ϴ���request
            try {
				List<FileItem> list = servletFileUpload.parseRequest(request);
				
				String fileType = null;
				
				for(int i = 0; i < list.size(); i++){
					
					FileItem c = list.get(i);
					
					if (c.isFormField()){ //�ж��ļ�����
						
						 //����ͨ���ֶ�
                        System.out.println("c.getName() = " + c.getName());
                        System.out.println("c.getString() = " + c.getString()); //������
                        System.out.println("c.getFieldName() = " + c.getFieldName());
                        System.out.println("c.getContentType() = " + c.getContentType());
                        System.out.println("c.getSize() = " + c.getSize());
                        System.out.println("===================================");
                        
                        fileType = c.getString();
					
					}else {
						
						 System.out.println("c.getName() = " + c.getName());  //�ļ�����
	                     System.out.println("c.getFieldName() = " + c.getFieldName()); //��������
	                     System.out.println("c.getContentType() = " + c.getContentType());//�ļ�����
	                     System.out.println("c.getSize() = " + c.getSize());//�ļ���С
	                     System.out.println("==================================");
	                     
	                     
	                     File file = new File("D:\\test");  //���浽������
	                     
	                      //����ļ��в������򴴽�    
	                     if  (!file.exists() && !file.isDirectory())      
	                     {       
	                         System.out.println("//������");  
	                         file.mkdir();    
	                     } else   
	                     {  
	                         System.out.println("//Ŀ¼����");  
	                     }  
	                     
                                           
                         c.write(new File(file,c.getName()));
                         c.delete();  //ɾ������
                         
                         // ���ϴ����ļ���Ϣ���浽���ݿ���
                         FileVoDBHelp db = new FileVoDBHelp();
                         FileVo f = new FileVo();
                         
                         f.setName(c.getName());
                         f.setAddress(file.getAbsolutePath());
                         f.setType("3");
                         
                         HttpSession session = request.getSession();
                         
                         LoginUser lu = (LoginUser)session.getAttribute("lu");
                  	     String usercode = lu.getUsercode();
                  	     String realName = lu.getRealName();
                  	     
                  	     String pcode = (String)session.getAttribute("pcode");
                       
                	     f.setPcode(pcode);
                	     f.setFileType(fileType);
                                
                         f.setUsercode(usercode);
                         f.setRealName(realName);
                         f.setCreateTime(new Date().toLocaleString());
                         
                         db.update(f);

	
					}
				}
				
			} catch (Exception e) {
			
				e.printStackTrace();
			}
        	
        }else {
            System.out.println("δ����enctype");
        }
        
        request.getRequestDispatcher("admin/submitInfo.jsp").forward(request, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}














