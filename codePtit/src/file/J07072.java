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
class Ten implements Comparable<Ten>{
    private String hoTen, ho, dem, ten;
    
    public Ten(String hoTen) {
        this.hoTen = hoTen;
        String[] s = this.hoTen.split(" ");
        this.ho = s[0];
        String tmp = "";
        for(int i = 1; i < s.length - 1; i++) {
            tmp += s[i] + " ";
        }
        this.dem = tmp.trim();
        this.ten = s[s.length - 1];
    }
    
    @Override
    public String toString() {
        return hoTen;
    }
    @Override
    public int compareTo(Ten o) {
        if(!this.ten.equals(o.ten))
            return this.ten.compareTo(o.ten);
        else if(!this.ho.equals(o.ho))
            return this.ho.compareTo(o.ho);
        else
            return this.dem.compareTo(o.dem);
    }
    
}
public class J07072 {
    public static String chuanHoa(String s) {
        StringBuilder kq = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            String tmp = st.nextToken().toLowerCase();
            kq.append(Character.toUpperCase(tmp.charAt(0)));
            for(int i = 1; i < tmp.length(); i++)
                kq.append(tmp.charAt(i));
            kq.append(" ");
        }
        return kq.toString().trim();
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\code\\Java\\codePtit\\src\\file\\SV.in"));
        ArrayList<Ten> a = new ArrayList<>();
        while(sc.hasNextLine()) {
            Ten t = new Ten(chuanHoa(sc.nextLine()));
            a.add(t);
        }
        Collections.sort(a);
        for(Ten x : a) {
            System.out.println(x);
        }
    }
}
