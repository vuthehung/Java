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
public class J07016 {
    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) 
                return false;
        }
        return n > 1;
    }
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException{
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) ois1.readObject();
        ArrayList<Integer> a2 = (ArrayList<Integer>) ois2.readObject();
        Map<Integer, Integer> m1 = new TreeMap<>();
        Map<Integer, Integer> m2 = new TreeMap<>();
        for(Integer x : a1) {
            if(isPrime(x)) {
                if(m1.containsKey(x)) 
                    m1.put(x, m1.get(x) + 1);
                else
                    m1.put(x, 1);
            } 
        }
        for(Integer x : a2) {
            if(isPrime(x)) {
                if(m2.containsKey(x)) 
                    m2.put(x, m2.get(x) + 1);
                else
                    m2.put(x, 1);
            } 
        }
        m1.forEach((k, v) -> {
            if(m2.containsKey(k)) {
                System.out.printf("%d %d %d\n", k, v, m2.get(k));
            }
        });
    }
}
