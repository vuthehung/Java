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
class MonHoc implements Comparable<MonHoc> {
    private String maM, tenM, hinhThuc;
    
    public MonHoc(String maM, String tenM, String hinhThuc) {
        this.maM = maM;
        this.tenM = tenM;
        this.hinhThuc = hinhThuc;
    }
    
    public String getMaM() {
        return maM;
    }
    
    @Override
    public String toString() {
        return maM + " " + tenM + " " + hinhThuc;
    }
    @Override
    public int compareTo(MonHoc o) {
        return this.maM.compareTo(o.maM);
    }
    
}
public class J07058 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("MONHOC.in"));
        ArrayList<MonHoc> a = new ArrayList<>();
        Set<String> s = new TreeSet<>();
        while(sc.hasNextLine()) {
            MonHoc mh = new MonHoc(sc.nextLine(), sc.nextLine(), sc.nextLine());
            if(!s.contains(mh.getMaM())) {
                s.add(mh.getMaM());
                a.add(mh);
            }
        }
        Collections.sort(a); 
        
//        int n = Integer.parseInt(sc.nextLine());
//        for(int i = 1; i <= n; i++) {
//            MonHoc mh = new MonHoc(sc.nextLine(), sc.nextLine(), sc.nextLine());
//            a.add(mh);
//        }
//        Collections.sort(a);
//        for(MonHoc mh : a) {
//            System.out.println(mh);
//        }
    }
}
