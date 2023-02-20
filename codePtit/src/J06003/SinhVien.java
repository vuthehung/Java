/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06003;

/**
 *
 * @author Admin
 */
public class SinhVien {
    private String ma, hoTen, sdt;
    private int sttNhom;
    
    public SinhVien(String ma, String hoTen, String sdt, int sttNhom) {
        this.sttNhom = sttNhom;
        this.ma = ma;
        this.hoTen = hoTen;
        this.sdt = sdt;
    }
    
    public int getSttNhom() {
        return sttNhom;
    }
    
    @Override
    public String toString() {
        return ma + " " + hoTen + " " + sdt;
    }
}
