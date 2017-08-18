package server;
import java.io.*;
import java.net.*;
import java.util.*;
public class Server
{
 public static void main(String []args) throws Exception
 {    
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     Date date = new Date();
     {
         int port=25000;
         ServerSocket serverSocket=new ServerSocket(port);
         System.out.println("Server Started and listening to port 25000");
         Socket ob=serverSocket.accept();
         DataInputStream in =new DataInputStream(ob.getInputStream());
         DataOutputStream out=new DataOutputStream(ob.getOutputStream());
         while(true)
         {
             String x=(String)in.readUTF();
             if(x.equals("date"))
             {
                 String d=date.toString();
                 out.writeUTF(d);
             }
             else{
             System.out.println("reply:\t"+x);
             System.out.println("msg for client:\t");
             String y=br.readLine();
             out.writeUTF(y);
             }
         }
     }
 
 }
    
    
}
