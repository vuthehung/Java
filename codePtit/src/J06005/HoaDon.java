/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06005;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String ma;
    private KhachHang kh;
    private MatHang mh;
    private int soLuong, thanhTien;
    
    public HoaDon(int i, KhachHang kh, MatHang mh, int soLuong) {
        this.ma = "HD" + String.format("%03d", i);
        this.kh = kh;
        this.mh = mh;
        this.soLuong = soLuong;
        this.thanhTien = soLuong * mh.getGiaBan();
    }
    
    @Override
    public String toString() {
        return ma + " " + kh.getTen() + " " + kh.getDc() + " " 
                + mh.getTen() + " " + mh.getDvTinh() + " " + mh.getGiaMua() + " " + mh.getGiaBan()
                + " " + soLuong + " " + thanhTien;
    }
}
