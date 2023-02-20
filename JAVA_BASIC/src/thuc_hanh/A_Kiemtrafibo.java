/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuc_hanh;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class A_Kiemtrafibo {
    public static long[] fibo = new long[93];
    public static void initFibo() {
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;
        for(int i = 3; i <= 92; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initFibo();
        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong();
            boolean check = false;
            for(int i = 0; i <= 92; i++) 
                if(fibo[i] == n) {
                    check = true;
                    System.out.println("YES");
                    break;
                }
            
            if(!check)
                System.out.println("NO");
        }
    }
}
