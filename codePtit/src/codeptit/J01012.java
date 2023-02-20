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
public class J01012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int cnt = 0;
            for(int j = 1; j <= sqrt(n); j++) {
                if(n % j == 0) {
                    if(j % 2 == 0) cnt++;
                    if((n / j ) % 2 == 0 && j != n / j) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
