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
public class TCPServer {

    public static void main(String[] args) throws Exception {
//        String clientSentence;
//        String capitalizedSentence;
        int num1, num2;
        int sum, sub, mul, div;

        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("Listening...");
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            //PrintWriter out = new PrintWriter(connectionSocket.getOutputStream());
            DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());
            
            //String clientSentence = inFromClient.readLine();
            //clientSentence = inFromClient.readLine();
            num1 = inFromClient.read();
            num2 = inFromClient.read();
            
            System.out.println("Received: " + num1 + " " + num2);
            
            sum = num1 + num2;
            out.writeInt(sum);

            //System.out.println("Received: " + clientSentence);
            //System.out.println("Sent: " + clientSentence.toUpperCase());
            
//            capitalizedSentence = clientSentence.toUpperCase() + '\n';
//            
//            out.writeBytes(capitalizedSentence);

//            out.println(clientSentence.toUpperCase());
//            out.flush();

//            inFromClient.close();
//            out.close();
//            connectionSocket.close();
        }
    }
}
