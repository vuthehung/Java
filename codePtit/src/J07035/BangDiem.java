/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07035;

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

    public MonHoc getMH() {
        return mh;
    }
    
    @Override
    public int compareTo(BangDiem o) {
        if(this.diem == o.diem)
            return this.sv.getMa().compareTo(o.sv.getMa());
        else if(this.diem > o.diem) {
            return -1;
        }else {
            return 1;
        }
    }
    
    @Override
    public String toString() {
        return sv.getMa() + " " + sv.getTen() + " " + sv.getLop() + " " + new DecimalFormat("0.#").format(diem);
    }
}
