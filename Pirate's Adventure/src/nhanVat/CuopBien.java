/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhanVat;
/**
 *
 * @author Admin
 */

import static phuongThucTaiSuDung.HangSo.CuopBien.*;
import static phuongThucTaiSuDung.PhuongThucXuLyXuKien.*;
import static phuongThucTaiSuDung.HangSo.Huong.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import amThanh.AmThanh;
import trangThai.Playing;
import phuongThucTaiSuDung.DocHinhAnh;

public class CuopBien extends PhuongThucChung_NhanVat {
    
    private Playing playing;

    private BufferedImage thanhMauNL;
    private BufferedImage[][] hoatAnh;
    private int[][] chatLieu;
    
    private float bu_X = 21 * 1.5f;
    private float bu_Y = 4 * 1.5f;

    private float tocDoNhay = -2.25f * 1.5f;
    private float giamTocDoSauVaCham = 0.5f * 1.5f;

    private int daoX = 0;
    private int daoW = 1;
    private int tileY = 0;

    private int chieuDai_MNL = (int) (192 * 1.5f);
    private int chieuCao_MNL = (int) (58 * 1.5f);
    private int X = (int) (10 * 1.5f);
    private int Y = (int) (10 * 1.5f);

    private int chieuDai_M = (int) (150 * 1.5f);
    private int chieuCao_M = (int) (4 * 1.5f);
    private int X_M = (int) (34 * 1.5f);
    private int Y_M = (int) (14 * 1.5f);
    private int mau = chieuDai_M;

    private int chieuDai_NL = (int) (104 * 1.5f);
    private int chieuCao_NL = (int) (2 * 1.5f);
    private int X_NL = (int) (44 * 1.5f);
    private int Y_NL = (int) (34 * 1.5f);
    private int nangLuong = chieuDai_NL;
    private int nangLuongToiDa = 200;
    private int nangLuongHienTai = nangLuongToiDa;
    
    private boolean diChuyen = false, tanCong = false;
    private boolean trai, phai, nhay;
    private boolean kiemTraTanCong;
    private boolean kiemTraTanCongBangNL;
    private int danhDauTanCongBangNL;
    private int danhDauTocDoTangNL;

    public CuopBien(float x, float y, int w, int h, Playing playing) {
        super(x, y, w, h);
        this.playing = playing;
        this.trangThai = Dung;
        this.mauToiDa = 100;
        this.mauHienTai = mauToiDa;
        this.tocDoDiChuyen = 1.5f * 1.0f;
        taiHoatAnh();
        khoiTaoHitbox(20, 27);
        khoiTaoAttackBox();
    }

    public void setViTri(Point viTri) {
        this.x = viTri.x;
        this.y = viTri.y;
        hitbox.x = x;
        hitbox.y = y;
    }

    private void khoiTaoAttackBox() {
        attackBox = new Rectangle2D.Float(x, y, (int) (35 * 1.5f), (int) (20 * 1.5f));
        datLaiAttackBox();
    }
    
