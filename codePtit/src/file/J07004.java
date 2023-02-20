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
public class J07004 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        Map<Integer, Integer> m = new TreeMap<>();
        
        while(sc.hasNext()) {
            int t = Integer.parseInt(sc.next());
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
