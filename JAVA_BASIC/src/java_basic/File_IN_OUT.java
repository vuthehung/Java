/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_basic;

import java.util.*;
import java.io.*;

/**
 *
 * @author Admin
 */
public class File_IN_OUT {
    public static void main(String[] args) throws FileNotFoundException {
        //ghi file: PrintWriter
        Scanner sc = new Scanner(new File("D:\\code\\Java\\codePtit\\src\\file\\SV.in"));
        PrintWriter out = new PrintWriter(new File("D:\\code\\Java\\codePtit\\src\\file\\OUT.in"));
        while(sc.hasNextLine()) {
            out.println(sc.nextLine());
        }
        out.close();
    }
   
}
