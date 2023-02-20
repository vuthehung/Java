/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05047;

/**
 *
 * @author Admin
 */
public class MatHang implements Comparable<MatHang>{
    private String ma, ten;
    private int tienHang, tienCK, thanhTien;
    
    public MatHang(String ma, String ten, int soL, int donGia) {
        this.ma = ma;
        this.ten = ten;
        this.tienHang = soL * donGia;
        tinhTienCK(soL);
        this.thanhTien = tienHang - tienCK;
    }

    private void tinhTienCK(int soL) {
        if(soL > 10) {
            this.tienCK = tienHang * 5 / 100;
        }else if(soL >= 8) {
            this.tienCK = tienHang * 2 / 100;
        }else if(soL >= 5) {
            this.tienCK = tienHang / 100;
        }else {
            this.tienCK = 0;
        }
    }

    @Override
    public int compareTo(MatHang o) {
        return o.tienCK - this.tienCK;
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + tienCK + " " + thanhTien;
    }
}
