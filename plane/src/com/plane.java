package com;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class plane {
    public static String txtString(String filePath){
        File file = new File(filePath);
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(s+System.lineSeparator());
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
     public static void res(String s,int id)
     {
         String[] ss = s.split("\n");
         if(id==3||id==4)
         {
             System.out.println("Error: "+id);
         }
         else if(id>ss.length)
         {
             System.out.println("Cannot find "+id);
         }
         else{
             System.out.print(
                     ss[id].substring(0,6)+" "+id+" ");
             if(ss[id].length()>14)
             {
                 System.out.println(((ss[id].charAt(7)-'0')+(ss[id].charAt(13)-'0'))
                         +" "+((ss[id].charAt(9)-'0')+(ss[id].charAt(15)-'0'))
                         +" "+((ss[id].charAt(11)-'0')+(ss[id].charAt(17)-'0')));
             }
             else{
                 System.out.println(ss[id].substring(7));
             }
         }
     }
    public static void main(String[] args) {
        String s=txtString("document");
       res(s,4);
        //System.out.println(ss[0]);
    }
}
