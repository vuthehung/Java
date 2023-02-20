/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class TinhTongSoLong {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(""));
        Long sum = 0L;
        while(sc.hasNext()) {
            String s = sc.next();
            try{
                Integer.parseInt(s);
            } catch(NumberFormatException e) {
                try{
                    sum += Long.parseLong(s);
                } catch(NumberFormatException e1) {
                    continue;
                }
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
