/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

/**
 *
 * @author Admin
 */
import java.io.*;
import java.util.*;

class Data {

    public String word;
    int fre;

    public Data(String word, int fre) {
        this.word = word;
        this.fre = fre;
    }

    @Override
    public String toString() {
        return word + " " + fre;
    }
}

public class J07012 {

    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<String> arr = (ArrayList<String>) ois.readObject();
        ArrayList<String> words = new ArrayList<>();
        for (String x : arr) {
            String s = x.toLowerCase();
            int j = 0;
            while (j < s.length()) {
                if (Character.isLetterOrDigit(s.charAt(j))) {
                    int k = j;
                    while (k < s.length() && Character.isLetterOrDigit(s.charAt(k))) {
                        k++;
                    }
                    words.add(s.substring(j, k));
                    j = k;
                } else {
                    j++;
                }
            }
        }
        HashMap<String, Integer> cnt = new HashMap<>();
        for (String x : words) {
            if (!cnt.containsKey(x)) {
                cnt.put(x, 1);
            } else {
                cnt.put(x, cnt.get(x) + 1);
            }
        }
        ArrayList<Data> res = new ArrayList<>();
        cnt.forEach((key, value) -> {
            res.add(new Data(key, value));
        });
        res.sort((x, y) -> {
            if (x.fre != y.fre) {
                return y.fre - x.fre;
            }
            return x.word.compareTo(y.word);
        });
        for (Data x : res) {
            System.out.println(x);
        }
    }
}
