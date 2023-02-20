/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05071;

import java.util.*;


/**
 *
 * @author Admin
 */
public class CuocGoi {
    public static Map<String, TTP> m = new HashMap<>();
    private String tb, maT;
    private int soP;
    private long giaC;
    
    public CuocGoi(String tb, String bd, String kt) {
        this.tb = tb;
        tinhSoP(tb, bd, kt);
        tinhGiaC(tb);
    }

    private void tinhSoP(String tb, String bd, String kt) {
        String[] t1 = bd.split(":");
        String[] t2 = kt.split(":");
        int soP = (Integer.parseInt(t2[0]) - Integer.parseInt(t1[0])) * 60 + (Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]));
        if(tb.startsWith("0")) {
            this.soP = soP;
        }else {
            this.soP = (int) Math.round(soP / 3d);
        }
    }

    private void tinhGiaC(String tb) {
        if(tb.startsWith("0")) {
            this.maT = tb.substring(1, 3);
            this.giaC = m.get(tb.substring(1, 3)).getGia() * soP;
        }else {
            this.maT = "Noi mang";
            this.giaC = m.get("Noi mang").getGia() * soP;
        }
    }
    
    @Override
    public String toString() {
        return tb + " " + m.get(maT).getTen() + " " + soP + " " + giaC;
    }
}
