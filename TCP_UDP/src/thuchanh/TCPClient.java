/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.io.*;
import java.util.*;
import java.net.*;

/**
 *
 * @author Admin
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        Socket socket = new Socket("localhost", 6789);
        //gui data qua server
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        //nhan data tu server
        DataInputStream in = new DataInputStream(socket.getInputStream());
        while(true) {
            System.out.println("Input num1");
            //gui data qua server
            out.writeInt(sc.nextInt());
            //xoa bo nho dem
            out.flush();
            System.out.println("Input num2");
            out.writeInt(sc.nextInt());
            out.flush();
            int sum = in.readInt();
            int sub = in.readInt();
            int mul = in.readInt();
            int div = in.readInt();
            System.out.println(sum + " " + sub + " " + mul + " " + div);
            System.out.println("Continue Y/n?");
            String rep = sc.next();
            if(rep.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
}
