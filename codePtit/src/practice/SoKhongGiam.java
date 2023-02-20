/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class SoKhongGiam {
    public static boolean check(int n) {
        if(n < 10) 
            return false;
        int k = 10;
        while(n > 0) {
            if(n % 10 > k) 
                return false;
            k = n % 10;
            n /= 10;
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) ois1.readObject();
        ArrayList<Integer> a2 = (ArrayList<Integer>) ois2.readObject();
        Map<Integer, Integer> m1 = new TreeMap<>();
        Map<Integer, Integer> m2 = new TreeMap<>();
        for(Integer x : a1) {
            if(check(x)) {
                if(m1.containsKey(x))
                    m1.put(x, m1.get(x) + 1);
                else
                    m1.put(x, 1);
            }
        }
        for(Integer x : a2) {
            if(check(x)) {
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
