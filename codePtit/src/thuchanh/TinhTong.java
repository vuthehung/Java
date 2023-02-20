/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class TinhTong {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        long sum = 0;
        while(sc.hasNext()) {
            String tmp = sc.next();
            try {
                Integer.parseInt(tmp);
            } catch(NumberFormatException e) {
                try {
                    sum += Long.parseLong(tmp);
                } catch(NumberFormatException ex) {
                    
                }
            }
        }
        System.out.println(sum);
    }
}
