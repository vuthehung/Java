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
public class J02013 {
    public static void xuLy(int a[], int n) {
        for(int i = 0; i < n - 1; i++) {
            int check = 0;
            for(int j = 0; j < n - 1; j++) {
                if(a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    check = 1;
                }
            }
            if(check == 0){
                break;
            }
            
            System.out.print("Buoc " + (i + 1) + ": ");
            for(int k = 0; k < n; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[100];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        xuLy(a, n);
    }
}
