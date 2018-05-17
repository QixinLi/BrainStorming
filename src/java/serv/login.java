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
import java.util.*;
import java.sql.*;
import java.net.*;
import javax.servlet.http.Cookie;
/**
 *
 * @author lee
 */
public class login extends HttpServlet {

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
            String username=null;
            int score;
            String DBDRIVER="com.mysql.jdbc.Driver";
            String DBURL="jdbc:mysql://47.96.162.8:3306/AS?useUnicode=true&characterEncoding=utf-8&useSSL=true";
            String DBUSER="Wangnima";
            String PASSWORD="Wangnima520";

            String tableName = "userDetails";
            Connection cn = null;
            PreparedStatement stmt = null;   
 
            String Tel = request.getParameter("tel");
            String loginKey = request.getParameter("pwd");
            String sql = "SELECT * FROM "+ tableName +" WHERE tel = '"+Tel+"'"+" and loginkey = '"+loginKey+"'";
            try{
		try {
                    Class.forName(DBDRIVER);
                    cn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
                    stmt = cn.prepareStatement(sql);  
                    
                    //Class.forName("com.mysql.jdbc.Driver").newInstance();            
                    //Get a connection
                    //conn = DriverManager.getConnection(dbURL);
                } catch (Exception except) {
                    except.printStackTrace();
                }
		ResultSet rs=null;
                rs=stmt.executeQuery();
		if(rs.next()){
                    String tel=rs.getString("tel");
                    username=rs.getString("name");
                    score=rs.getInt("score");
                    username = URLEncoder.encode(username,"UTF-8");
                    //out.print("欢迎您！"+username);
                    Cookie cookie1 = new Cookie("name",username);
                    cookie1.setMaxAge(60*60*24);
                    Cookie cookie2 = new Cookie("score",""+score);
                    cookie2.setMaxAge(60*60*24);
                    Cookie cookie3 = new Cookie("tel",""+tel);
                    cookie3.setMaxAge(60*60*24);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                    response.addCookie(cookie3);
                    response.sendRedirect("welcomePage.jsp");
		}
		else{
                    response.sendRedirect("login.jsp?errNo");//密码不对返回到登陆  
		}
                rs.close();//关闭结果集
                cn.close();//关闭操作
                stmt.close();
            }
            catch(Exception ex){
		out.println(ex.getMessage());
		out.println("连接异常");
		ex.printStackTrace();
            }
            
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
