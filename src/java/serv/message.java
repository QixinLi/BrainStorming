/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author C
 */
public class message {
    public String info="";
    public String receiver="";
    public String sender="";
    public String type="";
    public String file_dir="";
    public String read="";
    public int num_message=0;
    public message message_list[];
    
    public message(String receiverString,String senderString,String infoString,String typeString,String readString) {
        this.info=infoString;
        this.receiver=receiverString;
        this.sender=senderString;
        this.type=typeString;
        this.file_dir=STATIC.mdir+"userMsg\\"+this.receiver+".txt";
        this.read=readString;
    }
    public int messageSend() throws IOException
    {
        String fileDir=this.file_dir;
        File file = new File(fileDir);
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(this.file_dir,true);
        String content="";
        content="{\"receiver\":\""+STATIC.string2Json(this.receiver)
                +"\",\"sender\":\""+STATIC.string2Json(this.sender)
                +"\",\"infomation\":\""+STATIC.string2Json(this.info)
                +"\",\"type\":\""+STATIC.string2Json(this.type)
                +"\",\"read\":\"false\""
                +"}\r\n";
        BufferedWriter bufferWritter = new BufferedWriter(fileWriter);
        bufferWritter.write(content);
        bufferWritter.close();
        return 0;
    }
    
    
    
    public int decode()
    {
        
        return 0;
    }
    
}

