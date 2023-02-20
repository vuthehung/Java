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
public class J07053 {

    public class XetTuyen {

        private String ma, ten, xepLoai, ngaySinh;
        private double diemLT, diemTH, diemThuong;
        private int tongDiem, tuoi;

        public XetTuyen() {
        }

        public void setMa(int i) {
            this.ma = "PH" + (i >= 10 ? i : "0" + i);
        }

        public void setTen(String s) {
            s = s.toLowerCase();
            s = s.trim();
            String[] a = s.split(" ");
            s = "";
            for (int i = 0; i < a.length; i++) {
                if (a[i].length() > 0) {
                    String tmp = a[i].substring(0, 1);
                    s = s + tmp.toUpperCase() + a[i].substring(1) + " ";
                }
            }
            this.ten = s.trim();
        }

        public void setTuoi() {
            String[] a = this.ngaySinh.split("/");
            this.tuoi = 2021 - Integer.parseInt(a[2]);
        }

        public void setDiemThuong() {
            if (this.diemLT >= 8 && this.diemTH >= 8) {
                this.diemThuong = 1;
            } else if (this.diemLT >= 7.5 && this.diemTH >= 7.5) {
                this.diemThuong = 0.5;
            } else {
                this.diemThuong = 0;
            }
        }

        public void setTongDiem() {
            int diem = (int) Math.round((this.diemLT + this.diemTH) / 2 + this.diemThuong);
            if (diem <= 10) {
                this.tongDiem = diem;
            } else {
                this.tongDiem = 10;
            }
        }

        public void setXepLoai() {
            if (this.tongDiem < 5) {
                this.xepLoai = "Truot";
            } else if (this.tongDiem == 5 || this.tongDiem == 6) {
                this.xepLoai = "Trung binh";
            } else if (this.tongDiem == 7) {
                this.xepLoai = "Kha";
            } else if (this.tongDiem == 8) {
                this.xepLoai = "Gioi";
            } else {
                this.xepLoai = "Xuat sac";
            }
        }

        public static void main(String[] args) throws FileNotFoundException {
            Scanner sc = new Scanner(new File("XETTUYEN.in"));
            int n = sc.nextInt();
            XetTuyen[] ds = new XetTuyen[n];
            for (int i = 0; i < n; i++) {
                String b = sc.nextLine();
                ds[i] = new XetTuyen();
                ds[i].setMa(i + 1);
                String tmp = sc.nextLine();
                ds[i].setTen(tmp);
                ds[i].ngaySinh = sc.nextLine();
                ds[i].diemLT = sc.nextDouble();
                ds[i].diemTH = sc.nextDouble();
                ds[i].setTuoi();
                ds[i].setDiemThuong();
                ds[i].setTongDiem();
                ds[i].setXepLoai();
            }
            for (int i = 0; i < n; i++) {
                System.out.println(ds[i].ma + " " + ds[i].ten + " " + ds[i].tuoi + " " + ds[i].tongDiem + " " + ds[i].xepLoai);
            }
        }
    }
}