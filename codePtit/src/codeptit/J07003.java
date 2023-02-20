/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

/**
 *
 * @author Admin
 */
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class J07003 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        String s = sc.nextLine();
        while (s.length() != 1) {
            int n = s.length() / 2;
            BigInteger a = new BigInteger(s.substring(0, n));
            BigInteger b = new BigInteger(s.substring(n));
            BigInteger sum = a.add(b);
            System.out.println(sum);
            s = String.valueOf(sum);
        }
    }
}
