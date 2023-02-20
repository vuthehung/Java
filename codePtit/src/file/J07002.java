/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class J07002 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        long kq = 0;    
        while(sc.hasNext()) {
            String tmp = sc.next();
            try{
                kq = kq + Long.parseLong(tmp);
            } catch(NumberFormatException e) {
                continue;
            }
            
        }
        System.out.println(kq);
    }
}
