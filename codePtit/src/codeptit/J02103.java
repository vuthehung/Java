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
public class J02103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=1; k<=t; k++) {
            System.out.println("Test " + k + ":");
            int m = sc.nextInt(), n = sc.nextInt();
            int[][] a = new int[m+5][n+5];
            for(int i=1; i<=m; i++) {
                for(int j=1; j<=n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int[][] b = new int[m+5][n+5];
            int[][] c = new int[m+5][n+5];
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=m; j++) {
                    b[i][j] = a[j][i];
                }
            }
            for(int i=1; i<=m; i++) {
                for(int j=1; j<=m; j++) {
                    c[i][j] = 0;
                    for(int l=1; l<=n; l++) {
                        c[i][j] += (a[i][l]*b[l][j]);
                    }
                }
            }
            for(int i=1; i<=m; i++) {
                for(int j=1; j<=m; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        }
        
            
    
    }
}
