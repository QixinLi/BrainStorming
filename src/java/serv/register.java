/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lee
 */
public class register extends HttpServlet {

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
            String username = request.getParameter("username");    
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            name = new String(name.getBytes("ISO-8859-1"),"utf-8"); 
            
            String DBDRIVER="com.mysql.jdbc.Driver";
            String DBURL="jdbc:mysql://47.96.162.8:3306/AS?useUnicode=true&characterEncoding=utf-8&useSSL=true";
            String DBUSER="Wangnima";
            String PASSWORD="Wangnima520";
            

            String tableName = "userDetails";
            Connection conn = null;
            Statement stmt = null;
            String sql = "select * from "+ tableName +" where tel='" + username + "'";
            try {
                    Class.forName(DBDRIVER);
                    conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);          
                    //Get a connection

                } catch (Exception except) {
                    except.printStackTrace();
                }
                stmt = conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);


  		if(rs.next()){  
                    response.sendRedirect("register.jsp?return=1");//该用户已经存在
                }
                else{  
                    PreparedStatement tmt = conn.prepareStatement("Insert into "+ tableName +" values('" + name + "','" + username + "','" + password + "',0)");  
                    int rst = tmt.executeUpdate();  
                    if (rst != 0){  
                        response.sendRedirect("register.jsp?return=0");//注册成功
                        //out.println("<script language='javascript'>$.DialogByZ.Alert({Title:'提示',Content:'注册成功！即将跳转到登录界面。',BtnL:'确认',FunL:alerts_login});</script>");    
                    }else{  
                        response.sendRedirect("register.jsp?return=2");//注册失败
                        //out.println("<script language='javascript'>$.DialogByZ.Alert({Title:'提示',Content:'注册失败！',BtnL:'确认',FunL:alerts_signup});</script>");
                    }  
                }  
  		rs.close();//关闭结果集
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
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
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
