/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05011;

/**
 *
 * @author Admin
 */
public class Gio implements Comparable<Gio>{
    private String ma, ten;
    private String[] vao, ra;
    private long time;
    
    public Gio(String ma, String ten, String vao, String ra) {
        this.ma = ma;
        this.ten = ten;
        this.vao = vao.split(":");
        this.ra = ra.split(":");
        this.time = (Integer.parseInt(this.ra[0]) - Integer.parseInt(this.vao[0])) * 60 + Integer.parseInt(this.ra[1]) - Integer.parseInt(this.vao[1]);     
    }

    @Override
    public int compareTo(Gio o) {
        if(this.time > o.time) return -1;
        return 1;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %d gio %d phut", ma, ten, time / 60, time % 60);
    }
}
