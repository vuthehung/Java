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
public class J07031 {
    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return n > 1;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) ois1.readObject();
        ArrayList<Integer> a2 = (ArrayList<Integer>) ois2.readObject();
        Map<Integer, Integer> m = new TreeMap<>();
        for(int i : a1) {
            int x = 1000000 - i;
            if(isPrime(x) && isPrime(i) && x > i && a1.contains(x) && !a2.contains(x) && !a2.contains(i))
                m.put(i, x);
        }
        m.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
