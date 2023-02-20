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
class WordSet {
    public Set<String> s;
    
    public WordSet() {
        s = new TreeSet<>();
    }
    
    public WordSet(String fN) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fN));
        s = new TreeSet<>();
        while(sc.hasNext()) {
            s.add(sc.next().toLowerCase());
        }
    }
    
    public WordSet union(WordSet o) {
        WordSet res = new WordSet();
        for(String x : this.s) 
            res.s.add(x);
        for(String x : o.s)
            res.s.add(x);
        return res;
    }
    
    public WordSet intersection(WordSet o) {
        WordSet res = new WordSet();
        for(String x : this.s) {
            if(o.s.contains(x)) {
                res.s.add(x);
            }
        }
        return res;
    }
    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(String x : s) {
            res.append(x + " ");
        }
        return res.toString().trim();
    }
}
public class J07014 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
