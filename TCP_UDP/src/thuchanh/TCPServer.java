/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.io.*;
import java.net.*;

/**
 *
 * @author Admin
 */
public class TCPServer {
    public static void main(String[] args) throws Exception{
        //6789: so hieu cong
        ServerSocket svSocket = new ServerSocket(6789);
        Socket socket = svSocket.accept();
        //nhan data tu client
        DataInputStream in = new DataInputStream(socket.getInputStream());
        //truyen data ve client
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        while(true) {
            int num1 = in.readInt();
            int num2 = in.readInt();
            System.out.println("Received:" + num1 + " " + num2);
            int sum = num1 + num2;
            int sub = num1 - num2;
            int mul = num1 * num2;
            int div = num1 / num2;
            //truyen kq sang client
            out.writeInt(sum);
            out.flush();
            out.writeInt(sub);
            out.flush();
            out.writeInt(mul);
            out.flush();
            out.writeInt(div);
            out.flush();
        }
    }
}
