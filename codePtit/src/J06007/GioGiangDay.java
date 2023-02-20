/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06007;

/**
 *
 * @author Admin
 */
public class GioGiangDay {
    private MonHoc mh;
    private GiangVien gv;
    private float gioChuan;
    
    public GioGiangDay(MonHoc mh, GiangVien gv) {
        this.mh = mh;
        this.gv = gv;
    }
    
    public void setGioChuan(float gioChuan) {
        this.gioChuan += gioChuan;
    }
    
    @Override
    public String toString() {
        return gv.getTen() + " " + String.format("%.02f", gioChuan);
    }
}
