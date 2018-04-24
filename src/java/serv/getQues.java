/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import net.sf.json.JSONObject;


/**
 *
 * @author lee
 */
public class getQues {
    static public Ques myques[];
    public int numofQues=0;
    public int QuesNo;
    public boolean setQues() throws FileNotFoundException, IOException
    {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(STATIC.mdir+"Questions.txt")); // 建立一个输入流对象reader  
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
        String line = "";  
        String str="";
        do{
            line = br.readLine();
            str+=line+"\n";
        }while(line != null);
        String jsondata[]=str.split("\n");
        this.numofQues=jsondata.length-2;
        myques=new Ques[numofQues];
        if(numofQues!=0)
        {
            for(int i=0;i<numofQues;i++)
            {
                    JSONObject jsonObject =JSONObject.fromObject(jsondata[i]);
                    String title=jsonObject.getString("title");
                    String classes=jsonObject.getString("classes");
                    String optionA=jsonObject.getString("optionA");
                    String optionB=jsonObject.getString("optionB");
                    String optionC=jsonObject.getString("optionC");
                    String optionD=jsonObject.getString("optionD");
                    String user=jsonObject.getString("user");
                    myques[i]=new Ques(title,classes,optionA,optionB,optionC,optionD,user,true);
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
        if(setQues())
        {
            Random ra=new Random();
            this.QuesNo=ra.nextInt(this.numofQues);
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
            return "error";
        }
    }
    
}

class Ques{
    public String title="";
    public String classes="";
    public Option optionA;
    public Option optionB;
    public Option optionC;
    public Option optionD;
    public String user="";
    public String correctAns="";
    public Ques()
    {
    }
    public Ques(String title,String classes,String A,String B,String C,String D,String user,boolean flag){
        this.title=title;
        this.classes=classes;
        int num=1;
        if (flag==true)
        {
            Random ra=new Random();
            num=(ra.nextInt(4)+1);
        }
        switch(num)
        {
            case 1:
                this.optionA=new Option(A,true);
                this.optionB=new Option(B,false);
                this.optionC=new Option(C,false);
                this.optionD=new Option(D,false);
                this.correctAns="A";
                break;
            case 2:
                this.optionA=new Option(B,false);
                this.optionB=new Option(A,true);
                this.optionC=new Option(C,false);
                this.optionD=new Option(D,false);
                this.correctAns="B";
                break;
            case 3:
                this.optionA=new Option(C,false);
                this.optionB=new Option(B,false);
                this.optionC=new Option(A,true);
                this.optionD=new Option(D,false);
                this.correctAns="C";
                break;
            case 4:
                this.optionA=new Option(D,false);
                this.optionB=new Option(B,false);
                this.optionC=new Option(C,false);
                this.optionD=new Option(A,true);
                this.correctAns="D";
                break;
        }
        this.user=user;
    }
}

class Option{
    public String option="";
    public boolean isTrue=false;
    public Option(String option,boolean isTrue){
        this.option=option;
        this.isTrue=isTrue;
    }
}
