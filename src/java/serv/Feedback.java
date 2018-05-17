/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author princess
 */
public class Feedback extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String content = request.getParameter("content");//用request得到 
            content = new String(content.getBytes("ISO-8859-1"),"utf-8"); 
            
            Cookie cookie = null;
            Cookie[] cookies = null;
             // 获取当前域名下的cookies，是一个数组
            cookies = request.getCookies();
            String name="";
            if(cookies!=null)
            {
                for(int i=0;i<cookies.length;i++)
                {
                    cookie = cookies[i];
                    if(("name").equals(cookie.getName()))
                    {
                        name=URLDecoder.decode(cookie.getValue(),"UTF-8");
                    }
                }
        }
        String str="{\"content\":\""+content+"\"}\r\n";
        message mg = new message("admin",name,"用户<"+name+">提交了反馈<"+content+">", "feedback_notice","false");
        mg.messageSend();
        FileWriter writer = new FileWriter(STATIC.mdir+"FeedBacks.txt", true);  
        writer.write(str);  
        writer.close();
        response.sendRedirect("feedback.jsp?success=1");
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
