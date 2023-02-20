/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuc_hanh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class E_Tukhacnhau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> a = new ArrayList<>();
        while(n-- > 0) {
            String s = sc.nextLine().toLowerCase();
            String[] arr = s.split(" ");
            for(String x : arr)
                if(!a.contains(x))
                    a.add(x);
        }
        Collections.sort(a);
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<String> b = new ArrayList<>();
        while(m-- > 0) {
            String s = sc.nextLine().toLowerCase();
            String[] arr = s.split(" ");
            for(String x : arr)
                if(!b.contains(x))
                    b.add(x);
        }
        Collections.sort(b);
        for(String s1 : a) {
            if(!b.contains(s1)) 
                System.out.print(s1 + " ");
        }
        System.out.println("");
        for(String s2 : b) {
            if(!a.contains(s2))
                System.out.print(s2 + " ");
        }
    }
}
