/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07038;

/**
 *
 * @author Admin
 */
public class DoanhNghiep {
    private String ma, ten;
    private int soL;
    
    public DoanhNghiep(String ma, String ten, int soL) {
        this.ma = ma;
        this.ten = ten;
        this.soL = soL;
    }
    
    public String getMa() {
        return ma;
    }
    
    public String getTen() {
        return ten;
    }
    
    public int getSoL() {
        return soL;
    }
}
