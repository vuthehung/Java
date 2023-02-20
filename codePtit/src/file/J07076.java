/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class J07076 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            Vector<Integer> v = new Vector<>();
            int[][] a = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                  a[i][j] = sc.nextInt();
                  if(j == x - 1) 
                      v.add(a[i][j]);
                }
            }
            Collections.sort(v);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(j == x - 1) {
                        System.out.print(v.get(i) + " ");
                    } else {
                        System.out.print(a[i][j] + " ");
                    }
                }
                System.out.println(" ");
            }
        }
    }
}
