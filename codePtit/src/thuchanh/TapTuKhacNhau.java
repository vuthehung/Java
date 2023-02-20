/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
class WordSet{
    private Set<String> s;
    
    public WordSet() {
        s = new TreeSet<>();
    }
    public WordSet(String line) {
        s = new TreeSet<>();
        s.addAll(Arrays.asList(line.trim().toLowerCase().split("\\s+")));
    }
    
    public WordSet union(WordSet o) {
        WordSet res = new WordSet();
        for(String x : this.s) {
            res.s.add(x);
        }
        for(String x : o.s) {
            res.s.add(x);
        }
        return res;
    }
    
    public WordSet intersection(WordSet o) {
        WordSet res = new WordSet();
        for(String x : this.s) {
            if(o.s.contains(x)) 
                res.s.add(x);
        }
        return res;
    }
    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        for(String x : s) {
            res.append(x + " ");
        }
        return res.toString().trim();
    }
}
public class TapTuKhacNhau {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("VANBAN.in"));
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
