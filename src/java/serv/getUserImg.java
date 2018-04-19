/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.File;
import java.net.URLDecoder;
import javax.servlet.http.Cookie;

/**
 *
 * @author lee
 */
public class getUserImg {
    public getUserImg(){
    
    }
    public String getUserImgsrc(String tel){
        File f = new File("C://userimg//"+tel+".jpg");
        if (f.exists()) {
            return "/userimg/"+tel+".jpg";
        }
        else
        {
            return "null";
        }
    }
}
