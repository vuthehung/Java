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
    private Set<String> set;
    WordSet(String FileName) throws FileNotFoundException{
        Scanner sc=new Scanner(new File(FileName));
        set=new HashSet<>();
        while(sc.hasNext()){
            set.add(sc.next().toLowerCase());
        }
    }
    public Set<String> getSet(){
        return this.set;
    }
    public String difference(WordSet x){
        Set<String>set1=new HashSet<>(this.getSet());
        Set<String>set2=new HashSet<>(x.getSet());
        set1.removeAll(set2);
        ArrayList<String> a=new ArrayList<>(set1);
        Collections.sort(a);
        String out="";
        for(String s:a){
            out+=s+" ";
        }
        return out;
    }
}
public class J07024 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}
