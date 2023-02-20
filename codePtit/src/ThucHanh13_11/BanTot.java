/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThucHanh13_11;

import java.util.*;

/**
 *
 * @author Admin
 */
public class BanTot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[25];
        int b[] = new int[600005];
        long s = 0;
        char[] c = new char[30];
        for(int i = 1; i <= n; i++) {
            String x = sc.next();
            b[i] = x.length();
        }
        for(int i = (n + k); i > n; i--) b[i] = 0;
        for(int i = 2; i <= 20; i++) a[i] = 0;
        for(int i = ( k < n ? k : n); i >= 1; i--) a[b[i]]++;
        for(int i = 1; i <= n; i++) {
            a[b[i + k]]++;
            s += --a[b[i]];
        }
        System.out.println(s);
    }
}
