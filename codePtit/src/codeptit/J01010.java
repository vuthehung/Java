    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class J01010 {
    public static String e = "234567";
    
    public static String catDoi(String s) {
        String kq = "";
        for(int i=0; i<s.length(); i++) {
           for(int j=0; j<e.length(); j++) {
               if(s.charAt(i) == e.charAt(j)) return "INVALID";
           }
           if(s.charAt(i) == '8' || s.charAt(i) == '9') kq += "0";
           else kq += s.charAt(i);
        }
        boolean check = false;
        for(int i=0; i<kq.length(); i++) {
            if(kq.charAt(i) != '0') check = true;
        }
        if(!check) return "INVALID";
        int i = 0;
        while(kq.charAt(i) == '0') {
            kq = kq.substring(i+1);
        }
        return kq;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= t; i++) {
            String s = sc.nextLine();
            System.out.println(catDoi(s));
        }
        
    }
}
