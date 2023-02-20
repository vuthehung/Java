/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class J03013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            String s1 = sc.next(), s2 = sc.next();
            int max = Math.max(s1.length(), s2.length());
            BigInteger a = new BigInteger(s1);
            BigInteger b = new BigInteger(s2);
            BigInteger res = a.subtract(b);
            res = res.abs();
            String ans = String.valueOf(res);
            while(ans.length() < max) ans = "0" + ans;
            System.out.println(ans);
        }
    }
}
