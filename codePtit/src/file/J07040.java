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
public class J07040 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        ArrayList<String> al = (ArrayList<String>) ois.readObject();
        Set<String> s = new TreeSet<>();
        for(String i : al) {
            String[] word = i.trim().toLowerCase().split("\\s+");
            s.addAll(Arrays.asList(word));
        }
        Scanner sc = new Scanner(new File("VANBAN.in"));
        while(sc.hasNext()) {
            String x = sc.next().toLowerCase();
            if(s.contains(x)) {
                System.out.println(x);
                s.remove(x);
            }
        }
        ois.close();
    }
}
