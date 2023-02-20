/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhanVat;
/**
 *
 * @author Admin
 */

import java.awt.geom.Rectangle2D;

import static phuongThucTaiSuDung.PhuongThucXuLyXuKien.*;
import static phuongThucTaiSuDung.HangSo.QuaiVat.*;
import static phuongThucTaiSuDung.HangSo.Huong.*;

import trangThai.Playing;

public abstract class QuaiVat extends PhuongThucChung_NhanVat {

    protected int loaiQV;
    protected boolean capNhatLanDau = true;
    protected int huongDi = Trai;
    protected int tileY;
    protected boolean diChuyen = true;
    protected boolean kiemTraTanCong;
    protected int phanBuX_AttackBox;

    public QuaiVat(float x, float y, int w, int h, int loaiQV) {
        super(x, y, w, h);
        this.loaiQV = loaiQV;

        mauToiDa = MauQuaiVat(loaiQV);
        mauHienTai = mauToiDa;
        tocDoDiChuyen = 1.5f * 0.35f;
    }

    protected void capNhatAttackBox() {
        attackBox.x = hitbox.x - phanBuX_AttackBox;
        attackBox.y = hitbox.y;
    }

    protected void capNhatHuongAttackBox() {
        if (huongDi == Phai) {
            attackBox.x = hitbox.x + hitbox.width;
        } else {
            attackBox.x = hitbox.x - phanBuX_AttackBox;
        }

        attackBox.y = hitbox.y;
    }

    protected void khoiTaoAttackBox(int w, int h, int phanBuX_AttackBox) {
        attackBox = new Rectangle2D.Float(x, y, (int) (w * 1.5f), (int) (h * 1.5f));
        this.phanBuX_AttackBox = (int) (1.5f * phanBuX_AttackBox);
    }
    
    //lặp đi lặp lại các hoạt ảnh
    protected void capNhatHoatAnh() {
        aniT++;
        if (aniT >= 25) {
            aniT = 0;
            aniI++;
            if (aniI >= ViTriHinhAnh(loaiQV, trangThai)) {
                if (loaiQV == Cua || loaiQV == CaMap) {
                    aniI = 0;

                    switch (trangThai) {
                        case TanCong, BiTanCong ->
                            trangThai = Dung;
                        case Chet ->
                            diChuyen = false;
                    }
                } else if (loaiQV == SaoBien) {
                    if (trangThai == TanCong) {
                        aniI = 3;
                    } else {
                        aniI = 0;
                        if (trangThai == BiTanCong) {
                            trangThai = Dung;

                        } else if (trangThai == Chet) {
                            diChuyen = false;
                        }
                    }
                }
            }
        }
    }

    protected void kiemTraCapNhatLanDau(int[][] chatLieu) {
        if (!DungTrenMatDat(hitbox, chatLieu)) {
            trenKhong = true;
        }
        capNhatLanDau = false;
    }

    protected void kiemTraTrenKhong(int[][] chatLieu, Playing playing) {
        if (trangThai != BiTanCong && trangThai != Chet) {
            if (CoTheDiChuyenDen(hitbox.x, hitbox.y + tocDoTrenKhong, hitbox.width, hitbox.height, chatLieu)) {
                hitbox.y += tocDoTrenKhong;
                tocDoTrenKhong += 0.06;
            } else {
                trenKhong = false;
                hitbox.y = ViTri_KhiRoiXuong(hitbox, tocDoTrenKhong);
                tileY = (int) (hitbox.y / 48);
            }
            playing.getQuanLiO().kiemTraNeuChamVaoBay(this);
            if (RoiXuongNuoc(hitbox, chatLieu)) {
                truMau(mauToiDa);
            }
        }
    }

    protected void diChuyen(int[][] chatLieu) {
        float tocDo = 0;
        if (huongDi == Trai) {
            tocDo = -tocDoDiChuyen;
        } else {
            tocDo = tocDoDiChuyen;
        }

        if (CoTheDiChuyenDen(hitbox.x + tocDo, hitbox.y, hitbox.width, hitbox.height, chatLieu)) {
            if (LaMatDat(hitbox, tocDo, chatLieu)) {
                hitbox.x += tocDo;
                return;
            }
        }

        if (huongDi == Trai) {
            huongDi = Phai;
        } else {
            huongDi = Trai;
        }
    }

    //khi nhìn thấy cướp biển sẽ di chuyển về hướng của cướp biển
    protected void quayVeHuongCuopBien(CuopBien cb) {
        if (cb.hitbox.x > hitbox.x) {
            huongDi = Phai;
        } else {
            huongDi = Trai;
        }
    }

    //kiểm tra có nhìn thấy cướp biển ko? ko bị chắn
    protected boolean tamNhin(int[][] chatLieu, CuopBien cb) {
        int playerTileY = (int) (cb.getHitbox().y / 48);
        if (playerTileY == tileY) {
            if (trongTamNhin(cb)) {
                if (tamNhinKhongBiChan(chatLieu, hitbox, cb.hitbox, tileY)) {
                    return true;
                }
            }
        }
        return false;
    }

    //kiểm tra xem cướp biển có trong phạm vi nhìn thấy ko
    protected boolean trongTamNhin(CuopBien cb) {
        int khoangCach = (int) Math.abs(cb.hitbox.x - hitbox.x);
        return khoangCach <= 48 * 5;
    }

    //nếu thấy cướp biển trong tầm đánh thì lập tức tấn công
    protected boolean trongTamDanh(CuopBien cb) {
        int khoangCach = (int) Math.abs(cb.hitbox.x - hitbox.x);
        switch (loaiQV) {
            case Cua -> {
                return khoangCach <= 48;
            }
            case CaMap -> {
                return khoangCach <= 48 * 2;
            }
        }
        return false;
    }

    public void truMau(int mau) {
        mauHienTai -= mau;
        if (mauHienTai <= 0) {
            trangThaiMoi(Chet);
        } else {
            trangThaiMoi(BiTanCong);
            if (huongDi == Trai) {
                huongBiDayLui = Phai;
            } else {
                huongBiDayLui = Trai;
            }
            huongDayLui = Len;
            tocDoXuongKhiBiDayLui = 0;
        }
    }

    //kiểm tra nếu cướp biển bị tấn công thì trừ máu
    protected void cuopBienBiTanCong(Rectangle2D.Float attackBox, CuopBien cb) {
        if (attackBox.intersects(cb.hitbox)) {
            cb.capNhatMau(-SatThuong(loaiQV), this);
        } else {
            if (loaiQV == CaMap) {
                return;
            }
        }
        kiemTraTanCong = true;
    }

    public int daoX() {
        if (huongDi == Phai) {
            return w;
        } else {
            return 0;
        }
    }

    public int daoW() {
        if (huongDi == Phai) {
            return -1;
        } else {
            return 1;
        }
    }

    //làm mới(reset)
    public void lamMoi() {
        hitbox.x = x;
        hitbox.y = y;
        capNhatLanDau = true;
        mauHienTai = mauToiDa;
        trangThaiMoi(Dung);
        diChuyen = true;
        tocDoTrenKhong = 0;
        tocDoXuongKhiBiDayLui = 0;

    }

    public boolean dangDiChuyen() {
        return diChuyen;
    }

    public float getTocDoXuongKhiBiDayLui() {
        return tocDoXuongKhiBiDayLui;
    }

}
