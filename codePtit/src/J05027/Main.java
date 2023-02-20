/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05027;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<GiangVien> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            String[] tenBoMon = sc.nextLine().toUpperCase().split(" ");
            String maBoMon = "";
            for(int j = 0; j < tenBoMon.length; j++) {
                maBoMon += tenBoMon[j].charAt(0);
            }
            a.add(new GiangVien(i, ten, maBoMon));
        }
        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            String s = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + s + ":");
            for(GiangVien gv : a) {
                if(gv.getTen().toLowerCase().contains(s.toLowerCase())) {
                    System.out.println(gv);
                }
            }
        }
    }
}
//3
//Nguyen Manh Son
//Cong nghe phan mem
//Vu Hoai Nam
//Khoa hoc may tinh
//Dang Minh Tuan
//An toan thong tin
//1
//aN