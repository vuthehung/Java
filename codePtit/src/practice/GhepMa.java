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
public class GhepMa {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<String> a1 = (ArrayList<String>) ois.readObject();
        Set<String> s1 = new TreeSet<>();
        s1.addAll(a1);
        ois = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a2 = (ArrayList<Integer>) ois.readObject();
        Set<Integer> s2 = new TreeSet<>();
        s2.addAll(a2);
        for(String s : s1) {
            for(Integer x : s2) {
                System.out.println(s + x);
            }
        }
        ois.close();
    }
}
