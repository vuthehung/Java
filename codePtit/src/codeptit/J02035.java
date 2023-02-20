/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.*;

/**
 *
 * @author Admin
 */
public class J02035 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int vt=0;
            long max=sc.nextLong();
            for(int i=1;i<n;i++){
                if(max<=sc.nextLong())vt=i;
            }
            System.out.println((vt+1+n)%n);
        }
    }
}
