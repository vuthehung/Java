/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06004;

/**
 *
 * @author Admin
 */
public class SinhVien implements Comparable<SinhVien>{
    private String ma, ten, sdt;
    private int sttNhom;
    private Nhom g;
    
    public SinhVien(String ma, String ten, String sdt, int sttNhom) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.sttNhom = sttNhom;
        this.g = new Nhom();
    }
    
    public int getSttNhom() {
        return sttNhom;
    }
    @Override
    public int compareTo(SinhVien o) {
        return this.ma.compareTo(o.ma);
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + sdt + " " + " "
                + g.getNhom(sttNhom);
    }
}
