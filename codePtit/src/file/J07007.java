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
    Set<String> s;
    
    public WordSet(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        s = new TreeSet<>();
        while(sc.hasNext()) {
            s.add(sc.next().toLowerCase());
        }
    }
    
    @Override
    public String toString() {
        String res = "";
        for(String i : s) {
            res += i + "\n";
        }
        return res;
    }
}
public class J07007 {
    public static void main(String[] args) throws IOException{
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
}
