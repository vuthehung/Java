/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07020;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String ma;
    private int soLuong, thanhTien;
    private KhachHang kh;
    private MatHang mh;
    
    public HoaDon(int i, KhachHang kh, MatHang mh, int soLuong) {
        this.ma = "HD" + String.format("%03d", i);
        this.kh = kh;
        this.mh = mh;
        this.soLuong = soLuong;
      
        this.thanhTien = mh.getGiaBan() * soLuong;
    }
    
    @Override
    public String toString() {
        return ma + " " + kh.getTen() + " " + kh.getDc() + " " 
                + mh.getTen() + " " + mh.getDvTinh() + " " + mh.getGiaMua() + " " + mh.getGiaBan()
                + " " + soLuong + " " + thanhTien;
    }
}
