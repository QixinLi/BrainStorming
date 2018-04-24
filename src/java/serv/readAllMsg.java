/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 *
 * @author lee
 */
public class readAllMsg extends HttpServlet {

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
            Cookie cookie = null;
            Cookie[] cookies = null;
             // 获取当前域名下的cookies，是一个数组
            cookies = request.getCookies();
            String tel="";
            String ret="";
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
            File file = new File(STATIC.mdir+"userMsg\\"+tel+".txt");  
            if(!file.exists()){  
                ret="null";
            }
            else{
                InputStreamReader reader = new InputStreamReader(new FileInputStream(STATIC.mdir+"userMsg\\"+tel+".txt")); // 建立一个输入流对象reader  
                BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
                String line = "";  
                Msg mymsg[];
                mymsg=new Msg[100];
                int i=0;
                line = br.readLine();
                while(line != null){
                    JSONObject jsonObject = JSONObject.fromObject(line);
                    String receiver = jsonObject.getString("receiver");
                    String sender = jsonObject.getString("sender");
                    String infomation = jsonObject.getString("infomation");
                    String type = jsonObject.getString("type");
                    boolean read = jsonObject.getBoolean("read");
                    mymsg[i]=new Msg(receiver,sender,infomation,type,read);
                    i++;
                    line = br.readLine();
                }
                try {
                    BufferedWriter bout = new BufferedWriter(new FileWriter(STATIC.mdir+"userMsg\\"+tel+".txt"));
                    String content="";
                    for(int j=0;j<i;j++)
                    {
                        content+="{\"receiver\":\""+mymsg[j].receiver
                                +"\",\"sender\":\""+mymsg[j].sender
                                +"\",\"infomation\":\""+mymsg[j].information
                                +"\",\"type\":\""+mymsg[j].type
                                +"\",\"read\":\"true\""
                                +"}\r\n";
                    }
                    bout.write(content);
                    bout.close();
                } catch (IOException e) {
                    ret="false";
                }
                ret="ok";
                response.getWriter().print(wrapJSON(ret));  
            }
        }
    }
    private String wrapJSON(String ret){  
        return "{\"ret\":\""+ret+"\"}";     
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
