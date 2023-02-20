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
class MonHoc {
    String ma, ten;
    int tc;
    
    void input(Scanner sc) {
        sc.nextLine();
        ma = sc.nextLine();
        ten = sc.nextLine();
        tc = sc.nextInt();
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + tc;
    }
}
public class J07034 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        ArrayList<MonHoc> mh = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            MonHoc tmp = new MonHoc();
            tmp.input(sc);
            mh.add(tmp);
        }
        Collections.sort(mh, (MonHoc o1, MonHoc o2) -> o1.ten.compareTo(o2.ten));
        for(MonHoc x : mh) {
            System.out.println(x);
        }
    }
}
