/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07028;

/**
 *
 * @author Admin
 */
public class GioChuan {
    private GiangVien gv;
    private float gioChuan;
    
    public GioChuan(GiangVien gv, float gioChuan) {
        this.gv = gv;
        this.gioChuan = gioChuan;
    }
    
    public GiangVien getGV() {
        return gv;
    }
    
    
    @Override
    public String toString() {
        return gv.getTen() + " " + String.format("%.2f", gioChuan);
    }
}
