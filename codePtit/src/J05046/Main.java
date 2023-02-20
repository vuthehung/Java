/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05046;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static String maMatHang(String s) {
        String[] tmp = s.toUpperCase().split(" ");
        String res = "";
        res += tmp[0].charAt(0);
        res += tmp[1].charAt(0);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<MatHang> a = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            String ma = "";
            String ten = sc.nextLine();
            int soLuong = Integer.parseInt(sc.nextLine());
            int giaBan = Integer.parseInt(sc.nextLine());
            String mMH = maMatHang(ten);
            //System.out.println(mMH);
            if(m.containsKey(mMH)) {
                ma = mMH + "0" + Integer.toString(m.get(mMH) + 1);
                m.put(mMH, m.get(mMH) + 1);
            }else {
                ma = mMH + "01";
                m.put(mMH, 1);
            }
            a.add(new MatHang(ma, ten, soLuong, giaBan));
        }
        for(MatHang mh : a) {
            System.out.println(mh);
        }
    }
}
//3
//May lanh SANYO
//12
//4000000
//Dien thoai Samsung
//30
//3230000
//Dien thoai Nokia
//18
//1240000