/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05025;

/**
 *
 * @author Admin
 */
public class GV implements Comparable<GV>{
    private String ma, hoTen, ten, boMon;
    
    public GV(int i, String hoTen, String boMon) {
        this.ma = "GV" + String.format("%02d", i);
        this.hoTen = hoTen;
        this.boMon = boMon;
        String[] s = hoTen.split(" ");
        this.ten = s[s.length - 1];
    }

    @Override
    public int compareTo(GV o) {
        if(!this.ten.equals(o.ten)) {
            return this.ten.compareTo(o.ten);
        }
        return this.ma.compareTo(o.ma);
    }
    @Override
    public String toString() {
        return ma + " " + hoTen + " " + boMon;
    }
}
