/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05046;

/**
 *
 * @author Admin
 */
public class MatHang {
    private String ma, ten;
    private int soLuong, donGia, tienChietKhau, thanhTien;
    
    public MatHang(String ma, String ten, int soLuong, int donGia) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.donGia = donGia;
        
        tinhTienChietKhau(soLuong, donGia);
        this.thanhTien = soLuong * donGia - tienChietKhau;
    }

    private void tinhTienChietKhau(int soLuong, int donGia) {
        if(soLuong > 10) {
            this.tienChietKhau = (int) (donGia * soLuong * 0.05f);
        }else if(soLuong >= 8 && soLuong <= 10) {
            this.tienChietKhau = (int) (donGia * soLuong * 0.02f);
        }else if(soLuong >= 5 && soLuong < 8) {
            this.tienChietKhau = (int) (donGia * soLuong * 0.01f);
        }else {
            this.tienChietKhau = 0;
        }
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + tienChietKhau + " " + thanhTien;
    }
}
