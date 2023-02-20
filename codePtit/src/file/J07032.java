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
public class J07032 {

    public static boolean thuanNghich(int n) {
        String tmp = String.valueOf(n);
        String rev = "";
        for (int i = tmp.length() - 1; i >= 0; i--) {
            rev += tmp.charAt(i);
        }
        for (int i = 0; i < tmp.length(); i++) {
            if ((tmp.charAt(i) - '0') % 2 == 0) {
                return false;
            }
        }
        return tmp.equals(rev) && tmp.length() > 1 && tmp.length() % 2 != 0;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> l1 = (List<Integer>) ois1.readObject();
        List<Integer> l2 = (List<Integer>) ois2.readObject();
        Map<Integer, Integer> m = new TreeMap<>();
        for (int i : l2) {
            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            } else if (thuanNghich(i) && l1.indexOf(i) != -1) {
                m.put(i, 1);
            }
        }
        for (int i : l1) {
            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            }
        }
        int cnt = 0;
        for (Integer i : m.keySet()) {
            System.out.printf("%d %d\n", i, m.get(i));
            cnt++;
            if (cnt == 10) {
                break;
            }
        }
        ois1.close();
        ois2.close();

    }
}
