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
public class J07005 {
   //doc file nhi phan: datainputstream
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataInputStream dt = new DataInputStream(new FileInputStream("DATA.IN"));
        Map<Integer, Integer> m = new TreeMap<>();
        
        for(int i = 0; i < 100000; i++) {
            int t = dt.readInt();
            if(m.containsKey(t)) {
                int value = m.get(t);
                value++;
                m.put(t, value);
            }else {
                m.put(t, 1);
            }
        }
        m.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
