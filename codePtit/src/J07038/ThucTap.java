/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07038;

/**
 *
 * @author Admin
 */
public class ThucTap implements Comparable<ThucTap>{
    private SinhVien sv;
    private DoanhNghiep dn;
    
    public ThucTap(SinhVien sv, DoanhNghiep dn) {
        this.sv = sv;
        this.dn = dn;
    }
    
    public SinhVien getSv() {
        return sv;
    }
    
    public DoanhNghiep getDn() {
        return dn;
    }
    
    @Override
    public String toString() {
        return sv.getMa() + " " + sv.getTen() + " " + sv.getLop();
    }

    @Override
    public int compareTo(ThucTap o) {
        return this.sv.getMa().compareTo(o.sv.getMa());
    }
}
