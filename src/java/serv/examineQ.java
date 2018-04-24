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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import net.sf.json.JSONObject;

/**
 *
 * @author C
 */
public class examineQ {
    //单个题目生成
    static public Ques myques[];
    public int numofQues=0;
    public int QuesNo;
    static public int start=0;
    static public int end=0;
    static public String jsondata[];
    static public String clonejsonString[];
    public boolean setQues() throws FileNotFoundException, IOException
    {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(STATIC.mdir+"QuestionsCh.txt")); // 建立一个输入流对象reader  
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
        String line = "";  
        String str="";
        do{
            line = br.readLine();
            str+=line+"\n";
        }while(line != null);
        //所有的题目数据
        
        jsondata=str.split("\n");

        this.numofQues=jsondata.length-1;
        
        clonejsonString=Arrays.copyOf(jsondata,numofQues);
        end = clonejsonString.length;
        myques=new Ques[numofQues];
        if(start>=end)
        {
            return true;
        }
        br.close();
        reader.close();
        if(numofQues!=0)
        {
            for(int i=0;i<numofQues;i++)
            {
                    //java中的json使用
                    JSONObject jsonObject =JSONObject.fromObject(jsondata[i]);
                    String title=jsonObject.getString("title");
                    String classes=jsonObject.getString("classes");
                    String optionA=jsonObject.getString("optionA");
                    String optionB=jsonObject.getString("optionB");
                    String optionC=jsonObject.getString("optionC");
                    String optionD=jsonObject.getString("optionD");
                    String user=jsonObject.getString("user");
                    //题目构造
                    myques[i]=new Ques(title,classes,optionA,optionB,optionC,optionD,user,false);
            }
        }
        else
        {
            return false;
        }
        return true;
    }
    
    public String getOneQues()throws FileNotFoundException, IOException
    {
        start++;
        if(setQues())
        {
            if(start>end)
            {
                return "暂无更多新题";
            }
            
            if (start<end)
            {
                System.out.println("下一题");
                int no=start;
                System.out.println(no);
                System.out.println(clonejsonString[no]);
                this.QuesNo=start;
                //以‘##’组合成字符串,并在目的地解析
                String str=myques[QuesNo].title+"##"+
                        myques[QuesNo].classes+"##"+
                        myques[QuesNo].optionA.option+"##"+
                        myques[QuesNo].optionB.option+"##"+
                        myques[QuesNo].optionC.option+"##"+
                        myques[QuesNo].optionD.option+"##"+
                        myques[QuesNo].user+"##"+
                        myques[QuesNo].correctAns;
                return str;
            }
            else
            {
                return "已审核完全部新题";
            }
        }
        else
        {
            return "加载新题出错";
        }
    }
    public String LoadOneQues()throws FileNotFoundException, IOException
    {
        if(setQues())
        {
            if(start>end)
            {
                return "已审核完全部新题";
            }
            if(start<end)
            {
                int no=start;
//以‘##’组合成字符串,并在目的地解析
                String str=myques[no].title+"##"+
                        myques[no].classes+"##"+
                        myques[no].optionA.option+"##"+
                        myques[no].optionB.option+"##"+
                        myques[no].optionC.option+"##"+
                        myques[no].optionD.option+"##"+
                        myques[no].user+"##"+
                        myques[no].correctAns;
                return str;
            }
            else
            {
                return "已审核完全部新题";
            }
        }
        else
        {
            return "刷新新题出错";
        }
    }
    
    //删除已审核问题
    public int deleted() throws IOException 
    {
        //删除一行文件
        File file = new File(STATIC.mdir+"QuestionsCh.txt");
        if (file.exists())
        {
            file.delete();
        }
        System.out.println(numofQues);
        FileWriter writer = new FileWriter(STATIC.mdir+"QuestionsCh.txt");
        for(int i=start;i<end;i++)
        {
            String str=clonejsonString[i]+"\r\n";
            writer.write(str);
        }
        writer.close();
        start=0;
        return start;
    }
    
    //通过审核，写入问题到文件
    public void pass() throws IOException
    {
        if(setQues())
        {
            System.out.println("写入问题");
            System.out.println(start);
            FileWriter writer = new FileWriter(STATIC.mdir+"Questions.txt",true);
            String new_questionString=this.clonejsonString[start]+"\r\n";
            writer.write(new_questionString);
            writer.close();
        
            //发送通知消息
            JSONObject jsonObject =JSONObject.fromObject(clonejsonString[start]);
            String user=jsonObject.getString("user");
            String title=jsonObject.getString("title");
            String content="您的问题<"+title+">已经审核通过，感谢配合！";          
            message mg = new message(user, "admin", content, "examineQ_notice","false");
            mg.messageSend();
            System.out.println("审核通过");
        }
    }
    //未通过审核
    public void unpass() throws IOException
    {
        if(setQues())
        {
        //发送通知消息
            JSONObject jsonObject =JSONObject.fromObject(clonejsonString[start]);
            String user=jsonObject.getString("user");
            String title=jsonObject.getString("title");
            String content="很遗憾，您的问题<"+title+">未通过审核，请修改正确后重新提交！";
            message mg = new message(user, "admin", content, "examineQ_notice","false");
            mg.messageSend();
        }
    }
    
}

