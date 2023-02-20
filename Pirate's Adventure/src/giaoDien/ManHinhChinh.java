/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaoDien;
/**
 *
 * @author Admin
 */



import java.awt.*;
import java.awt.image.BufferedImage;

import trangThai.KhoiTaoTrangThai;
import phuongThucTaiSuDung.DocHinhAnh;

public class ManHinhChinh {

    private int x, y, hang, i;
    private KhoiTaoTrangThai trangThai;
    private BufferedImage[] imgs;
    private boolean mouseOver, mousePressed;
    private Rectangle bien;

    public ManHinhChinh(int x, int y, int hang, KhoiTaoTrangThai trangThai) {
        this.x = x;
        this.y = y;
        this.hang = hang;
        this.trangThai = trangThai;
        taiAnh();
        khoiTaoBien();
    }

    //tạo 1 hình chữ nhật bao xung quanh nút (biên)
    private void khoiTaoBien() {
        bien = new Rectangle(x - (210 / 2), y, 210, 84);
    }

    //tải ảnh: có 3 ảnh bao gồm: 1 là chưa ấn chuột, 2 khi đưa chuột vào, 3 khi ấn chuột
    private void taiAnh() {
        imgs = new BufferedImage[3];
        BufferedImage temp = DocHinhAnh.LuuHinhAnh(DocHinhAnh.NUT_LUA_CHON);
        for (int j = 0; j < imgs.length; j++) {
            imgs[j] = temp.getSubimage(j * 140, hang * 56, 140, 56);
        }
    }

    public void ve(Graphics g) {
        g.drawImage(imgs[i], x - (210 / 2), y, 210, 84, null);
    }

    public void capNhat() {
        i = 0;
        //khi đưa chuột vào
        if (mouseOver) {
            i = 1;
        }
        //khi ấn chuột
        if (mousePressed) {
            i = 2;
        }
    }
    
    public void suDungTrangThai() {
        KhoiTaoTrangThai.trangThai = trangThai;
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

    public void datLai() {
        mouseOver = false;
        mousePressed = false;
    }

    public KhoiTaoTrangThai getTrangThai() {
        return trangThai;
    }
    public Rectangle getBien() {
        return bien;
    }

}