    private void taiHoatAnh() {
        BufferedImage img = DocHinhAnh.LuuHinhAnh(DocHinhAnh.CUOP_BIEN);
        hoatAnh = new BufferedImage[7][8];
        for (int j = 0; j < hoatAnh.length; j++) {
            for (int i = 0; i < hoatAnh[j].length; i++) {
                hoatAnh[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
            }
        }

        thanhMauNL = DocHinhAnh.LuuHinhAnh(DocHinhAnh.THANH_MAU_NL);
    }

    public void taiChatLieuMap(int[][] chatLieu) {
        this.chatLieu = chatLieu;
        if (!DungTrenMatDat(hitbox, chatLieu)) {
            trenKhong = true;
        }
    }

    public void capNhat() {
        capNhatMau();
        capNhatNL();

        if (mauHienTai <= 0) {
            if (trangThai != Chet) {
                trangThai = Chet;
                aniT = 0;
                aniI = 0;
                playing.setCuopBienChet(true);
                playing.getGame().getAmThanh().batHieuUng(AmThanh.Chet);

                // Check if player died in air
                if (!DungTrenMatDat(hitbox, chatLieu)) {
                    trenKhong = true;
                    tocDoTrenKhong = 0;
                }
            } else if (aniI == ViTriHinhAnh(Chet) - 1 && aniT >= 25 - 1) {
                playing.setGameOver(true);
                playing.getGame().getAmThanh().dungNhacNen();
                playing.getGame().getAmThanh().batHieuUng(AmThanh.GAMEOVER);
            } else {
                capNhatHoatAnh();

                // r??i xu???ng n???u ??ang ??? tr??n kh??ng(nh???y)
                if (trenKhong) {
                    if (CoTheDiChuyenDen(hitbox.x, hitbox.y + tocDoTrenKhong, hitbox.width, hitbox.height, chatLieu)) {
                        hitbox.y += tocDoTrenKhong;
                        tocDoTrenKhong += 0.06;
                    } else {
                        trenKhong = false;
                    }
                }

            }

            return;
        }

        capNhatAttackBox();

        if (trangThai == BiTanCong) {
            if (aniI <= ViTriHinhAnh(trangThai) - 3) {
                dayLui(huongBiDayLui, chatLieu, 1.25f);
            }
            capNhatTocDoXuongKhiBiTanCong();
        } else {
            capNhatViTri();
        }

        if (diChuyen) {
            //ch???m v??o l??? thu???c
            playing.kiemTraNeuChamVaoLoThuoc(hitbox);
            //ch???m v??o b???y
            playing.kiemTraNeuChamVaoBay(this);
            //ch???m v??o m??t n?????c th?? m??u = 0;
            if (RoiXuongNuoc(hitbox, playing.getQuanLiLvl().getLvlHienTai().getChatLieu())) {
                mauHienTai = 0;
            }
            
            tileY = (int) (hitbox.y / 48);
            
            //kho???ng c??ch di chuyen khi dung power attack la 35
            if (kiemTraTanCongBangNL) {
                danhDauTanCongBangNL++;
                //kho???ng c??ch khi d??ng power t??ng 35
                if (danhDauTanCongBangNL >= 35) {
                    danhDauTanCongBangNL = 0;
                    kiemTraTanCongBangNL = false;
                }
            }
        }

        if (tanCong || kiemTraTanCongBangNL) {
            kiemTraTanCong();
        }

        capNhatHoatAnh();
        setHoatAnh();
    }

    private void kiemTraTanCong() {
        if (kiemTraTanCong || aniI != 1) {
            return;
        }
        kiemTraTanCong = true;

        if (kiemTraTanCongBangNL) {
            kiemTraTanCong = false;
        }

        playing.kiemTraQuaiVatBiTanCong(attackBox);
        playing.kiemTraTanCongVaoThung(attackBox);
        playing.getGame().getAmThanh().batHieuUngTanCong();
    }
    
    //?????t attackboc ??? b??n ph???i
    private void datAttackBoxOBenPhai() {
        attackBox.x = hitbox.x + hitbox.width - (int) (1.5f * 5);
    }

    //?????t attackboc ??? b??n tr??i
    private void datAttackBoxOBenTrai() {
        attackBox.x = hitbox.x - hitbox.width - (int) (1.5f * 10);
    }

    private void capNhatAttackBox() {
        if (phai && trai) {
            if (daoW == 1) {
                //?????t attackboc ??? b??n ph???i
                datAttackBoxOBenPhai();
            } else {
                //?????t attackboc ??? b??n tr??i
                datAttackBoxOBenTrai();
            }

        } else if (phai || (kiemTraTanCongBangNL && daoW == 1)) {
            datAttackBoxOBenPhai();
        } else if (trai || (kiemTraTanCongBangNL && daoW == -1)) {
            datAttackBoxOBenTrai();
        }

        attackBox.y = hitbox.y + (1.5f * 10);
    }

    private void capNhatMau() {
        mau = (int) ((mauHienTai / (float) mauToiDa) * chieuDai_M);
    }

    private void capNhatNL() {
        nangLuong = (int) ((nangLuongHienTai / (float) nangLuongToiDa) * chieuDai_NL);

        danhDauTocDoTangNL++;
        if (danhDauTocDoTangNL >= 15) {
            danhDauTocDoTangNL = 0;
            capNhatNangLuong(1);
        }
    }

    public void ve(Graphics g, int lvlOffset) {
        g.drawImage(hoatAnh[trangThai][aniI], 
                (int) (hitbox.x - bu_X) - lvlOffset + daoX,
                (int) (hitbox.y - bu_Y + (int) (tocDoXuongKhiBiDayLui)), 
                w * daoW, h, null);
		//veHitbox(g, lvlOffset);
		//veAttackBox(g, lvlOffset);
        veThanhMauNL(g);
    }

    private void veThanhMauNL(Graphics g) {
        // v??? h??nh ???nh thanh m??u n??ng l?????ng
        g.drawImage(thanhMauNL, X, Y, chieuDai_MNL, chieuCao_MNL, null);

        // v??? thanh m??u
        g.setColor(Color.red);
        g.fillRect(X_M + X, Y_M + Y, mau, chieuCao_M);

        // v??? thanh n??ng l?????ng
        g.setColor(Color.yellow);
        g.fillRect(X_NL + X, Y_NL + Y, nangLuong, chieuCao_NL);
    }

    private void capNhatHoatAnh() {
        aniT++;
        if (aniT >= 25) {
            aniT = 0;
            aniI++;
            if (aniI >= ViTriHinhAnh(trangThai)) {
                aniI = 0;
                tanCong = false;
                kiemTraTanCong = false;
                if (trangThai == BiTanCong) {
                    trangThaiMoi(Dung);
                    tocDoTrenKhong = 0f;
                    if (!LaMatDat(hitbox, 0, chatLieu)) {
                        trenKhong = true;
                    }
                }
            }
        }
    }

    private void setHoatAnh() {
        int hoatAnh = trangThai;

        if (trangThai == BiTanCong) {
            return;
        }

        if (diChuyen) {
            trangThai = DiChuyen;
        } else {
            trangThai = Dung;
        }

        if (trenKhong) {
            if (tocDoTrenKhong < 0) {
                trangThai = Nhay;
            } else {
                trangThai = Roi;
            }
        }

        if (kiemTraTanCongBangNL) {
            trangThai = TanCong;
            aniI = 1;
            aniT = 0;
            return;
        }

        if (tanCong) {
            trangThai = TanCong;
            if (hoatAnh != TanCong) {
                aniI = 1;
                aniT = 0;
                return;
            }
        }
        if (hoatAnh != trangThai) {
            datLaiHoatAnh();
        }
    }

    private void datLaiHoatAnh() {
        aniT = 0;
        aniI= 0;
    }

    private void capNhatViTri() {
        diChuyen = false;

        if (nhay) {
            nhay();
        }

        if (!trenKhong) {
            if (!kiemTraTanCongBangNL) {
                if ((!trai && !phai) || (phai && trai)) {
                    return;
                }
            }
        }

        float xSpeed = 0;

        if (trai && !phai) {
            xSpeed -= tocDoDiChuyen;
            daoX = w;
            daoW = -1;
        }
        if (phai && !trai) {
            xSpeed += tocDoDiChuyen;
            daoX = 0;
            daoW = 1;
        }

        if (kiemTraTanCongBangNL) {
            if ((!trai && !phai) || (trai && phai)) {
                if (daoW == -1) {
                    xSpeed = -tocDoDiChuyen;
                } else {
                    xSpeed = tocDoDiChuyen;
                }
            }
            
            //t???c ????? di chuy???n khi d??ng power attack t??ng 3 l???n so v???i attack bth
            xSpeed *= 3;
        }

        if (!trenKhong) {
            if (!DungTrenMatDat(hitbox, chatLieu)) {
                trenKhong = true;
            }
        }

        if (trenKhong && !kiemTraTanCongBangNL) {
            if (CoTheDiChuyenDen(hitbox.x, hitbox.y + tocDoTrenKhong, hitbox.width, hitbox.height, chatLieu)) {
                hitbox.y += tocDoTrenKhong;
                tocDoTrenKhong += 0.06;
                capNhatViTri(xSpeed);
            } else {
                hitbox.y = ViTri_KhiRoiXuong(hitbox, tocDoTrenKhong);
                if (tocDoTrenKhong > 0) {
                    datLaiTrangThaiTrenMatDat();
                } else {
                    tocDoTrenKhong = giamTocDoSauVaCham;
                }
                capNhatViTri(xSpeed);
            }

        } else {
            capNhatViTri(xSpeed);
        }
        diChuyen = true;
    }

    //nh???y
    private void nhay() {
        if (trenKhong) {
            return;
        }
        playing.getGame().getAmThanh().batHieuUng(AmThanh.Nhay);
        trenKhong = true;
        tocDoTrenKhong = tocDoNhay;
    }

    private void datLaiTrangThaiTrenMatDat() {
        trenKhong = false;
        tocDoTrenKhong = 0;
    }

    private void capNhatViTri(float xSpeed) {
        if (CoTheDiChuyenDen(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, chatLieu)) {
            hitbox.x += xSpeed;
        } else {
            hitbox.x = ViTri_KhiNhanVatDungCanhTuong(hitbox, xSpeed);
            //ch???m t?????ng th?? ko th???c hi???n t???n c??ng b???ng nl
            if (kiemTraTanCongBangNL) {
                kiemTraTanCongBangNL = false;
                danhDauTanCongBangNL = 0;
            }
        }
    }
    
    public void tanCongBangNangLuong() {
        if (kiemTraTanCongBangNL) {
            return;
        }
        if (nangLuongHienTai >= 60) {
            kiemTraTanCongBangNL = true;
            capNhatNangLuong(-60);
        }
    }
    
    public void capNhatNangLuong(int nl) {
        nangLuongHienTai += nl;
        nangLuongHienTai = Math.max(Math.min(nangLuongHienTai, nangLuongToiDa), 0);
    }

    public void capNhatMau(int mau) {
        if (mau < 0) {
            if (trangThai == BiTanCong) {
                return;
            } else {
                trangThaiMoi(BiTanCong);
            }
        }

        mauHienTai += mau;
        mauHienTai = Math.max(Math.min(mauHienTai, mauToiDa), 0);
    }

    public void capNhatMau(int mau, QuaiVat e) {
        if (trangThai == BiTanCong) {
            return;
        }
        capNhatMau(mau);
        huongBiDayLui = Len;
        tocDoXuongKhiBiDayLui = 0;

        if (e.getHitbox().x < hitbox.x) {
            huongBiDayLui = Phai;
        } else {
            huongBiDayLui = Trai;
        }
    }

    public void kill() {
        mauHienTai = 0;
    }

    public void datLaiHuong() {
        trai = false;
        phai = false;
    }

    public void datLaiTatCa() {
        datLaiHuong();
        trenKhong = false;
        tanCong = false;
        diChuyen = false;
        tocDoTrenKhong = 0f;
        trangThai = Dung;
        mauHienTai = mauToiDa;
        kiemTraTanCongBangNL = false;
        danhDauTanCongBangNL = 0;
        nangLuongHienTai = nangLuongToiDa;

        hitbox.x = x;
        hitbox.y = y;
        datLaiAttackBox();

        if (!DungTrenMatDat(hitbox, chatLieu)) {
            trenKhong = true;
        }
    }

    private void datLaiAttackBox() {
        if (daoW == 1) {
            datAttackBoxOBenPhai();
        } else {
            datAttackBoxOBenTrai();
        }
    }

    public int getTileY() {
        return tileY;
    }

    
    public void setTanCong(boolean tanCong) {
        this.tanCong = tanCong;
    }

    public boolean isTrai() {
        return trai;
    }

    public void setTrai(boolean trai) {
        this.trai = trai;
    }

    public boolean isPhai() {
        return phai;
    }

    public void setPhai(boolean phai) {
        this.phai = phai;
    }

    public void setNhay(boolean nhay) {
        this.nhay = nhay;
    }
    
}
