package client;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client
{
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        InetAddress x=InetAddress.getLocalHost();
        
              String host=x.getHostName();
              int port=25000;
              Socket ob= new Socket(host,port);
              DataInputStream in =new DataInputStream(ob.getInputStream());
              DataOutputStream out=new DataOutputStream(ob.getOutputStream());
              while(true)
              {
                  System.out.println("msg:\t");
                  String y=br.readLine();
                  out.writeUTF(y);
                  String z=(String)in.readUTF();
                  System.out.println("reply:\t"+z);
              }
        }
  
    }
