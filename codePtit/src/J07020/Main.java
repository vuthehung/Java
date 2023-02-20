/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07020;

import java.io.*;
import java.text.ParseException;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException, ParseException {
        Scanner sc = new Scanner(new File("KH.in"));
        ArrayList<KhachHang> l_kh = new ArrayList<>();
        ArrayList<MatHang> l_mh = new ArrayList<>();
        ArrayList<HoaDon> l_hd = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= n; i++) {
            l_kh.add(new KhachHang(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        sc = new Scanner(new File("MH.in"));
        int m = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= m; i++) {
            l_mh.add(new MatHang(i, sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }
        sc = new Scanner(new File("HD.in"));
        int k = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= k; i++) {
            String[] tmp = sc.nextLine().split(" ");
            KhachHang kh = l_kh.get(Integer.parseInt(tmp[0].substring(2)) - 1);
            MatHang mh = l_mh.get(Integer.parseInt(tmp[1].substring(2)) - 1);
            int soLuong = Integer.parseInt(tmp[2]);
            l_hd.add(new HoaDon(i, kh, mh, soLuong));
        }
        
        for(HoaDon hd : l_hd) {
            System.out.println(hd);
        }
    }
}
