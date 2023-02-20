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
public class J02023 {
    private static String max(int n, int s){
        s-=1;
        String res="";
        for(int i=0;i<n-1;i++){
            if(s>9){
                res=9+res;
                s-=9;
            } else {
                res=s+res;
                s=0;
            }
        }
        res=(s+1)+res;
        return res;
    }
    public static String min(int n, int s){
        String res="";
        while(s!=0){
            if(s>9){
                res+=9;
                s-=9;
            } else {
                res+=s;
                s=0;
            }
        }
        for(int i=res.length();i<n;i++)res+="0";
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        if(n*9<s || s==0){
            System.out.print("-1 -1");
        } else {
            System.out.printf("%s %s", max(n,s), min(n,s));
        }
    }
}
