/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Admin
 */

public class Binary_IO {
    //file nhi phan
    public static void main(String[] args) throws IOException{
        BufferedInputStream b_in = new BufferedInputStream(new FileInputStream("A.rar"));
        BufferedOutputStream b_out = new BufferedOutputStream(new FileOutputStream("B.rar"));
        int x = 0;
        while(true) {
            x = b_in.read();
            if(x == -1) break;
            b_out.write(x);
            
        }
        b_in.close();
        b_out.close();
    }
}
