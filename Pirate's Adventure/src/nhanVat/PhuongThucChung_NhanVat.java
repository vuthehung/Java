/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhanVat;
/**
 *
 * @author Admin
 */

import static phuongThucTaiSuDung.HangSo.Huong.*;
import static phuongThucTaiSuDung.PhuongThucXuLyXuKien.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;


public abstract class PhuongThucChung_NhanVat {

    protected float x, y;
    protected int w, h;
    protected Rectangle2D.Float hitbox;
    protected int aniT, aniI;
    protected int trangThai;
    protected float tocDoTrenKhong;
    protected boolean trenKhong = false;
    protected int mauToiDa;
    protected int mauHienTai;
    protected Rectangle2D.Float attackBox;
    protected float tocDoDiChuyen;

    protected int huongBiDayLui;
    protected float tocDoXuongKhiBiDayLui;
    protected int huongDayLui = Len;

    public PhuongThucChung_NhanVat(float x, float y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    protected void khoiTaoHitbox(int width, int height) {
        hitbox = new Rectangle2D.Float(x, y, (int) (width * 1.5f), (int) (height * 1.5f));
    }
    
    protected void veHitbox(Graphics g, int xLvlOffset) {
        g.setColor(Color.PINK);
        g.drawRect((int) hitbox.x - xLvlOffset, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }
    
    protected void veAttackBox(Graphics g, int xLvlOffset) {
        g.setColor(Color.red);
        g.drawRect((int) (attackBox.x - xLvlOffset), (int) attackBox.y, (int) attackBox.width, (int) attackBox.height);
    }

    //Đẩy lùi
    protected void dayLui(int huongDayLui, int[][] chatLieuu, float tocDoKhiBiDayLui) {
        float tocDo = 0;
        if (huongDayLui == Trai) {
            tocDo = -tocDoDiChuyen;
        } else {
            tocDo = tocDoDiChuyen;
        }

        if (CoTheDiChuyenDen(hitbox.x + tocDo * tocDoKhiBiDayLui, hitbox.y, hitbox.width, hitbox.height, chatLieuu)) {
            hitbox.x += tocDo * tocDoKhiBiDayLui;
        }
    }

    //cập nhật tốc độ rơi xuống khi bị tấn công
    protected void capNhatTocDoXuongKhiBiTanCong() {
        if (huongDayLui == Len) {
            tocDoXuongKhiBiDayLui -= 1f;
            if (tocDoXuongKhiBiDayLui <= -30f) {
                huongDayLui = Xuong;
            }
        } else {
            tocDoXuongKhiBiDayLui += 1f;
            if (tocDoXuongKhiBiDayLui >= 0) {
                tocDoXuongKhiBiDayLui = 0;
            }
        }
    }
    
    //Kiểm tra Nhân Vật có rơi xuống nước hay không?
    //Ở đây chỉ kiểm tra khi chạm vào mặt nước
    protected boolean RoiXuongNuoc(Rectangle2D.Float hitbox, int[][] chatLieu) {
        //Từ 0 -> 47: là ĐẤT
        // 48: là vị trí chứa hình ảnh mặt nước
        return ViTriHinhAnh(hitbox.x + hitbox.width, hitbox.y + hitbox.height, chatLieu) == 48;
    }

    protected void trangThaiMoi(int trangThai) {
        this.trangThai = trangThai;
        aniT = 0;
        aniI = 0;
    }
    
    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public int getAniI() {
        return aniI;
    }
}
