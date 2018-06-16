/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import net.sf.json.JSONObject;

/**
 *
 * @author lee
 */
public class getUserMsg {
    public String getUserMsgstr(String tel) throws FileNotFoundException, IOException{
        File file = new File(STATIC.mdir+"userMsg\\"+tel+".txt");  
        if(!file.exists()){
            return "";
        }
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
        String str="";
        for(int j=i-1;j>=0;j--)
        {
            if(!mymsg[j].read)
            {
                if(mymsg[j].type.equals("friend_Request"))
                {
                    str+=
                        "<ul onclick=\"examFriendRequest('"+mymsg[j].sender+"')\" >\n" +
                            "<li style=\"background-color: #fff6ac\">\n" +
                                "<div class='content'>\n"+
                                    "<h3>"+mymsg[j].sender+"</h3>\n"+
                                    "<span class='preview'>"+mymsg[j].information+"</span>\n" +
                                "</div>\n" +
                            "</li>\n" +
                        "</ul>";
                }
                else
                {
                    str+=
                        "<ul>\n" +
                            "<li style=\"background-color: #fff6ac\">\n" +
                                "<div class='content'>\n" +
                                    "<h3>"+mymsg[j].sender+"</h3>\n" +
                                    "<span class='preview'>"+mymsg[j].information+"</span>\n" +
                                "</div>\n" +
                            "</li>\n" +
                        "</ul>";
                }
            }
        }
        for(int j=i-1;j>=0;j--)
        {
            if(mymsg[j].read)
            {
                if(mymsg[j].type.equals("friend_Request"))
                {
                    str+=
                            "<ul onclick=\"examFriendRequest('"+mymsg[j].sender+"')\" >\n" +
                                "<li>\n" +
                                    "<div class='content'>\n" +
                                        "<h3>"+mymsg[j].sender+"</h3>\n" +
                                        "<span class='preview'>"+mymsg[j].information+"</span>\n" +
                                     "</div>\n" +
                                "</li>\n" +
                            "</ul>";
                }
                else
                {
                    str+="<ul>\n" +
                        "<li>\n" +
                            "<div class='content'>\n" +
                                "<h3>"+mymsg[j].sender+"</h3>\n" +
                                "<span class='preview'>"+mymsg[j].information+"</span>\n" +
                            "</div>\n" +
                        "</li>\n" +
                    "</ul>";
                }
                
            }
        }
        return str;
    }
    public boolean checkUserMsgstr(String tel) throws FileNotFoundException, IOException{
        File file = new File(STATIC.mdir+"userMsg\\"+tel+".txt");  
        if(!file.exists()){  
            return false;
        }
        InputStreamReader reader = new InputStreamReader(new FileInputStream(STATIC.mdir+"userMsg\\"+tel+".txt")); // 建立一个输入流对象reader  
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
        String line = "";  
        int i=0;
        line = br.readLine();
        while(line != null){
            JSONObject jsonObject = JSONObject.fromObject(line);
            boolean read = jsonObject.getBoolean("read");
            if(read==false){
                return true;
            }
            i++;
            line = br.readLine();
        }
        return false;
    }
}
class Msg{
    public String receiver;
    public String sender;
    public String information;
    public String type;
    public boolean read;
    public Msg(String receiver,String sender,String information,String type,boolean read){
        this.receiver=receiver;
        this.sender=sender;
        this.information=information;
        this.type=type;
        this.read=read;
    }
}
