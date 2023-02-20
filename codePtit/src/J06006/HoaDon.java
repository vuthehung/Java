/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06006;



/**
 *
 * @author Admin
 */
public class HoaDon implements Comparable<HoaDon>{
    private String ma;
    private KhachHang kh;
    private MatHang mh;
    private int soLuong, thanhTien, loiNhuan;
    
    public HoaDon(int i, KhachHang kh, MatHang mh, int soLuong) {
        this.ma = "HD" + String.format("%03d", i);
        this.kh = kh;
        this.mh = mh;
        this.soLuong = soLuong;
        this.thanhTien = soLuong * mh.getGiaBan();
        this.loiNhuan = thanhTien - soLuong * mh.getGiaMua();
    }
    
    @Override
    public String toString() {
        return ma + " " + kh.getTen() + " " + kh.getDc() + " " 
                + mh.getTen() + " " + soLuong + " " + thanhTien + " " + loiNhuan;
    }

    @Override
    public int compareTo(HoaDon o) {
        if(this.loiNhuan != o.loiNhuan)
            return o.loiNhuan - this.loiNhuan;
        return this.ma.compareTo(o.ma);
    }
}
