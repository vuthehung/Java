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

public class NutTatBat_Am extends NutTrenManHinh_Pause {

    private BufferedImage[][] anhNutAmThanh;
    private boolean mouseOver, mousePressed;
    private boolean muted;
    private int hang, cot;

    public NutTatBat_Am(int x, int y, int w, int h) {
        super(x, y, w, h);

        taiAnhNutTatBat();
    }

    private void taiAnhNutTatBat() {
        BufferedImage tmp = DocHinhAnh.LuuHinhAnh(DocHinhAnh.NutTatBat_Am);
        anhNutAmThanh = new BufferedImage[2][3];
        for (int j = 0; j < anhNutAmThanh.length; j++) {
            for (int i = 0; i < anhNutAmThanh[j].length; i++) {
                anhNutAmThanh[j][i] = tmp.getSubimage(i * 42, j * 42, 42, 42);
            }
        }
    }

    public void capNhat() {
        if (muted) {
            hang = 1;
        } else {
            hang = 0;
        }

        cot = 0;
        if (mouseOver) {
            cot = 1;
        }
        if (mousePressed) {
            cot = 2;
        }

    }

    public void datLaiGiaTriBoo() {
        mouseOver = false;
        mousePressed = false;
    }

    public void ve(Graphics g) {
        g.drawImage(anhNutAmThanh[hang][cot], x, y, w, h, null);
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

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

}
