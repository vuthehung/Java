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
public class J01007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            long n = sc.nextLong();
            long f1 = 1;
            long f2 = 1;
            long fb = 0;
            boolean ok;
            ok = false;
            for(int j = 3; j <= 92; j++) {
                fb = f1 + f2;
                f1 = f2;
                f2 = fb;
                if(n == fb){
                    ok = true;
                    break;
                }
            }
            if(n == 1 || n == 0 || ok == true) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            
        }
    }
}
