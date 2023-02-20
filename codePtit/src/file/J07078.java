/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class J07078 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc=new Scanner(new File("STRING.in"));
        int n=Integer.parseInt(sc.nextLine());
        while(n-->0){
            StringBuilder sb1=new StringBuilder(sc.nextLine());
            String s2=sc.nextLine();
            while(sb1.toString().contains(s2)){
                int x=sb1.toString().indexOf(s2);
                System.out.printf("%d ", x+1);
                sb1.setCharAt(x, '.');
                //sb1.deleteCharAt(x);
            }
            System.out.println();
        }
    }
}
