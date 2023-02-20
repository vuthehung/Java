/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaoDien;
/**
 *
 * @author Admin
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import phuongThucTaiSuDung.DocHinhAnh;

public class Nut_QL_TT extends NutTrenManHinh_Pause {

    private BufferedImage[] anh;
    private int hang, i;
    private boolean mouseOver, mousePressed;

    public Nut_QL_TT(int x, int y, int w, int h, int hang) {
        super(x, y, w, h);
        this.hang = hang;
        loadImgs();
    }

    private void loadImgs() {
        BufferedImage temp = DocHinhAnh.LuuHinhAnh(DocHinhAnh.NUT_QL_TT);
        anh = new BufferedImage[3];
        for (int j = 0; j < anh.length; j++) {
            anh[j] = temp.getSubimage(j * 56, hang * 56, 56, 56);
        }

    }

    public void capNhat() {
        i = 0;
        if (mouseOver) {
            i = 1;
        }
        if (mousePressed) {
            i = 2;
        }

    }

    public void ve(Graphics g) {
        g.drawImage(anh[i], x, y, 84, 84, null);
    }

    public void datLaiGiaTriBoo() {
        mouseOver = false;
        mousePressed = false;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

}
