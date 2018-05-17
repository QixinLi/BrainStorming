/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lee
 */
public class setScore extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
                        tel=URLDecoder.decode(cookie.getValue(),"UTF-8");
                    }
                }
            }
            if(tel.equals(""))
            {
                response.getWriter().write("nullExist");;
                return;
            }
            String score=request.getParameter("score");
            Cookie cookie1 = new Cookie("score",""+score);
            cookie1.setMaxAge(60*60*24);
            response.addCookie(cookie1);
            
            
            String DBDRIVER="com.mysql.jdbc.Driver";
            String DBURL="jdbc:mysql://47.96.162.8:3306/AS?useUnicode=true&characterEncoding=utf-8&useSSL=true";
            String DBUSER="Wangnima";
            String PASSWORD="Wangnima520";
            
            String tableName = "userDetails";
            Connection conn = null;
            String sql = "update "+ tableName +" set score=" + score + " where tel='"+tel+"'";
            try {
                    Class.forName(DBDRIVER);
                    conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);    
                } catch (Exception except) {
                    except.printStackTrace();
                }
                PreparedStatement stmt = conn.prepareStatement(sql);
		int rst=stmt.executeUpdate(); 
                if (rst != 0){  
                    response.getWriter().write("success");//成功
                }else{  
                    response.getWriter().write("fail");//失败
                }  
  		conn.close();//关闭操作
                stmt.close();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(setScore.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(setScore.class.getName()).log(Level.SEVERE, null, ex);
        }
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
