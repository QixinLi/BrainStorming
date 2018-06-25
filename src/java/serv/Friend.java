/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lee
 */
public class Friend {
    public String getFriendByTel(String tel) throws SQLException{
        String DBDRIVER="com.mysql.jdbc.Driver";
            String DBURL="jdbc:mysql://47.96.162.8:3306/AS?useUnicode=true&characterEncoding=utf-8&useSSL=true";
            String DBUSER="Wangnima";
            String PASSWORD="Wangnima520";
            
            String tableName = "userDetails";
            Connection conn = null;
            Statement stmt = null;
            String sql = "select * from "+ tableName +" where tel='" + tel + "'";
            
            String returnmsg="false";
            try {
                    Class.forName(DBDRIVER);
                    conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);          
                } catch (Exception except) {
                    except.printStackTrace();
                }
                stmt = conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
                int index=0;
  		if(rs.next()){
                    //用户存在
                    String name=rs.getString("name");
                    int score=rs.getInt("score");
                    returnmsg="";
                    returnmsg+=
                    "<ul>\n" +
                        "<li>\n" +
                            "<img id='searchlogoimg' class='uimg' src='images/logo.png' onload=\"getFriendLogoByTel("+tel+",'searchlogoimg')\"/>"+
                            "<h3 class='name'>"+name+"</h3>\n" +
                            "<div id='getuserscorebytel"+index+"' class='autoaddscore'></div>\n" +
                            "<img src='nothing.jpg' class='hideimg' onerror=\"setLevel("+score+",'getuserscorebytel"+index+"')\"/>"+
                            "<br><button onclick='sendFriendRequest()'>添加</button>"+
                        "</li>\n" +
                    "</ul>";
                    index++;
                }
                else{  
                    returnmsg="null";
                    //用户不存在
                }  
  		rs.close();//关闭结果集
  		conn.close();//关闭操作
                stmt.close();
                return returnmsg;
    }
    
    public String sendFriendRequest(String friend1,String friend2){
        String str="fail";
        try {
            message mg = new message(friend2,friend1,"用户“"+friend1+"”请求添加您为好友", "friend_Request","false");
            mg.messageSend();
        } catch (IOException ex) {
            Logger.getLogger(Friend.class.getName()).log(Level.SEVERE, null, ex);
            str="fail";
            return str;
        }
        str="success";
        return str;
    }
    
    public String addFriendRelationship(String friend1,String friend2) throws SQLException{
        String DBDRIVER="com.mysql.jdbc.Driver";
        String DBURL="jdbc:mysql://47.96.162.8:3306/AS?useUnicode=true&characterEncoding=utf-8&useSSL=true";
        String DBUSER="Wangnima";
        String PASSWORD="Wangnima520";
            
        String tableName = "Friend";
        Connection conn = null;
        Statement stmt = null;
        String sql = "select * from "+ tableName +" where friend1='" + friend1 + "'";
        String returnmsg="fail";
        try {
            Class.forName(DBDRIVER);
            conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);          
        } catch (Exception except) {
            except.printStackTrace();
        }
        stmt = conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
  	while(rs.next()){
            //用户有好友
            String mfriend2=rs.getString("friend2");
            if(friend2.equals(mfriend2)){
                //已经存在该好友
                returnmsg="exist";
                return returnmsg;
            }
        }
        //用户没有好友
        PreparedStatement tmt = conn.prepareStatement("Insert into "+ tableName +" values('" + friend1 + "','" + friend2 + "'),('" + friend2 + "','" + friend1 + "')");  
        int rst = tmt.executeUpdate();  
        if (rst != 0){  
            returnmsg="success";//成功
        }
        else{  
            returnmsg="fail";//失败
        }  
  	rs.close();//关闭结果集
  	conn.close();//关闭操作
        stmt.close();
        return returnmsg;
    }
    public String getAllFriend(String tel) throws SQLException{
        String DBDRIVER="com.mysql.jdbc.Driver";
        String DBURL="jdbc:mysql://47.96.162.8:3306/AS?useUnicode=true&characterEncoding=utf-8&useSSL=true";
        String DBUSER="Wangnima";
        String PASSWORD="Wangnima520";
            
        String tableName = "Friend";
        Connection conn = null;
        Statement stmt = null;
        String sql = "select * from "+ tableName +" where friend1='" + tel + "'";
        String str="";
        try {
            Class.forName(DBDRIVER);
            conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);          
        } catch (Exception except) {
            except.printStackTrace();
        }
        stmt = conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
        int index=0;
  	while(rs.next()){
            //用户有好友
            String mfriend2=rs.getString("friend2");
            Statement stmt2 = null;
            stmt2 = conn.createStatement();
            ResultSet rs2=stmt2.executeQuery("select * from userDetails where tel='" + mfriend2 + "'");
            String name="";
            int score=0;
            if(rs2.next()){
                name=rs2.getString("name");
                score=rs2.getInt("score");
            }
            str+=
                    "<ul>\n" +
                        "<li>\n" +
                            "<img id='uimg"+index+"' class='uimg' src='images/logo.png' onload=\"getFriendLogoByTel('"+mfriend2+"','uimg"+index+"')\"/>"+
                            "<h3 class='name'>"+name+"</h3>\n" +
                            "<div id='getuserscore"+index+"' class='autoaddscore'></div>\n" +
                            "<img src='nothing.jpg' class='hideimg' onerror=\"setLevel("+score+",'getuserscore"+index+"')\"/>"+
                            "<br><button onclick=\"sendMessageToFriend('"+mfriend2+"','')\">发消息</button>"+
                        "</li>\n" +
                    "</ul>";
            index++;
        }
  	rs.close();//关闭结果集
  	conn.close();//关闭操作
        stmt.close();
        return str;
    }
    public String sendFriendMsg(String friend1,String friend2,String msg){
        String str="fail";
        try {
            message mg = new message(friend1,friend2,msg, "friend_chat","false");
            mg.messageSend();
        } catch (IOException ex) {
            Logger.getLogger(Friend.class.getName()).log(Level.SEVERE, null, ex);
            str="fail";
            return str;
        }
        str="success";
        return str;
    }
}
