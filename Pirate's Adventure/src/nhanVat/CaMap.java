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
import static phuongThucTaiSuDung.HangSo.QuaiVat.*;
import static phuongThucTaiSuDung.PhuongThucXuLyXuKien.*;

import trangThai.Playing;

public class CaMap extends QuaiVat {

    public CaMap(float x, float y) {
        super(x, y, 51, 45, CaMap);
        khoiTaoHitbox(18, 22);
        khoiTaoAttackBox(20, 20, 20);
    }

    public void capNhat(int[][] lvlData, Playing playing) {
        capNhatHanhVi(lvlData, playing);
        capNhatHoatAnh();
        capNhatHuongAttackBox();
    }

    private void capNhatHanhVi(int[][] chatLieu, Playing playing) {
        if (capNhatLanDau) {
            kiemTraCapNhatLanDau(chatLieu);
        }

        if (trenKhong) {
            kiemTraTrenKhong(chatLieu, playing);
        } else {
            switch (trangThai) {
                case Dung:
                    if (LaMatDat(hitbox, chatLieu)) {
                        trangThaiMoi(DiChuyen);
                    } else {
                        trenKhong = true;
                    }
                    break;
                case DiChuyen:
                    if (tamNhin(chatLieu, playing.getCuopBien())) {
                        quayVeHuongCuopBien(playing.getCuopBien());
                        if (trongTamDanh(playing.getCuopBien())) {
                            trangThaiMoi(TanCong);
                        }
                    }

                    diChuyen(chatLieu);
                    break;
                case TanCong:
                    if (aniI == 0) {
                        kiemTraTanCong = false;
                    } else if (aniI == 3) {
                        if (!kiemTraTanCong) {
                            cuopBienBiTanCong(attackBox, playing.getCuopBien());
                        }
                        tanCong(chatLieu, playing);
                    }

                    break;
                case BiTanCong:
                    if (aniI <= ViTriHinhAnh(loaiQV, trangThai) - 2) {
                        dayLui(huongBiDayLui, chatLieu, 2f);
                    }
                    capNhatTocDoXuongKhiBiTanCong();
                    break;
            }
        }
    }

    //trạng thái tấn công của cá mập tăng khoảng cách tấn công so với khoảng cách di chuyển
    protected void tanCong(int[][] chatLieu, Playing playing) {
        float tocDo = 0;

        if (huongDi == Trai) {
            tocDo = -tocDoDiChuyen;
        } else {
            tocDo = tocDoDiChuyen;
        }

        if (CoTheDiChuyenDen(hitbox.x + tocDo * 4, hitbox.y, hitbox.width, hitbox.height, chatLieu)) {
            if (LaMatDat(hitbox, tocDo * 4, chatLieu)) {
                hitbox.x += tocDo * 4;
                return;
            }
        }
        trangThaiMoi(Dung);
    }
}
