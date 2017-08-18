package node2;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class Node2 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();	
	while(true){
            byte[] sendData = new byte[1024];
            sendData = input.nextLine().getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), 1080);
            clientSocket.send(sendPacket);
            byte[] inData = new byte[256];
            DatagramPacket recievePacket = new DatagramPacket(inData, inData.length);
            clientSocket.receive(recievePacket);
            String msgrecieved = new String(recievePacket.getData());
            System.out.println("RECIEVED : " + msgrecieved);
            if(msgrecieved.contains("Timestamp"))
                break;
        }
        clientSocket.close();
    }
}
