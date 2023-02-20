/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05027;

/**
 *
 * @author Admin
 */
public class GiangVien {
    private String ma, ten, maBoMon;
    
    public GiangVien(int i, String ten, String maBoMon) {
        this.ma = String.format("GV%02d", i);
        this.ten = ten;
        this.maBoMon = maBoMon ;
    }
    
    public String getTen() {
        return ten;
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + maBoMon;
    }
}
