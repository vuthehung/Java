/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07035;

/**
 *
 * @author Admin
 */
public class SinhVien {
    private String ma, ten, lop, email;
    
    public SinhVien(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
    }
    
    public String getMa() {
        return ma;
    }
    public String getTen() {
        return ten;
    }
    public String getLop() {
        return lop;
    }
}
