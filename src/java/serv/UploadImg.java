/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.PrintWriter;
import java.util.Base64;
  
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

/**
 *
 * @author lee
 */
public class UploadImg extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Cookie cookie = null;
            Cookie[] cookies = null;
             // 获取当前域名下的cookies，是一个数组
            cookies = request.getCookies();
            String tel="";
            if(cookies!=null)
            {
                for(int i=0;i<cookies.length;i++)
                {
                    cookie = cookies[i];
                    if(("tel").equals(cookie.getName()))
                    {
                        tel=cookie.getValue();
                    }
                }
            }
            if(tel.equals(""))
            {
                response.getWriter().print(wrapJSON(false));  
                return;
            }
            
            /* TODO output your page here. You may use following sample code. */
            String image = request.getParameter("image");   
            String header ="data:image/jpeg;base64,";   
            if(image.indexOf(header) != 0){  
                response.getWriter().print(wrapJSON(false));  
                return;  
            }  
            // 去掉头部  
            image = image.substring(header.length());  
            // 写入磁盘  
            boolean success = false;  
            Base64.Decoder decoder = Base64.getDecoder();  
            try{  
                byte[] decodedBytes = decoder.decode(image);  
                String imgFilePath = "C://userimg//"+tel+".jpg";
                FileOutputStream outp = new FileOutputStream(imgFilePath);  
                outp.write(decodedBytes);  
                outp.close();  
                success = true;  
            }catch(Exception e){  
                success = false;  
                e.printStackTrace();  
            } 
            response.getWriter().print(wrapJSON(success));  
        }  
        
        
    }
    private String wrapJSON(boolean success){  
        if(success)
        {
            return "{\"success\":\"头像上传成功！\"}"; 
        }
        else
        {
            return "{\"success\":\"头像上传失败！\"}"; 
        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
