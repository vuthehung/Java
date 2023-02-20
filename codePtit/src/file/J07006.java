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
public class J07006 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> l = (List<Integer>) ois.readObject();
        Map<Integer, Integer> m = new TreeMap<>();
        
        for(int i : l) {
            if(m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            }else {
                m.put(i, 1);
            }
        }
        
        m.forEach((k, v) -> System.out.println(k + " " + v));
        
    }
}
