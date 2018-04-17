/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.*;
import java.io.*;
import javax.servlet.http.Cookie;
/**
 *
 * @author lee
 */
public class insertNewQues extends HttpServlet {

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
            String title = request.getParameter("title");//用request得到 
            title = new String(title.getBytes("ISO-8859-1"),"utf-8"); 
	    String classes = request.getParameter("classes");//用request得到 
            classes = new String(classes.getBytes("ISO-8859-1"),"utf-8"); 
	    String optionA = request.getParameter("optionA");//用request得到 
            optionA = new String(optionA.getBytes("ISO-8859-1"),"utf-8"); 
            String optionB = request.getParameter("optionB");//用request得到 
            optionB = new String(optionB.getBytes("ISO-8859-1"),"utf-8"); 
            String optionC = request.getParameter("optionC");//用request得到 
            optionC = new String(optionC.getBytes("ISO-8859-1"),"utf-8"); 
            String optionD = request.getParameter("optionD");//用request得到 
            optionD = new String(optionD.getBytes("ISO-8859-1"),"utf-8"); 
            
            Cookie cookie = null;
            Cookie[] cookies = null;
             // 获取当前域名下的cookies，是一个数组
            cookies = request.getCookies();
            String name="";
            String tel="";
            if(cookies!=null)
            {
                for(int i=0;i<cookies.length;i++)
                {
                    cookie = cookies[i];
                    if(("name").equals(cookie.getName()))
                    {
                        name=URLDecoder.decode(cookie.getValue(),"UTF-8");
                    }
                    if(("tel").equals(cookie.getName()))
                    {
                        tel=cookie.getValue();
                    }
                }
            }
            
            String str="{\"title\":\""+title
                    +"\",\"classes\":\""+classes
                    +"\",\"optionA\":\""+optionA
                    +"\",\"optionB\":\""+optionB
                    +"\",\"optionC\":\""+optionC
                    +"\",\"optionD\":\""+optionD
                    +"\",\"user\":\""+name+"\"}\r\n";
            FileWriter writer;
            if(tel.equals("admin"))
            {
                writer = new FileWriter("C:\\Questions.txt", true);  
            }
            else
            {
                writer = new FileWriter("C:\\QuestionsCh.txt", true);  
            }
            
            writer.write(str);  
            writer.close();
            response.sendRedirect("insertNewQues.jsp?success=1");
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
