/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06003;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Nhom {
    private int sttNhom;
    private ArrayList<SinhVien> dsSV;
    private String noiDungBTL;
    
    public Nhom(int i, ArrayList<SinhVien> dsSV, String noiDungBTL) {
        this.sttNhom = i;
        this.dsSV = dsSV;
        this.noiDungBTL = noiDungBTL;
    }
    
    public int getSttNhom() {
        return sttNhom;
    }
    
    public ArrayList getDsSV() {
        return dsSV;
    }
    public String getNoiDungBTL() {
        return noiDungBTL;
    }
}
