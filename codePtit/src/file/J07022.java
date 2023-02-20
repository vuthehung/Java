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
public class J07022 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList<String> a_s = new ArrayList<>();
        while(sc.hasNext()) {
            String tmp = sc.next();
            try {
                int t = Integer.parseInt(tmp);
            }catch (NumberFormatException e){
                a_s.add(tmp);
            }
        }
        Collections.sort(a_s);
        for(String s : a_s) {
            System.out.print(s + " ");
        }
    }
}
