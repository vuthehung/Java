/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_udp;

import java.io.*;
import java.net.*;

/**
 *
 * @author Admin
 */
public class UDPClient {
     public static void main(String args[]) throws Exception { 
        //tạo socket phía client
        DatagramSocket clientSocket = new DatagramSocket(6789); 
        //Tạo địa chỉ IP address bỏi tên "localhost)
        InetAddress IPAddress = InetAddress.getByName("localhost"); 
        
        while(true){
            //Tạo dữ liệu(group of bytes) cho gói tin nhận và gói tin gủi
            byte[] sendData = new byte[1024]; 
            byte[] receiveData = new byte[2048]; 
//         
            //lấy dòng văn bản nhập từ bàn phím và gán cho biến sentence
            BufferedReader inFromUser = 
                    new BufferedReader(new InputStreamReader(System.in)); 
            String sentence = inFromUser.readLine();
//            
            //tạo dữ liệu gửi với dữ liệu vừa nhập từ bàn phím
            sendData = sentence.getBytes();
            //Tạo gói tin để truyền đi
            DatagramPacket sendPacket = 
                    new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
            //Truyền đến server bằng phương thức send()
            clientSocket.send(sendPacket); 
//        
            //tạo gói tin nhận
            DatagramPacket receivePacket = 
                new DatagramPacket(receiveData, receiveData.length); 
            //lấy biến receivePacket để nhận gói tin bằng phương thức receive()
            clientSocket.receive(receivePacket); 
        
            //Chuyển dữu liệu trong gói tin vừa nhận thành kiểu String và in ra
            String modified_Sentence = new String(receivePacket.getData());
            System.out.println("FROM SERVER:" + modified_Sentence); 
            
            if(sentence.compareTo("quit") == 0) 
                break;
        }
        //Đóng socket
        clientSocket.close(); 
    } 
}
