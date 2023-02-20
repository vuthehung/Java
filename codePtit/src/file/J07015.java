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
public class J07015 {
    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return n > 1;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        List<Integer> l = (List<Integer>) ois.readObject();
        Map<Integer, Integer> m = new TreeMap<>();
        for(int i : l) {
            if(isPrime(i)) {
                if(m.containsKey(i)) {
                    int value = m.get(i);
                    value++;
                    m.put(i, value);
                }else {
                    m.put(i, 1);
                }
            }
        }
        m.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
