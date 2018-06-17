/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

/**
 *
 * @author lee
 */
public class STATIC {
    static public String mdir="C:\\TNFB\\";//服务器与本地测试时地址不一致时，修改此项
    
    public static String string2Json(String s) {        
        StringBuffer sb = new StringBuffer();        
        for (int i=0; i<s.length(); i++) {  
            char c = s.charAt(i);    
            switch (c){
                case '{':
                    sb.append("<");
                    break;
                case '}':
                    sb.append(">");
                    break;
                case ',':
                    sb.append("，");
                    break;
                case ':':
                    sb.append("：");        
                    break;
                case '\"':        
                    sb.append("\\\"");        
                    break;        
                case '\\':        
                    sb.append("\\\\");        
                    break;        
                case '/':        
                    sb.append("\\/");        
                    break;        
                case '\b':        
                    sb.append("\\b");        
                    break;        
                case '\f':        
                    sb.append("\\f");        
                    break;        
                case '\n':
                    sb.append("<br>");        
                    break;        
                case '\r':        
                    sb.append("<br>");        
                    break;        
                case '\t':        
                    sb.append("&nbsp;");        
                    break;        
                default:        
                    sb.append(c);     
            }  
        }      
        return sb.toString();     
    }  
}
