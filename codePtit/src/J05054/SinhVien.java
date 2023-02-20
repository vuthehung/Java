/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05054;

/**
 *
 * @author Admin
 */
public class SinhVien implements Comparable<SinhVien>{
    private String ma, ten, xepLoai;
    private int xepHang;
    private float dTB;
    
    public SinhVien(int i, String ten, float dTB) {
        this.ma = String.format("HS%02d", i);
        this.ten = ten;
        this.dTB = dTB;
        xepLoaiSV(dTB);
    }

    private void xepLoaiSV(float dTB) {
        if(dTB < 5) {
            this.xepLoai = "Yeu";
        }else if(dTB >= 5 && dTB < 7) {
            this.xepLoai = "Trung Binh";
        }else if(dTB >= 7 && dTB < 9) {
            this.xepLoai = "Kha";
        }else {
            this.xepLoai = "Gioi";
        }
    }
    
    public float getDTB() {
        return dTB;
    }
    
    public void setXepHang(int i) {
        this.xepHang = i;
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + dTB + " " + xepLoai + " " + xepHang;
    }

    @Override
    public int compareTo(SinhVien o) {
        if(this.dTB > o.dTB) return -1;
        else if(this.dTB < o.dTB) return 1;
        else return 0;
    }
}
