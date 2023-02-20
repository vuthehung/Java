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
public class J03026 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        while(n-->0){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            if(s1.equals(s2)){
                System.out.println(-1);
            } else {
                System.out.println(s1.length()>s2.length()?s1.length():s2.length());
            }
        }
    }
}
