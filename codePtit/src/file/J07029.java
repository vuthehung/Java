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
public class J07029 {
    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return n > 1;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> l = (List<Integer>) ois.readObject();
        int[] a = new int[1000000];
        for(int i : l) {
            a[i]++;
        }
        int cnt = 0;
        for(int i = a.length - 1; i >= 0; i--) {
            if(a[i] != 0 && isPrime(i)) {
                System.out.println(i + " " + a[i]);
                cnt++;
            }
            if(cnt == 10) break;
        }
    }
}
