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
public class TCPClient {

    public static void main(String[] args) throws Exception {

//        Socket clientSocket = new Socket("127.0.0.1", 6789);
//
//        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a line: ");
//        String sentence = sc.nextLine();
//        System.out.println("Sent: " + sentence);
//        out.println(sentence); //doc dong user gui toi server
//        out.flush();
//
//        String line = inFromUser.readLine();//doc du lieu do server gui tro lai
//        System.out.println("Received: " + line);
//
//        inFromUser.close();
//        out.close();
//        clientSocket.close();

//        String sentence;
//        String modifiedSentence;
        int num1, num2;
        int sum, sub, mul, div;
        
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("127.0.0.1", 6789);
        
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        sentence = inFromUser.readLine();
//        outToServer.writeBytes(sentence + '\n');
//        modifiedSentence = inFromServer.readLine();
//        
//        System.out.println("FROM SERVER: " + modifiedSentence);
        num1 = inFromUser.read();
        num2 = inFromUser.read();
        outToServer.writeInt(num1);
        outToServer.writeInt(num2);
        
        sum = inFromServer.read();
        System.out.println("FROM SERVER: " + sum);
        
        clientSocket.close();
    }
}
