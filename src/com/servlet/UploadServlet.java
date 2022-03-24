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
 * 文件上传
 * @author Administrator
 *
 */
public class UploadServlet extends HttpServlet {
	
	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
	    //借助Apache提供的一套 Commons-fileUpload 组件，性能优异 API简单
        //工厂类 获取diskFileItemFactory ---> fileItemFactory
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        servletFileUpload.setSizeMax(1024*1024*600);    //总体文件大小限制
        servletFileUpload.setFileSizeMax(1024*1024*100); //单个文件大小限制
        servletFileUpload.setHeaderEncoding("UTF-8");  //中文乱码
        
         //判断客户端提交的enctype 必须是multipart/form-data
        if (ServletFileUpload.isMultipartContent(request)) { 

        	//解析当前文件上传的request
            try {
				List<FileItem> list = servletFileUpload.parseRequest(request);
				
				String fileType = null;
				
				for(int i = 0; i < list.size(); i++){
					
					FileItem c = list.get(i);
					
					if (c.isFormField()){ //判断文件类型
						
						 //是普通表单字段
                        System.out.println("c.getName() = " + c.getName());
                        System.out.println("c.getString() = " + c.getString()); //表单内容
                        System.out.println("c.getFieldName() = " + c.getFieldName());
                        System.out.println("c.getContentType() = " + c.getContentType());
                        System.out.println("c.getSize() = " + c.getSize());
                        System.out.println("===================================");
                        
                        fileType = c.getString();
					
					}else {
						
						 System.out.println("c.getName() = " + c.getName());  //文件名称
	                     System.out.println("c.getFieldName() = " + c.getFieldName()); //表单域名称
	                     System.out.println("c.getContentType() = " + c.getContentType());//文件类型
	                     System.out.println("c.getSize() = " + c.getSize());//文件大小
	                     System.out.println("==================================");
	                     
	                     
	                     File file = new File("D:\\test");  //保存到磁盘上
	                     
	                      //如果文件夹不存在则创建    
	                     if  (!file.exists() && !file.isDirectory())      
	                     {       
	                         System.out.println("//不存在");  
	                         file.mkdir();    
	                     } else   
	                     {  
	                         System.out.println("//目录存在");  
	                     }  
	                     
                                           
                         c.write(new File(file,c.getName()));
                         c.delete();  //删除缓存
                         
                         // 将上传的文件信息保存到数据库中
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
            System.out.println("未设置enctype");
        }
        
        request.getRequestDispatcher("admin/submitInfo.jsp").forward(request, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}














