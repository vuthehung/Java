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
public class J02106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][3];
        int res = 0;
        int cnt1 = 0, cnt0 = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 1) cnt1++;
                else cnt0++;
            }
            if(cnt1 > cnt0) {
                res++;
            }
            cnt1 = 0;
            cnt0 = 0;
        }
        System.out.println(res);
    }
}
