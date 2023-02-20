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

public class NutDieuChinh_Am extends NutTrenManHinh_Pause {

    private BufferedImage[] imgs;
    private BufferedImage thanhDieuChinhAnh;
    private int i = 0;
    private boolean mouseOver, mousePressed;
    
    private int viTriNutKeo, viTriDauTien, viTriCuoi;
    private float giaTriAmLuong = 0f;

    public NutDieuChinh_Am(int x, int y, int w, int h) {
        super(x + w / 2, y, 42, h);
        bien.x -= 42 / 2;
        viTriNutKeo = x + w / 2;
        this.x = x;
        this.w = w;
        viTriDauTien = x + 42 / 2;
        viTriCuoi = x + w - 42 / 2;
        taiAnh();
    }

    //tải ảnh thanh kéo âm
    private void taiAnh() {
        BufferedImage tmp = DocHinhAnh.LuuHinhAnh(DocHinhAnh.THANH_KEO);
        imgs = new BufferedImage[3];
        for (int j = 0; j < imgs.length; j++) {
            imgs[j] = tmp.getSubimage(j * 28, 0, 28, 44);
        }

        thanhDieuChinhAnh = tmp.getSubimage(3 * 28, 0, 215, 44);

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

    public void draw(Graphics g) {

        g.drawImage(thanhDieuChinhAnh, x, y, w, h, null);
        g.drawImage(imgs[i], viTriNutKeo - 42 / 2, y, 42, h, null);

    }

    //nếu có sự thay đổi toạ độ của nút kéo so với vị trí ban đầu sẽ cập nhật âm lượng
    public void suThayDoi(int x) {
        if (x < viTriDauTien) {
            viTriNutKeo = viTriDauTien;
        } else if (x > viTriCuoi) {
            viTriNutKeo = viTriCuoi;
        } else {
            viTriNutKeo = x;
        }
        capNhatAmLuong();
        bien.x = viTriNutKeo - 42 / 2;

    }

    //cập nhật giá trị âm lượng sau khi kéo
    private void capNhatAmLuong() {
        float kcBanDau = viTriCuoi - viTriDauTien;
        float kcSauKeo = viTriNutKeo - viTriDauTien;
        giaTriAmLuong = kcSauKeo / kcBanDau;
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

    public float getGiaTriAmLuong() {
        return giaTriAmLuong;
    }
}
