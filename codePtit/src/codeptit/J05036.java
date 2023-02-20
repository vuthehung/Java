/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
class MatHang {
    private String ma, ten, dvTinh;
    private int giaNhap, soLuong, phiVC, thanhTien, giaBan;
    
    public MatHang(int i, String ten, String dvTinh, int giaNhap, int soLuong) {
        this.ma = "MH" + String.format("%02d", i);
        this.ten = ten;
        this.dvTinh = dvTinh;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.phiVC = Math.round(giaNhap * soLuong / 100 * 5);
        this.thanhTien = Math.round(giaNhap * soLuong + phiVC);
        this.giaBan = Math.round(thanhTien + 2 * thanhTien / 100);
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + dvTinh + " " + phiVC + " "
                + thanhTien + " " + giaBan;
    }
}
public class J05036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= n; i++) {
            MatHang mh = new MatHang(i, sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            System.out.println(mh);
        }
    }
}
