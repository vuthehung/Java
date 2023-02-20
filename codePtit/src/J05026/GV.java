/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05026;

/**
 *
 * @author Admin
 */
public class GV{
    private String ma, hoTen, ten, boMon;
    
    public GV(int i, String hoTen, String boMon) {
        this.ma = "GV" + String.format("%02d", i);
        this.hoTen = hoTen;
        this.boMon = boMon;
        String[] s = hoTen.split(" ");
        this.ten = s[s.length - 1];
    }

    public String getBoMon() {
        return boMon;
    }
    @Override
    public String toString() {
        return ma + " " + hoTen + " " + boMon;
    }
}