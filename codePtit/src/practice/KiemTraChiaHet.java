/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Admin
 */
public class KiemTraChiaHet {
    public static boolean mod(BigInteger a, BigInteger b) {
        return a.mod(b).equals(BigInteger.ZERO);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SONGUYEN.in"));
        int t = sc.nextInt();
        while(t-- > 0) {
            BigInteger n = sc.nextBigInteger();
            BigInteger a = new BigInteger("7");
            BigInteger b = new BigInteger("13");
            if(mod(n, a) && mod(n, b)) {
                System.out.println("Both");
            } else if(mod(n, a)) {
                System.out.println("Div 7");
            } else if(mod(n, b)) {
                System.out.println("Div 13");
            } else {
                System.out.println("None");
            }
        }
    }
}
