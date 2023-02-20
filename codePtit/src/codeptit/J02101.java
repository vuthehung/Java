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
public class J02101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            t--;
            int n = sc.nextInt();
            int[] a = new int[n * n];
            for(int i = 0; i < n * n; i++) {
                a[i] = sc.nextInt();
            }
            int cnt = 0;
            for(int i = 0; i < n * n; i++) {
                if(cnt < n) {
                    System.out.print(a[i] + " ");
                    cnt++;
                }else{
                    for(int j = i + n - 1; j >= i; j--) {
                        System.out.print(a[j] + " ");
                    }
                    cnt = 0;
                    i += n - 1;
                }
            }
            System.out.println();
        }
    }
}
