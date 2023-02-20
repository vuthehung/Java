/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07042;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Pair> a = (ArrayList<Pair>) ois.readObject();
        Collections.sort(a);
        Set<String> set = new HashSet<>();
        for(Pair x : a) {
            String s = String.valueOf(x.getFirst()) + "-" + String.valueOf(x.getSecond());
            BigInteger f = new BigInteger(String.valueOf(x.getFirst()));
            BigInteger se = new BigInteger(String.valueOf(x.getSecond()));
            if(x.getFirst() < x.getSecond() && f.gcd(se).toString().equals("1") && !set.contains(s)) {
                set.add(s);
                System.out.println(x);
            }
        }
    }
}
