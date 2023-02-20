/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class J01004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean ok;
        ok = true;
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if(n <= 1) {
                System.out.println("NO");
            }
            else {
                for(int j = 2; j <= sqrt(n); j++) {
                    if(n % j == 0) {
                        ok = false;
                        break;
                    }else{
                        ok = true;
                    }
                }
                if(ok == false) {
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
            }
        }
    }
}
