/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05022;

/**
 *
 * @author Admin
 */
public class SinhVien{
    private String ma, ten, lop, email;
    
    public SinhVien(String ma, String ten, String lop, String email) {
        this.ma = ma; 
        this.ten = ten;
        this.lop = lop;
        this.email = email;
    }
    
    public String getLop() {
        return lop;
    }
    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + email;
    }
}

