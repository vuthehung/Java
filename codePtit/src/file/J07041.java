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
class Pair implements Serializable, Comparable<Pair> {

    private int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return this.first;
    }
 
    public int getSecond() {
        return this.second;
    }

    @Override
    public int compareTo(Pair o) {
        return this.first - o.getFirst();
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }
}

public class J07041 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream obj = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Pair> a = (ArrayList<Pair>) obj.readObject();
        Collections.sort(a);
        Set<String> set = new HashSet<>();
        for (Pair x : a) {
            String s = String.valueOf(x.getFirst()) + "-" + String.valueOf(x.getSecond());
            if (x.getFirst() < x.getSecond() && !set.contains(s)) {
                set.add(s);
                System.out.println(x);
            }
        }
    }
}
