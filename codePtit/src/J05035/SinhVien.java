/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05035;

/**
 *
 * @author Admin
 */
public class SinhVien implements Comparable<SinhVien>{
    private String stt, ma, ten, lop, email, doanhNghiep;
    
    public SinhVien(int i, String ma, String ten, String lop, String email, String doanhNghiep) {
        this.stt = Integer.toString(i);
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
        this.doanhNghiep = doanhNghiep;
    }
    
    public String getDoanhNghiep() {
        return doanhNghiep;
    }
    
    @Override
    public int compareTo(SinhVien o) {
        return this.ma.compareTo(o.ma);
    }
    @Override
    public String toString() {
        return stt + " " + ma + " " + ten + " " + lop + " "
                + email + " " + doanhNghiep;
    }
}
