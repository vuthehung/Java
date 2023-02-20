/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaoDien;
/**
 *
 * @author Admin
 */

import java.awt.Rectangle;

public class NutTrenManHinh_Pause {

    protected int x, y, w, h;
    //biên(hcn bao quanh vật thể)
    protected Rectangle bien;

    public NutTrenManHinh_Pause(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        taoBien();
    }

    //tạo hình chữ nhật bao quanh nút(biên).
    private void taoBien() {
        bien = new Rectangle(x, y, w, h);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Rectangle getBien() {
        return bien;
    }

    public void setBien(Rectangle bien) {
        this.bien = bien;
    }

}
