package node1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Timestamp;
public class Node1 {
    public static void main(String[] args) throws IOException{
        DatagramSocket node1 = new DatagramSocket(1080);
        byte[] inData = new byte[256];
        byte[] outData = new String("Message Received from Client").getBytes();
        DatagramPacket receivePacket = new DatagramPacket(inData, inData.length);
        DatagramPacket sendPacket = new DatagramPacket(outData, outData.length);
        while(true){
            //First listen for a datagram-packet
            node1.receive(receivePacket);
            String msgreceived = new String(receivePacket.getData());
            System.out.println("RECIEVED : " + msgreceived);
            //Send an acknowledgement
            if(msgreceived.contains("getDate"))
                outData = new String(new Timestamp(System.currentTimeMillis()).toString()).getBytes();
            else 
                outData = new String("Message Received from Client").getBytes();
                
            sendPacket = new DatagramPacket(outData, outData.length);
            sendPacket.setAddress(receivePacket.getAddress());
            sendPacket.setPort(receivePacket.getPort());
            node1.send(sendPacket);
            
        }
        //node1.close();
}
    
    
}
