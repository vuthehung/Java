/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05015;

/**
 *
 * @author Admin
 */
public class CuaRo implements Comparable<CuaRo>{
    private String ma, ten, donVi;
    private String[] tG;
    private float v;
    
    public CuaRo(String ten, String donVi, String tGD) {
        this.ten = ten;
        this.donVi = donVi;
        this.tG = tGD.split(":");
        chuanHoaMa();
        tinhVanToc();
    }

    private void chuanHoaMa() {
        String[] tmp1 = this.ten.toUpperCase().split(" ");
        String[] tmp2 = this.donVi.toUpperCase().split(" ");
        String res = "";
        for(int i = 0; i < tmp2.length; i++) {
            res += tmp2[i].charAt(0);
        }
        for(int i = 0; i < tmp1.length; i++) {
            res += tmp1[i].charAt(0);
        }
        this.ma = res;
    }

    private void tinhVanToc() {
        float tg = Float.parseFloat(this.tG[0]) - 6 + Float.parseFloat(this.tG[1]) / 60;
        this.v = 120 / tg;
    }

    @Override
    public int compareTo(CuaRo o) {
        return Integer.parseInt(this.tG[0] + this.tG[1]) - Integer.parseInt(o.tG[0] + o.tG[1]);
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + donVi + " " + Math.round(v) + " Km/h" ;
    }
    
}
