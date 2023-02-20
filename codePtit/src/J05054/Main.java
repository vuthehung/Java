/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05054;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> a = new ArrayList<>();
        ArrayList<SinhVien> b = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= n; i++) {
            SinhVien sv = new SinhVien(i, sc.nextLine(), Float.parseFloat(sc.nextLine()));
            a.add(sv);
            b.add(sv);
        }
        Collections.sort(a);
        int j = 1, cnt = 0;
        a.get(0).setXepHang(1);
        for(int i = 1; i < n; i++) {
            if(a.get(i - 1).getDTB() == a.get(i).getDTB()) {
                a.get(i).setXepHang(j);
                cnt += 1;
            }else {
                j += cnt + 1;
                a.get(i).setXepHang(j);
                cnt = 0;
            }
        }
        for(SinhVien sv : b) {
            System.out.println(sv);
        }
        
    }
}
//3
//Tran Minh Hieu
//5.9
//Nguyen Bao Trung
//8.6
//Le Hong Ha
//9.2