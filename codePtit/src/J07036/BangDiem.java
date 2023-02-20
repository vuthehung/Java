/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07036;

import java.text.DecimalFormat;

/**
 *
 * @author Admin
 */
public class BangDiem implements Comparable<BangDiem>{
    private SinhVien sv;
    private MonHoc mh;
    private float diem;
    
    public BangDiem(SinhVien sv, MonHoc mh, float diem) {
        this.sv = sv;
        this.mh = mh;
        this.diem = diem;
    }

    public SinhVien getSV() {
        return sv;
    }
    
    @Override
    public int compareTo(BangDiem o) {
        if(this.mh.getMa().equals(o.mh.getMa()))
            return this.sv.getMa().compareTo(o.sv.getMa());
        return this.mh.getMa().compareTo(o.mh.getMa());
    }
    
    @Override
    public String toString() {
        return sv.getMa() + " " + sv.getTen() + " " + mh.getMa() + " " + mh.getTen() + " " + new DecimalFormat("0.#").format(diem);
    }
}
